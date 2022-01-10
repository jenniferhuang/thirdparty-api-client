package com.thirdparty.developer.service.zoom

import com.thirdparty.developer.ClientInfo
import com.thirdparty.developer.model.zoom.ZoomMeetingObjectDTO
import com.thirdparty.developer.service.zoom.interfaces.IZoomMeetingService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.Key
import java.text.MessageFormat
import java.util.*

//https://marketplace.zoom.us/docs/api-reference/zoom-api
class ZoomApiClient(var clientInfo: ClientInfo) {

    protected val retrofit: Retrofit
    val iZoomMeetingService: IZoomMeetingService
    private lateinit var token: String

    protected val headerAuthorizationBearerInterceptor = Interceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", authorizationHeaderBearer())
            .build()
        chain.proceed(newRequest)
    }

    init {
        val okHttpClientBearer =
            OkHttpClient().newBuilder().addInterceptor(headerAuthorizationBearerInterceptor).build()
        retrofit = Retrofit.Builder()
            .client(okHttpClientBearer)
            .baseUrl(clientInfo.serverUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        iZoomMeetingService = retrofit.create(IZoomMeetingService::class.java)
    }

    fun scheduleZoomMeeting(zoomMeetingObjectDTO: ZoomMeetingObjectDTO): ZoomMeetingObjectDTO? {
        val call = iZoomMeetingService.createZoomMeeting("me", zoomMeetingObjectDTO)
        return call.execute().body()
    }

    fun getZoomInvitation(meetingId: String): Any? {
        val call = iZoomMeetingService.zoomMeetingInvitation(meetingId)
        return call.execute().body()
    }

    fun getZoomMeeting(meetingId: String): Any? {
        val call = iZoomMeetingService.getZoomMeeting(meetingId)
        return call.execute().body()
    }


    fun generateZoomJWTToken() {
        val id = UUID.randomUUID().toString().replace("-", "")
        val signatureAlgorithm = SignatureAlgorithm.HS256
        val creation = Date(System.currentTimeMillis())
        val tokenExpiry = Date(System.currentTimeMillis() + 1000 * 60 * 60)
        val key: Key = Keys.hmacShaKeyFor(clientInfo.clientSecret.toByteArray())
        token = Jwts.builder()
            .setId(id)
            .setIssuer(clientInfo.clientKey)
            .setIssuedAt(creation)
            .setSubject("")
            .setExpiration(tokenExpiry)
            .signWith(key, signatureAlgorithm)
            .compact()
    }

    protected fun authorizationHeaderBearer() = MessageFormat.format("Bearer {0}", this.token)

}
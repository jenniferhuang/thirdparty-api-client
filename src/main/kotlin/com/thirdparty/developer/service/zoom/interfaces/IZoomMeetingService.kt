package com.thirdparty.developer.service.zoom.interfaces

import com.thirdparty.developer.model.zoom.ZoomMeetingObjectDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

//https://marketplace.zoom.us/docs/api-reference/zoom-api/meetings/meetingcreate
interface IZoomMeetingService {
    @POST("v2/users/{zoomUserId}/meetings")
    fun createZoomMeeting(
        @Path("zoomUserId") zoomUserId: String, @Body zoomMeetingObjectDTO: ZoomMeetingObjectDTO
    ): Call<ZoomMeetingObjectDTO>

    @GET("v2/meetings/{meetingId}/invitation")
    fun zoomMeetingInvitation(@Path("meetingId") meetingId: String): Call<Any>


    @GET("v2/meetings/{meetingId}")
    fun getZoomMeeting(@Path("meetingId") meetingId: String): Call<Any>


}
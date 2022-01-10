package com.thirdparty.developer.service.google

import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.gson.GsonFactory
import com.google.api.client.util.store.FileDataStoreFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import java.io.FileNotFoundException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*


/**
 * Created by jennifer.huang on 2022/1/8.
 */
class GoogleClient {

    //https://developers.google.com/sheets/api/quickstart/java
    //https://console.cloud.google.com/apis/credentials?authuser=3&project=quickestart;  account: meetingtestjennifer@gmail.com
    private val APPLICATION_NAME = "Desktop client 1"
    private val JSON_FACTORY: JsonFactory = GsonFactory.getDefaultInstance()
    private val TOKENS_DIRECTORY_PATH = "tokens"

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private val SCOPES: List<String> = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY)
    private val CREDENTIALS_FILE_PATH = "/googleCredentialJennifer.json"

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private fun getCredentials(HTTP_TRANSPORT: NetHttpTransport): Credential? {
        // Load client secrets.
        val inputStream: InputStream = GoogleClient::class.java.getResourceAsStream(CREDENTIALS_FILE_PATH)
            ?: throw FileNotFoundException("Resource not found: $CREDENTIALS_FILE_PATH")
        val clientSecrets: GoogleClientSecrets = GoogleClientSecrets.load(JSON_FACTORY, InputStreamReader(inputStream))

        // Build flow and trigger user authorization request.
        val flow: GoogleAuthorizationCodeFlow =
            GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(FileDataStoreFactory(java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        val receiver: LocalServerReceiver = LocalServerReceiver.Builder().setPort(8888).build()
        return AuthorizationCodeInstalledApp(flow, receiver).authorize("user")
    }

    fun getGoolgeSheetClient(): Sheets {
        val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
        val service = Sheets.Builder(
            HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT)
        ).setApplicationName(APPLICATION_NAME)
            .build()
        return service
    }
}
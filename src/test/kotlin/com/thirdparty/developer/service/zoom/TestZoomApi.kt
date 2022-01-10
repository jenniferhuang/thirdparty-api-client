package com.thirdparty.developer.service.zoom

import com.google.gson.Gson
import com.thirdparty.developer.ClientInfo
import org.junit.Assert
import org.junit.Test

class TestZoomApi {
    lateinit var clientInfo: ClientInfo
    lateinit var zoomApiClient: ZoomApiClient


//    @Before
    fun initial() {
        //Fixme:  wait the licensed account
        clientInfo = ClientInfo("KnjSYLUxuNr2iCahemKP56mmDqna6ZOFOwzQ", "xxx-toupdate", "https://api.zoom.us")
        zoomApiClient = ZoomApiClient(clientInfo)
        zoomApiClient.generateZoomJWTToken()
    }

    @Test
    fun testCreateZoomMeeting() {
        val s = "Paul Lai is inviting you to a scheduled Zoom meeting.\n" +
                "\n" +
                "Topic: Rooms test Zoom Meeting\n" +
                "Time: Jan 5, 2022 18:00 Beijing, Shanghai\n" +
                "\n" +
                "Join Zoom Meeting\n" +
                "https://rcwebinar.zoom.us/j/91965709975?pwd=alRHbDl5RVZFelk5bHZTZEtOTURhUT09\n" +
                "\n" +
                "Meeting ID: 919 6570 9975\n" +
                "Passcode: 414376\n" +
                "One tap mobile\n" +
                "+13126266799,,91965709975#,,,,*414376# US (Chicago)\n" +
                "+13462487799,,91965709975#,,,,*414376# US (Houston)\n" +
                "\n" +
                "Dial by your location\n" +
                "        +1 312 626 6799 US (Chicago)\n" +
                "        +1 346 248 7799 US (Houston)\n" +
                "        +1 470 250 9358 US (Atlanta)\n" +
                "        +1 470 381 2552 US (Atlanta)\n" +
                "        +1 602 753 0140 US (Phoenix)\n" +
                "        +1 646 518 9805 US (New York)\n" +
                "        +1 646 558 8656 US (New York)\n" +
                "        +1 651 372 8299 US (Minnesota)\n" +
                "        +1 669 219 2599 US (San Jose)\n" +
                "        +1 669 900 6833 US (San Jose)\n" +
                "        +1 720 928 9299 US (Denver)\n" +
                "        +1 786 635 1003 US (Miami)\n" +
                "        +1 971 247 1195 US (Portland)\n" +
                "        +1 206 337 9723 US (Seattle)\n" +
                "        +1 213 338 8477 US (Los Angeles)\n" +
                "        +1 253 215 8782 US (Tacoma)\n" +
                "        +1 267 831 0333 US (Philadelphia)\n" +
                "        +1 301 715 8592 US (Washington DC)\n" +
                "Meeting ID: 919 6570 9975\n" +
                "Passcode: 414376\n" +
                "Find your local number: https://rcwebinar.zoom.us/u/avLZaFsSn\n" +
                "\n" +
                "Join by SIP\n" +
                "91965709975@zoomcrc.com\n" +
                "\n" +
                "Join by H.323\n" +
                "162.255.37.11 (US West)\n" +
                "162.255.36.11 (US East)\n" +
                "115.114.131.7 (India Mumbai)\n" +
                "115.114.115.7 (India Hyderabad)\n" +
                "213.19.144.110 (Amsterdam Netherlands)\n" +
                "213.244.140.110 (Germany)\n" +
                "103.122.166.55 (Australia Sydney)\n" +
                "103.122.167.55 (Australia Melbourne)\n" +
                "209.9.211.110 (Hong Kong SAR)\n" +
                "64.211.144.160 (Brazil)\n" +
                "69.174.57.160 (Canada Toronto)\n" +
                "65.39.152.160 (Canada Vancouver)\n" +
                "207.226.132.110 (Japan Tokyo)\n" +
                "149.137.24.110 (Japan Osaka)\n" +
                "Meeting ID: 919 6570 9975\n" +
                "Passcode: 414376\n" +
                "\n" +
                "Join by Skype for Business\n" +
                "https://rcwebinar.zoom.us/skype/91965709975\n" +
                "\n" +
                "Test\n" +
                "\n"
        println(s)

//        val zoomMeetingObjectDTO = ZoomMeetingObjectDTO()
//        zoomMeetingObjectDTO.topic = "TestZoomSchedule6"
//        zoomMeetingObjectDTO.type = 2
//        zoomMeetingObjectDTO.start_time = "2021-12-30T08:00:00Z"
//        zoomMeetingObjectDTO.timezone = "Asia/Shanghai"
//        zoomMeetingObjectDTO.password = ""
//        zoomMeetingObjectDTO.h323_password = ""
//        val test = zoomApiClient.scheduleZoomMeeting(zoomMeetingObjectDTO)
//        println(Gson().toJson(test))
//        println("done")
//
//
//        val test2 = zoomApiClient.getZoomInvitation(zoomMeetingObjectDTO.id.toString())
//        println(Gson().toJson(test2))
    }

    @Test
    fun testZoomToken() {
        val token = zoomApiClient.generateZoomJWTToken()
        Assert.assertNotNull(token)
    }

    @Test
    fun testZoomInvitation() {
        val test = zoomApiClient.getZoomInvitation("95310702987")
        println(Gson().toJson(test))
    }


    @Test
    fun testZoomMeeting() {
        val test = zoomApiClient.getZoomMeeting("6502413360")
        println(Gson().toJson(test))
    }

}
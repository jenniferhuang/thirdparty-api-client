package com.thirdparty.developer.model.zoom

class ZoomMeetingSettingsDTO {
    var host_video: Boolean? = null

    var participant_video: Boolean? = null

    var cn_meeting: Boolean? = null

    var in_meeting: Boolean? = null

    var join_before_host: Boolean? = null

    var mute_upon_entry: Boolean? = null

    var watermark: Boolean? = null

    var use_pmi: Boolean? = null

    var approval_type: Int? = null

    var registration_type: Int? = null

    var audio: String? = null

    var auto_recording: String? = null

    var alternative_hosts: String? = null

    var close_registration: Boolean? = null

    var waiting_room: Boolean? = null

    var global_dial_in_countries: List<String>? = null

    var registrants_email_notification: Boolean? = null

    var contact_name: String? = null

    var contact_email: String? = null

    var registrants_confirmation_email: Boolean? = null

    var meeting_authentication: Boolean? = null

    var authentication_option: String? = null

    var authenticated_domains: String? = null

    var authentication_name: String? = null

    var show_share_button: Boolean? = null

    var allow_multiple_devices: Boolean? = null

    var encryption_type: String? = null
}
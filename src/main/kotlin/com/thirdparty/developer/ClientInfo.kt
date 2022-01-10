package com.thirdparty.developer

data class ClientInfo(var clientKey: String, var clientSecret: String, var serverUrl: String) {
    var userId: String? = null
}
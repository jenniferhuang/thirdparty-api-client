//package com.thirdparty.developer.utils
//
//import okhttp3.logging.HttpLoggingInterceptor
//
///**
// * Created by jennifer.huang on 2/14/20.
// */
//object CustomHttpLoggingInterceptor {
//    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
//        val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
//            override fun log(msg: String) = println(msg)
//        })
//        httpLoggingInterceptor.level = httpLoggerLevel
//        return httpLoggingInterceptor
//    }
//
//    private val httpLoggerLevel: HttpLoggingInterceptor.Level
//        get() {
//            val level = System.getProperty("api.log.level", "BASIC").toUpperCase()
//            when (level) {
//                "NONE" -> return HttpLoggingInterceptor.Level.NONE
//                "BASIC" -> return HttpLoggingInterceptor.Level.BASIC
//                "HEADERS" -> return HttpLoggingInterceptor.Level.HEADERS
//                "BODY" -> return HttpLoggingInterceptor.Level.BODY
//                else -> {
//                    println("api.log.level value is invalid, use basic by default.")
//                    return HttpLoggingInterceptor.Level.BASIC
//                }
//            }
//        }
//
//
//}
//

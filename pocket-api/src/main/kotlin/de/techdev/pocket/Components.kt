package de.techdev.pocket

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient

/**
 * Created by Willi on 11.11.2016.
 * Implementation of OkClient Stuff
 */

internal object Components {

    fun client(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(PocketInterceptor).build()
    }

    fun mapper(): ObjectMapper {
        return jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    fun transport(consumer: String, access: String): Transport {
        return Transport(client(), mapper(), consumer, access)
    }
}

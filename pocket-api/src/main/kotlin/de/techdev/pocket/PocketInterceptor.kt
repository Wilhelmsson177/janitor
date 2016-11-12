package de.techdev.pocket

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Willi on 11.11.2016.
 * An interseptor implementation.
 */

internal object PocketInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        builder.header("X-Accept", "application/json")
        builder.header("Content-Type", "application/json; charset=UTF-8")

        return chain.proceed(builder.build())
    }
}

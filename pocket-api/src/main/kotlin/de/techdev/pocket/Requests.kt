package de.techdev.pocket

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Willi on 11.11.2016.
 * A simple Request implementation.
 */
internal open class PocketRequest {
    @JsonProperty("access_token") lateinit var access: String
    @JsonProperty("consumer_key") lateinit var consumer: String

    internal class Retrieve(val state: String, val sort: String, @JsonProperty("detailType") val details: String) : PocketRequest()

}

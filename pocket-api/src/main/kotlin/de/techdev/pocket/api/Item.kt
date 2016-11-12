package de.techdev.pocket.api

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Willi on 11.11.2016.
 * The basic item class.
 */

data class Item(
        @JsonProperty("item_id") val id: Long,
        @JsonProperty("time_added") val added: Long,
        @JsonProperty("resolved_title") val title: String) {

}
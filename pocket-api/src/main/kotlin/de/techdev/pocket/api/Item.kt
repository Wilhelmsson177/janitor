package de.techdev.pocket.api

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Representation of the Pocket Item.
 *
 * @author Willi Meierhof
 */

data class Item(
        @JsonProperty("item_id") val id: Long,
        @JsonProperty("time_added") val added: Long,
        @JsonProperty("resolved_title") val title: String) {

}
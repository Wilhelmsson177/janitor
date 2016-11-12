package de.techdev.pocket

import com.fasterxml.jackson.annotation.JsonProperty
import de.techdev.pocket.api.Item

/**
 * Created by Willi on 11.11.2016.
 * Implementation of the Pocket Responses.
 */
internal class RetrieveResponse(@JsonProperty("list") val items: Map<Int, Item>)

internal class ModifyResponse(@JsonProperty("status") val status: Int)

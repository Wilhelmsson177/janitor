package de.techdev.pocket

import com.fasterxml.jackson.annotation.JsonProperty
import de.techdev.pocket.api.Item

/**
 * Created by Willi on 12.11.2016.
 * All actions
 */
internal sealed class Action(name: String, item: Item) {
    @JsonProperty("action") var name: String = name
    @JsonProperty("item_id") var id: Long = item.id

    class Archive(item: Item) : Action("archive", item)
    class Delete(item: Item) : Action("delete", item)
}
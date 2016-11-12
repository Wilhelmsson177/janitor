package de.techdev.pocket

import de.techdev.pocket.api.Item
import de.techdev.pocket.api.ModifyOperations

/**
 * Created by Willi on 11.11.2016.
 */
internal class ModifyTemplate(private val transport: Transport) : ModifyOperations {

    private var endpoint = "https://getpocket.com/v3/get"

    constructor(transport: Transport, endpoint: String) : this(transport) {
        this.endpoint = endpoint
    }

    private fun execute(actions: Collection<Action>) {
        transport.post<ModifyResponse>(PocketRequest.ModifyRequest(actions), "https://getpocket.com/v3/send")
    }

    override fun archive(items: Collection<Item>) {
        execute(items.map { Action.Archive(it) })
    }

    override fun delete(items: Collection<Item>) {
        execute(items.map { Action.Delete(it) })
    }
}
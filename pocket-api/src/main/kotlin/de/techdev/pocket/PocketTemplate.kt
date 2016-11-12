package de.techdev.pocket

import de.techdev.pocket.api.ModifyOperations
import de.techdev.pocket.api.Pocket
import de.techdev.pocket.api.RetrieveOperations

/**
 * Created by Willi on 11.11.2016.
 */

internal class PocketTemplate(consumer: String, access: String) : Pocket {
    private val modifyOperations: ModifyOperations
    private val retrieveOperations: RetrieveOperations

    init {
        val transport = Components.transport(consumer, access)
        modifyOperations = ModifyTemplate(transport)
        retrieveOperations = RetrieveTemplate(transport)
    }

    override fun modifyOperations() = modifyOperations
    override fun retrieveOperations() = retrieveOperations
}
package de.techdev.pocket.api

import de.techdev.pocket.PocketTemplate

/**
 * Created by Willi on 11.11.2016.
 */

interface Pocket {
    fun modifyOperations(): ModifyOperations

    fun retrieveOperations(): RetrieveOperations

    companion object {
        fun connect(): Pocket = PocketTemplate()
    }
}
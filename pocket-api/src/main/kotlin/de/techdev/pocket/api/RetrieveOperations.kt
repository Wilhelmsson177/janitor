package de.techdev.pocket.api

/**
 * Created by Willi on 11.11.2016.
 */

interface RetrieveOperations {
    fun items(state: State = State.UNREAD, sort: Sort = Sort.OLDEST, details: Details = Details.SIMPLE): Collection<Item> = emptyList()
}
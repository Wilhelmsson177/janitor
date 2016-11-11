package de.techdev.pocket.api

/**
 * Created by Willi on 11.11.2016.
 * Enum class of State.
 */

enum class State(internal val value: String) {
    UNREAD("unread"), ARCHIVE("archive"), ALL("all")
}
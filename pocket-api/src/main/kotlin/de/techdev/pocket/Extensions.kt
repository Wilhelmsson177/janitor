package de.techdev.pocket

import de.techdev.pocket.api.PocketException
import okhttp3.Response

/**
 * Created by Willi on 11.11.2016.
 * Exentsions implementations.
 */
internal fun Response.validate() {
    if (isSuccessful.not()) {
        throw PocketException("{header('X-Error')} [status ${code()}]")
    }
}
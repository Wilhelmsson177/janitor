package de.techdev.pocket.api

import de.techdev.pocket.Components
import de.techdev.pocket.ModifyTemplate
import de.techdev.pocket.RetrieveTemplate
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExternalResource
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.assertFailsWith

/**
 * Created by Willi on 12.11.2016.
 * Testmodule for pocket api.
 */

class PocketTest {

    var server = MockWebServer()

    private fun pocket(): Pocket {
        val pocket = mock(Pocket::class.java)
        val transport = Components.transport("consumer", "access")
        `when`(pocket.modifyOperations()).thenReturn(ModifyTemplate(transport, server.url("/v3/send").toString()))
        `when`(pocket.retrieveOperations()).thenReturn(RetrieveTemplate(transport, server.url("/v3/get").toString()))

        return pocket
    }

    @Rule @JvmField
    val resource = object : ExternalResource() {
        override fun before() = server.start()
        override fun after() = server.shutdown()
    }

    private fun error(code: Int, message: String): MockResponse {
        val response = MockResponse()
        response.setResponseCode(code)
        response.setHeader("X-Error", message)
        return response
    }

    @Test
    fun `given a bad request, PocketException is thrown`() {
        server.enqueue(error(400, "Missing API Key"))

        assertFailsWith<PocketException> {
            pocket().retrieveOperations().items()
        }
    }
}

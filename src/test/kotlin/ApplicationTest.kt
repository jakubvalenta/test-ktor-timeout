package com.example

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun `ktor timeout`() = runTest {
        val client = HttpClient( MockEngine { respondOk("") } ) {
            install(HttpTimeout) {
                requestTimeoutMillis = 60_000
            }
        }
        val res = client.get("/")
        assertEquals(HttpStatusCode.OK, res.status)
    }
}

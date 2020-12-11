package com.cyberinsane.kmm_jetflix.shared

import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_VERSION = "3"
private const val API_KEY_KEY = "api_key"
private const val API_KEY_VALUE = "3298880137172cea814f46805f3df4fe"

class JetflixApi {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getPopular() = httpClient.get<ShowResult> { path("/tv/popular") }
}

fun HttpRequestBuilder.path(path: String, params: List<Pair<String, Any?>>? = null) {
    // header(HttpHeaders.CacheControl, "no-cache")
    url {
        takeFrom(BASE_URL)
        encodedPath = API_VERSION + path
        params?.forEach { parameter(it.first, it.second) }
        parameter(API_KEY_KEY, API_KEY_VALUE)
    }
}
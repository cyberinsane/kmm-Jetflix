package com.cyberinsane.kmm_jetflix.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShowResult(
    @SerialName("results")
    val shows: List<Show>?
)
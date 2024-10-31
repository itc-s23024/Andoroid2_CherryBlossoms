package jp.ac.it_college.std.s23024.cherryblossoms.model

import kotlinx.serialization.Serializable

@Serializable
data class Cherry(
    val wiki: String,
    val name: String,
    val pref: String,
    val longitude: String,
    val latitude: String,
)

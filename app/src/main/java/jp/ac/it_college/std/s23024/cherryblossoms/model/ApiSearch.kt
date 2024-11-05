package jp.ac.it_college.std.s23024.cherryblossoms.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiSearch(
    val ns: Int,
    val title: String,
    val pageid: Int,
    val size: Int,
    val wordcount: Int,
    val snippet: String,
    val timestamp: String,
)

package jp.ac.it_college.std.s23024.cherryblossoms.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fuel.Fuel
import fuel.get
import fuel.serialization.toJson
import jp.ac.it_college.std.s23024.cherryblossoms.model.ApiResult
import jp.ac.it_college.std.s23024.cherryblossoms.model.ApiSearch
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class DataViewModel : ViewModel(){
    var cherryList = mutableStateListOf<ApiSearch>()

    fun query() {
        viewModelScope.launch {
            val result = Fuel.get(
                """
                    https://ja.wikipedia.org/w/api.php?
                    action=query&format=json&prop=images&list=search&formatversion=2&
                    imlimit=1&srsearch=桜の名所&srlimit=500 
                """.trimIndent().replace(System.lineSeparator(),"")
            ).toJson(
                json = Json { ignoreUnknownKeys = true },
                deserializationStrategy = ApiResult.serializer()
            ).get()
            if (result == null) return@launch
            cherryList.apply {
                clear()
                addAll(result.query.search)
            }
        }
    }
}
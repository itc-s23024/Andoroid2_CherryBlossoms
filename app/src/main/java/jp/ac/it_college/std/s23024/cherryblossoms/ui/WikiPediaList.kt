package jp.ac.it_college.std.s23024.cherryblossoms.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s23024.cherryblossoms.model.ApiSearch

@Composable
fun WikipediaList(
    modifier: Modifier = Modifier,
    list: List<ApiSearch>?,
    onSelected: (ApiSearch) -> Unit
    ) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        list?.let {
            items(it.size) { index ->
                WikipediaRow(search = it[index], onSelected = onSelected)
            }
        }
    }
}
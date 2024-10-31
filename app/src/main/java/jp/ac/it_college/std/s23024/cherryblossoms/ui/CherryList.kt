package jp.ac.it_college.std.s23024.cherryblossoms.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s23024.cherryblossoms.R
import jp.ac.it_college.std.s23024.cherryblossoms.model.Cherry

@Composable
fun CherryList(
    modifier: Modifier = Modifier,
    cherryList: List<Cherry>,
    onSelected: (Cherry) -> Unit = {}
    ) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredList = cherryList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = modifier) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text(text = stringResource(R.string.search)) },
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            items(filteredList.size) { index ->
                CherryRow(
                    cherry = filteredList[index],
                    onSelected = { onSelected(it) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun CherryListPreview() {
    val cherryList = listOf(
        Cherry("北海道", "函館公園", "北海道", "41.768793", "140.729086"),
        Cherry("岩手県", "岩手県立学校", "岩手県", "39.703531", "141.152667"),
        Cherry("宮城県", "石巻川桜まつり", "宮城県", "38.450000", "141.300000"),
    )
    CherryList(cherryList = cherryList)
}
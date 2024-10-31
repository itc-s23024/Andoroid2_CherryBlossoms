package jp.ac.it_college.std.s23024.cherryblossoms

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.ac.it_college.std.s23024.cherryblossoms.model.Cherry
import jp.ac.it_college.std.s23024.cherryblossoms.ui.theme.CherryBlossomsTheme
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CherryBlossomsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val jsonString = getJson(resources)
                    val cherryList = getCherryList(jsonString)
                    Column(modifier = Modifier.padding(innerPadding)) {
                        cherryList.forEach { cherry ->
                            Row {
                                Text(text = cherry.name)
                                Text(text = "${cherry.longitude}, ${cherry.latitude}")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getCherryList(str: String): List<Cherry> =
        Json.decodeFromString<List<Cherry>>(str)

    private fun getJson(resources: Resources): String =
        resources.assets.open("100Cherry_List.json").reader().readText()
}

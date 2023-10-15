package androidx.compose.samples.scrollgoodperformancecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.samples.scrollgoodperformancecompose.ui.theme.ScrollGoodPerformanceComposeTheme
import androidx.compose.ui.unit.dp

data class WellnessTask(val id: Int, val label: String)

private fun getWellnessTasks() = List(200) { i -> WellnessTask(i, "Task # $i") }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollGoodPerformanceComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(getWellnessTasks())
                }
            }
        }
    }
}

@Composable
fun Greeting(
    list: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn (
        modifier = Modifier
    ) {
        items(list) { task ->
            Text(
                modifier = Modifier.padding(vertical=10.dp),
                text = task.label
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScrollGoodPerformanceComposeTheme {
        Greeting(getWellnessTasks())
    }
}
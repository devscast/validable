package tech.devscast.validable

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.devscast.validable.lib.InputContent
import tech.devscast.validable.lib.validable
import tech.devscast.validable.ui.theme.ValidableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValidableTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FormSection()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ValidableTheme {
        Greeting("Android")
    }
}


@Composable
fun FormSection() {
    var text by validable(initialValue = "yv", rules = {
        isNotEmpty()
    })



    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.Center),
            value = text.value,
            onValueChange = { text = text.withNewValue(it) },
            isError = text.errors.isNotEmpty(),

            )
        Button(onClick = {
            text.submit {
                Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                Toast.makeText(context,text.errors.isEmpty().toString(),Toast.LENGTH_SHORT).show()
            }

        }) {
            Text(text = "Submit")
        }
    }
}
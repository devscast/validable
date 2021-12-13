package tech.devscast.validable_sample.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.devscast.validable.NotEmptyValidable
import tech.devscast.validable.delegates.validableEmail
import tech.devscast.validable.withValidable


@ExperimentalAnimationApi
@Composable
fun InputScreen() {

    val context = LocalContext.current

    val emailField by validableEmail()
    val nameField = remember { NotEmptyValidable() }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {

        TextField(
            value = emailField.value,
            onValueChange = { emailField.value = it },
            isError = emailField.hasError(),
            modifier = Modifier.fillMaxWidth()
        )
        AnimatedVisibility(visible = emailField.hasError()) {
            TextFieldError(textError = emailField.errorMessage ?: "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nameField.value,
            onValueChange = { nameField.value = it },
            isError = nameField.hasError(),
            modifier = Modifier.fillMaxWidth()
        )

        AnimatedVisibility(visible = nameField.hasError()) {
            TextFieldError(textError = nameField.errorMessage ?: "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            withValidable(emailField,nameField) {
                Toast.makeText(context,"All fields are valid",Toast.LENGTH_SHORT).show()
            }

        }) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun TextFieldError(textError: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = textError,
            modifier = Modifier.fillMaxWidth(),
            style = LocalTextStyle.current.copy(color = MaterialTheme.colors.error)
        )
    }
}

@Preview
@ExperimentalAnimationApi
@Composable
fun InputScreenPreview() {
    InputScreen()
}
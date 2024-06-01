package tech.devscast.validable.sample.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.devscast.validable.CardScheme
import tech.devscast.validable.CardSchemeValidable
import tech.devscast.validable.EmailValidable
import tech.devscast.validable.HostnameValidable
import tech.devscast.validable.NotEmptyValidable
import tech.devscast.validable.RegexValidable
import tech.devscast.validable.UrlValidable
import tech.devscast.validable.withValidable

@ExperimentalAnimationApi
@Composable
fun InputScreen() {
    val context = LocalContext.current

    val emailField = remember { EmailValidable() }
    val nameField = remember { NotEmptyValidable() }

    val cardField = remember { CardSchemeValidable(CardScheme.MasterCard) }

    val urlField = remember {
        UrlValidable()
    }

    val hostnameField = remember {
        HostnameValidable()
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp)
    ) {
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            label = { Text("Email address", style = MaterialTheme.typography.labelLarge) },
            value = emailField.value,
            onValueChange = { emailField.value = it },
            isError = emailField.hasError(),
            modifier = Modifier.fillMaxWidth()
        )
        AnimatedVisibility(visible = emailField.hasError()) {
            TextFieldError(textError = emailField.errorMessage ?: "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            label = { Text(text = "Username", style = MaterialTheme.typography.labelLarge) },
            value = nameField.value,
            onValueChange = { nameField.value = it },
            isError = nameField.hasError(),
            modifier = Modifier.fillMaxWidth()
        )

        AnimatedVisibility(visible = nameField.hasError()) {
            TextFieldError(textError = nameField.errorMessage ?: "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            label = {
                Text(text = "Card credit number", style = MaterialTheme.typography.labelLarge)
            },
            value = cardField.value,
            onValueChange = { cardField.value = it },
            isError = cardField.hasError(),
            modifier = Modifier.fillMaxWidth()
        )

        AnimatedVisibility(visible = cardField.hasError()) {
            Log.d(TAG, "InputScreen: ${cardField.errorMessage}")
            TextFieldError(textError = cardField.errorMessage ?: "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            label = { Text(text = "Url", style = MaterialTheme.typography.labelLarge) },
            value = urlField.value,
            onValueChange = { urlField.value = it },
            isError = urlField.hasError(),
            modifier = Modifier.fillMaxWidth()
        )

        AnimatedVisibility(visible = urlField.hasError()) {
            TextFieldError(textError = urlField.errorMessage ?: "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            label = { Text(text = "Hostname", style = MaterialTheme.typography.labelLarge) },
            value = hostnameField.value,
            onValueChange = {
                hostnameField.value = it
            },
            isError = hostnameField.hasError(),
            modifier = Modifier.fillMaxWidth()
        )

        AnimatedVisibility(visible = hostnameField.hasError()) {
            TextFieldError(textError = hostnameField.errorMessage ?: "")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                withValidable(
                    emailField,
                    nameField,
                    cardField,
                    urlField,
                    hostnameField
                ) {
                    Toast.makeText(context, "All fields are valid", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Continue", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
fun TextFieldError(textError: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = textError,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth(),
            style = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.error)
        )
    }
}

@Preview(showBackground = true)
@ExperimentalAnimationApi
@Composable
fun InputScreenPreview() {
    InputScreen()
}

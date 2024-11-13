import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import tech.devscast.validable.CardScheme
import tech.devscast.validable.CardSchemeValidable
import tech.devscast.validable.EmailValidable
import tech.devscast.validable.GreaterThanValidable
import tech.devscast.validable.NotEmptyValidable
import tech.devscast.validable.core.rememberValidator

@Composable
fun App() {
    val emailField = remember { EmailValidable() }
    val nameField = remember { NotEmptyValidable() }

    val cardField = remember { CardSchemeValidable(CardScheme.MasterCard) }

    val ageTextField = remember {
        GreaterThanValidable(18, "Age must be greater than 18")
    }

    val validator = rememberValidator(emailField, nameField, cardField, ageTextField)

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))
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
                TextFieldError(textError = cardField.errorMessage ?: "")
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                shape = RoundedCornerShape(20.dp),
                label = { Text(text = "Your Age", style = MaterialTheme.typography.labelLarge) },
                value = ageTextField.value,
                onValueChange = {
                    ageTextField.value = it
                },
                isError = ageTextField.hasError(),
                modifier = Modifier.fillMaxWidth()
            )

            AnimatedVisibility(visible = ageTextField.hasError()) {
                TextFieldError(textError = ageTextField.errorMessage ?: "")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    validator.validate {
                        scope.launch {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "All fields are valid",
                                    actionLabel = "Hide",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    }
                }
            ) {
                Text(text = "Continue", style = MaterialTheme.typography.labelLarge)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                enabled = validator.isValid,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "All fields are valid",
                            actionLabel = "Hide",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            ) {
                Text(
                    text = "Enabled only when is valid",
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
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

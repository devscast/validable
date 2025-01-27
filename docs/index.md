# Validable

![Maven Central Version](https://img.shields.io/maven-central/v/tech.devscast/validable?color=blue)
[![build](https://github.com/devscast/validable/actions/workflows/build.yaml/badge.svg)](https://github.com/devscast/validable/actions/workflows/build.yaml)

Validable is a multiplatform extensible library that simplifies text field validation for
Jetpack Compose by providing abstraction and reusable validation logic.

```kotlin  
@Composable
fun MyScreen() {

    val emailField = remember { EmailValidable() }

    // pass all fields to the withValidable method
    val validator = rememberValidator(emailField)


    TextField(
        value = emailField.value,
        onValueChange = { emailField.value = it }, // update the text  
        isError = emailField.hasError(), // check if the field is not valid    
    )

    AnimatedVisibility(visible = emailField.hasError()) {

        Text(
            text = emailField.errorMessage ?: "",
            modifier = Modifier.fillMaxWidth(),
            style = LocalTextStyle.current.copy(color = MaterialTheme.colors.error)
        )

    }

    Button(
        // a state to check if all fields are valid, without submitting the form
        enabled = validator.isValid,
        onClick = {
            validator.validate {
                // will be executed if all fields are valid 
                Toast.makeText(context, "All fields are valid", Toast.LENGTH_SHORT).show()
            }
        }
    ) {
        Text(text = "Submit")
    }
} 
```

## Gradle setup

Include the **validable** dependency in your module `build.gradle` or `build.gradle.kts` :


```kotlin
dependencies {
    implementation("tech.devscast:validable:<version>")
}
```

License
--------

    Copyright 2024 Devscast Community.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
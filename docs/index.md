# Validable

![kotlin-version](https://img.shields.io/badge/kotlin-1.9.20-blue)
[![](https://jitpack.io/v/devscast/validable.svg)](https://jitpack.io/#devscast/validable)
[![build](https://github.com/devscast/validable/actions/workflows/build.yaml/badge.svg)](https://github.com/devscast/validable/actions/workflows/build.yaml)

Validating text fields when using jetpack compose can sometimes be challenging and verbose.

Validable is an extensible library that allows you to validate your text fields in a simpler way while having a reusable code.

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

## Installation

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```groovy
dependencies {
    implementation 'com.github.devscast:validable:{latest-version}'
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
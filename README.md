# validable

![Maven Central Version](https://img.shields.io/maven-central/v/tech.devscast/validable?color=blue)
[![build](https://github.com/devscast/validable/actions/workflows/build.yaml/badge.svg)](https://github.com/devscast/validable/actions/workflows/build.yaml)

Validating text fields when using jetpack compose can sometimes be challenging and verbose.

Validable is an extensible library that allows you to validate your text fields in a simpler way while having a reusable code.

This is what it looks like :

<img src="screenshots/inputscreen.png?raw=true" width="459" alt="Welcome screen">

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

The latest version is ![Maven Central Version](https://img.shields.io/maven-central/v/tech.devscast/validable?color=blue)

## For full documentation, check out [https://devscast.github.io/validable](https://devscast.github.io/validable)

## Contributing

We'd love contributions !

We will also try to tag any issues on our [issue tracker](https://github.com/devscast/validable/issues) that we'd love help with, so
if you just want to dip in, go have a look.

If you do want to contribute to this project, we have a [code of conduct](CODE_OF_CONDUCT.md).

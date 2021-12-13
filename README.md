# validable

Validating text fields when using jetpack compose can sometimes be challenging and verbose.

Validable is an extensible library that allows you to validate your text fields in a simpler way while having a reusable code.

This is what it looks like :

```kotlin  
@Composable  
fun MyScreen() {  
     val emailField = remember { EmailValidable() }  
     
     TextField(  
	     value = emailField.value,
	     onValueChange = { emailField.value = it }, // update the text  
		 isError = emailField.hasError(), // check if the field is not valid    
	)  
  
	AnimatedVisibility(visible = emailField.hasError() { 
		TextFieldError(textError = emailField.errorMessage ?: "")  // get the error message ( empty if the field is valid ) 
	}  
	
	Button(onClick = {  
		 // pass all fields to the withValidable method 
		 withValidable(emailField) {  
		 
			 // will be executed if all fields are valid 		
			 Toast.makeText(context,"All fields are valid",Toast.LENGTH_SHORT).show() 
		} 
	}) { 
		Text(text = "Submit") 
	}  
}  
```

## Installation

Gradle is the only supported build configuration, so just add the dependency to your project  `build.gradle`  file :


## For full documentation, check out the [wiki](https://github.com/devscast/validable/wiki) page

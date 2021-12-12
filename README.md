# validable


Validating text fields when using jetpack compose can sometimes be challenging and verbose.

Validable is an extensible library that allows you to validate your text fields in a simpler way while having a reusable code.

## Basic Implementation

**Required field**

```kotlin
val nameField = remember { NotEmptyValidable() }
```

You can also use a delegate

```kotlin
val nameField by validableNotEmpty()
```

**Email**

```kotlin
val emailField = remember { EmailValidable() }
```
or

```kotlin
val emailField by validableEmail()
```

### Validable properties
```kotlin
myfield.value // returns the text
    
myfield.errorMessage // returns the error (null if the field is valid)
    
myfield.hasError() // return false if the field is valid, return true if it is not valid
```

for example, you can use it in your TextField like this :

```kotlin
TextField(  
	value = emailField.value,  
	onValueChange = { emailField.value = it }, // update the text
	    
	isError = emailField.hasError(), // check if the field is not valid   
)  

AnimatedVisibility(visible = emailField.hasError() { 
	TextFieldError(textError = emailField.errorMessage ?: "")  // get the error message ( empty if the field is valid )
}
```

**Validation**

you can validate all your fields at once **withValidable**

```kotlin
Button(onClick = {
    
    // pass all fields to the withValidable method
	withValidable(emailField,nameField) {
	    
	// will be executed if all fields are valid
	Toast.makeText(context,"All fields are valid",Toast.LENGTH_SHORT).show()  
	}  
}) {  
	Text(text = "Submit")  
}
```

## Create custom rules

you can create your custom validables, for that your class will have to extend **BaseValidable**

```kotlin
class MyCustomValidable : BaseValidable(validator = ::isFieldValid, errorFor = ::fieldValidationError)  
    
private fun isFieldValid(text: String): Boolean {  
	return text.isNotBlank() // the condition that must be met
}  
    
private fun fieldValidationError(text: String) : String {  
	return "This field is required" // the error message that will be displayed  
}
```

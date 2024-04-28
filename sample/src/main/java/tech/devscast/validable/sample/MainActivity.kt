package tech.devscast.validable.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import tech.devscast.validable.CardScheme
import tech.devscast.validable.sample.ui.screens.InputScreen
import tech.devscast.validable.sample.ui.theme.ValidableTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValidableTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    InputScreen()
                    CardScheme
                }
            }
        }
    }
}

package com.cgcreativesolutions.jetpackcomposetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cgcreativesolutions.jetpackcomposetraining.ui.theme.JetpackComposeTrainingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Jetpack Compose
        setContent {
            JetpackComposeTrainingTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    CompositionLocalFontSizeDemo()
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    JetpackComposeTrainingTheme {
        MyApp()
    }
}
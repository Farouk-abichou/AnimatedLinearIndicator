package com.example.animatedlinearindicator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatedlinearindicator.ui.theme.AnimatedLinearIndicatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedLinearIndicatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimatedLinearIndicatorTheme {
        AnimatedLinearIndicator()
    }
}

@Composable
fun AnimatedLinearIndicator() {

    val width = 100.dp
    val height = 400.dp
    val radius = 50.dp
    val pxRadiusValue = with(LocalDensity.current) { radius.toPx() }
    val pxHeightValue = with(LocalDensity.current) { height.toPx() }
    val pxWidthValue = with(LocalDensity.current) { width.toPx() }


    Canvas(
        modifier = Modifier
            .width(width)
            .height(height)

    ) {
        drawCircle(
            color = Color.Cyan,
            radius = pxRadiusValue,
            center = Offset(pxWidthValue/2, pxRadiusValue)
        )
        drawLine(
            color = Color.Cyan,
            start = Offset(pxWidthValue/2,pxRadiusValue*2),
            end = Offset(pxWidthValue/2,pxRadiusValue*6),
            strokeWidth = 20f
        )
        drawCircle(
            color = Color.Cyan,
            radius = pxRadiusValue,
            center = Offset(pxWidthValue/2, pxRadiusValue*7)
        )
    }
    CustomLinearProgressIndicator(
        start = Offset(pxWidthValue/2,pxRadiusValue*2),
        end = Offset(pxWidthValue/2,pxRadiusValue*6),
        progress = 0.2f,
        color = Color.Black
    )
}
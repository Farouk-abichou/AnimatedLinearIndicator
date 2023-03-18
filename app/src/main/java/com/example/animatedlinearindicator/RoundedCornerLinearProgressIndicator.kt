package com.example.animatedlinearindicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp


@Composable
fun CustomLinearProgressIndicator(
    start:  Float,
    end :Float,
    color: Color = Color.Gray,
    trackColor: Color = Color.Black,
    yOffset:Float
) {

    Canvas(
        Modifier
            .progressSemantics(end)
            .size(LinearIndicatorWidth, LinearIndicatorHeight)
    ) {

        val strokeWidth = size.height
        drawLinearIndicatorTrack(trackColor, strokeWidth)
        drawLinearIndicator(
            startFraction = start,
            endFraction = end,
            color = color,
            strokeWidth =  strokeWidth,
            yOffset = yOffset
        )

    }
}


internal val LinearIndicatorWidth = 240.dp

internal val LinearIndicatorHeight = LinearProgressIndicatorTokens.TrackHeight


internal object LinearProgressIndicatorTokens {
    val TrackHeight = 4.0.dp
}

private fun DrawScope.drawLinearIndicatorTrack(
    color: Color,
    strokeWidth: Float
) {
    val height = size.height
    drawLinearIndicator(0f, 1f, color, strokeWidth,height / 2)
}



private fun DrawScope.drawLinearIndicator(
    startFraction: Float,
    endFraction: Float,
    color: Color,
    strokeWidth: Float,
    yOffset : Float
) {
    val width = size.width
    val height = size.height
    // Start drawing from the vertical center of the stroke
    val yOffset = yOffset

    val isLtr = layoutDirection == LayoutDirection.Ltr
    val barStart = (if (isLtr) startFraction else 1f - endFraction) * width
    val barEnd = (if (isLtr) endFraction else 1f - startFraction) * width

    // Progress line
    drawLine(
        color,
        Offset( yOffset,barStart),
        Offset( yOffset,barEnd),
        strokeWidth,
        cap = StrokeCap.Round,

        )

}

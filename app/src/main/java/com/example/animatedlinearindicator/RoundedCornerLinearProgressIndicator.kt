package com.example.animatedlinearindicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
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
    start:  Offset,
    end :Offset,
    progress: Float,
    color: Color = Color.Gray,
    trackColor: Color = Color.Black,
) {

    Canvas(
        Modifier
            .progressSemantics(progress)
            .size(LinearIndicatorWidth, LinearIndicatorHeight)
    ) {

        val strokeWidth = size.height
        drawLinearIndicatorTrack(
            start = start,
            end = end,
            color = color,
            strokeWidth =  strokeWidth,
        )
        drawLinearIndicator(
            start = start,
            end = Offset(progress,end.y),
            color = color,
            strokeWidth =  strokeWidth,
        )

    }
}


internal val LinearIndicatorWidth = 240.dp

internal val LinearIndicatorHeight = LinearProgressIndicatorTokens.TrackHeight


internal object LinearProgressIndicatorTokens {
    val TrackHeight = 4.0.dp
}

private fun DrawScope.drawLinearIndicatorTrack(
    start: Offset,
    end: Offset,
    color: Color,
    strokeWidth: Float
) {
    drawLinearIndicator(
        start = start,
        end = end,
        color,
        strokeWidth,
    )
}



private fun DrawScope.drawLinearIndicator(
    start: Offset,
    end: Offset,
    color: Color,
    strokeWidth: Float,
) {
    val width = size.width
    val height = size.height
    // Start drawing from the vertical center of the stroke

    val isLtr = layoutDirection == LayoutDirection.Ltr
    val barStart = (if (isLtr) start.x else 1f - end.x) * width
    val barEnd = (if (isLtr) end.x else 1f - start.x) * width

    // Progress line
    drawLine(
        color = color,
        start = start,
        end = end,
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round,
        )
}

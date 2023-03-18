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



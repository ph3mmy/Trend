package com.oluwafemi.trend.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.oluwafemi.trend.ui.theme.Gray
import com.oluwafemi.trend.ui.theme.White

@Composable
fun ClockScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        CircularClock(
            modifier = Modifier,
            time = { System.currentTimeMillis() },
            circleRadius = 400f,
            outerThickness = 24f
        )
    }
}

@Composable
private fun CircularClock(
    modifier: Modifier,
    time: () -> Long,
    circleRadius: Float,
    outerThickness: Float
) {

    var circleCenter by remember { mutableStateOf(Offset.Zero) }

    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            circleCenter = Offset(x = width / 2, y = height / 2)

            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        White.copy(0.45f),
                        Gray.copy(0.35f)
                    )
                ),
                style = Stroke(width = outerThickness),
                radius = circleRadius + outerThickness / 2,
                center = circleCenter
            )

            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        White.copy(0.45f),
                        Gray.copy(0.25f)
                    )
                ),
                center = circleCenter,
                radius = circleRadius
            )

            drawCircle(
                color = Gray,
                radius = 12f,
                center = circleCenter
            )

        }
    }
}

@Preview
@Composable
private fun ClockScreenPrev() {
    ClockScreen()
}
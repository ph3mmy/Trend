package com.oluwafemi.trend.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.oluwafemi.trend.ui.theme.Purple500
import kotlin.math.roundToInt

@Composable
fun BatteryScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BatteryIndicator(
            value = 85,
            steps = 4,
            outerThickness = 24.dp.value,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .aspectRatio(1.5f)
        )
    }
}

@Composable
fun BatteryIndicator(
    value: Int,
    modifier: Modifier = Modifier,
    indicatorColor: Color = Purple500,
    outerThickness: Float = 20f,
    steps: Int = 5,
    totalBarSpace: Float = 120f
) {
    Canvas(modifier = modifier) {
        val batteryWidth = size.width
        val batteryHeight = size.height

        drawRect(
            color = indicatorColor,
            size = Size(
                width = batteryWidth,
                height = batteryHeight
            ),
            style = Stroke(
                width = outerThickness,
                pathEffect = PathEffect.cornerPathEffect(radius = 8.dp.toPx())
            )
        )

        drawRoundRect(
            color = indicatorColor,
            topLeft = Offset(
                x = batteryWidth,
                y = batteryHeight * 0.25f
            ),
            size = Size(
                width = outerThickness * 1.5f,
                height = batteryHeight * 0.5f
            ),
            cornerRadius = CornerRadius(15f, 15f)
        )

        // drawing the bars
        val innerBarWidth = batteryWidth - outerThickness
        val spaceBetween = totalBarSpace / (steps + 1)
        val loadingBarWidth = (innerBarWidth - totalBarSpace) / steps

        var currentStartOffset = Offset(
            x = (outerThickness / 2) + spaceBetween + (loadingBarWidth / 2) ,
            y = outerThickness
        )

        var currentEndOffset = Offset(
            x = (outerThickness / 2) + spaceBetween + (loadingBarWidth / 2) ,
            y = batteryHeight - outerThickness
        )

        for (i in 0 until (value/100f * steps).roundToInt()) {
            drawLine(
                color = indicatorColor,
                start = currentStartOffset,
                end = currentEndOffset,
                strokeWidth = loadingBarWidth
            )

            currentStartOffset = currentStartOffset.copy(x = currentStartOffset.x + loadingBarWidth + spaceBetween)
            currentEndOffset = currentEndOffset.copy(x = currentEndOffset.x + loadingBarWidth + spaceBetween)
        }

    }
}

@Composable
fun Dp.dpPx(): Float {
    return with(LocalDensity) { this@dpPx.value}
}

@Preview
@Composable
fun BatteryScreenPreview() {
    BatteryScreen()
}
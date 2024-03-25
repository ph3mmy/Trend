package com.oluwafemi.trend.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/*
@Composable
fun DynamicArrowTooltip(
    modifier: Modifier = Modifier,
    tooltipText: String,
    arrowPosition: TooltipArrowPosition,
    direction: Direction = Direction.TOP_END,
    content: @Composable () -> Unit
) {
    Tooltip(
        modifier = modifier,
        tooltip = {
            TooltipArrowShape(arrowPosition, direction)
            Text(text = tooltipText)
        },
        content = content
    )
}

enum class TooltipArrowPosition {
    START,
    CENTER,
    END
}

enum class Direction {
    TOP_END,
    BOTTOM_END,
    TOP_START,
    BOTTOM_START
}

@Composable
private fun TooltipArrowShape(
    position: TooltipArrowPosition,
    direction: Direction
) {
    val arrowShape = ArrowShape(
        modifier = Modifier.graphicsLayer(
            rotationZ = when (position) {
                TooltipArrowPosition.START -> 90
                TooltipArrowPosition.CENTER -> 180
                TooltipArrowPosition.END -> 270
            }.toFloat()
        ),
        alignment = direction.toAlignment()
    )
    Canvas(modifier = Modifier.size(16.dp)) {
        arrowShape.draw(size = size, layoutDirection = LayoutDirection.Ltr)
    }
}

private fun Direction.toAlignment(): Alignment {
    return when (this) {
        Direction.TOP_END -> Alignment.TopEnd
        Direction.TOP_START -> Alignment.TopStart
        Direction.BOTTOM_END -> Alignment.BottomEnd
        Direction.BOTTOM_START -> Alignment.BottomStart
    }
}*/

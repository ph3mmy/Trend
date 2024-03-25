package com.oluwafemi.trend.canvas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun CanvasScreen() {
    Box(modifier = Modifier
        .padding(16.dp)
        .background(Color.LightGray)
        .padding(24.dp)
    ) {
        val shape = TooltipShape(8.dp, tickHeight = 8.dp, tickOrientation = TickOrientation.START)
        Box(modifier = Modifier
            .width(200.dp)
            .height(80.dp)
            .shadow(
                elevation = 8.dp,
                shape = shape
            )
            ) {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Red)
                    .padding(24.dp),
                text = "Hello Worlu"
            )
        }
    }
}

@Composable
fun ShapeDemo() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(80.dp)
    ) {
        val shape = TooltipShape(
            cornerRadiusDp = 8.dp,
            tickHeight = 16.dp,
            tickOrientation = TickOrientation.TOP
        )
//        val shape = CustomShape(8f)
        Card(
            modifier = Modifier
                .width(150.dp)
                .height(60.dp)
                .align(Alignment.Center)
                .shadow(
                    elevation = 8.dp,
                    shape = shape,
                    spotColor = Color.Cyan
                ),
            shape = shape,
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colors.primary
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Hello world"
                )
            }
        }
    }
}

class CustomShape(private val cornerRadius: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val tickHeight = with(density) { 16.dp.toPx() }
        val customPath = drawCustomPath(size, cornerRadius, tickHeight)
        return Outline.Generic(customPath)
    }
}

    private fun drawCustomPath(size: Size, cornerRadius: Float, tickHeight: Float): Path {
        val sizeHeight = 100f
        val rectWidth = 200f

        return Path().apply {
            reset()
            /*arcTo(
                rect = Rect(left = -cornerRadius, top = -cornerRadius, right = cornerRadius, bottom = cornerRadius),
                startAngleDegrees = 90f,
                sweepAngleDegrees = -90f,
                forceMoveTo = false
            )*/

            /*lineTo(x = rectWidth, y = (sizeHeight * 0.5f + tickHeight * 0.5f))
            lineTo(x = -tickHeight, y = sizeHeight * 0.5f)
            lineTo(x = rectWidth, y = (sizeHeight * 0.5f - tickHeight * 0.5f))
            lineTo(x = rectWidth, y = cornerRadius)*/

            val curvedStartX = 9
            val arcBox = 5f
            val tipHeight = 40f
            val tipWidth = 60f
            val tipStartX = 200f
            val tipStartY = 20f



            val roundnessRadius = arcBox / 8
            lineTo(tipStartX, 0f)
            lineTo(tipStartX, tipStartY)
//            lineTo(240f, 50f)
            lineTo(240f - roundnessRadius *2, 45f -roundnessRadius*4)
//            lineTo(245f, 45f)
            arcTo(
                rect = Rect(left = 240f - roundnessRadius, top = 45f, 240 + roundnessRadius, 45 + roundnessRadius *4),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 180f,
                forceMoveTo = false
            )
//            lineTo(245f, 55f)
            lineTo(240f  - roundnessRadius/2, 45 + roundnessRadius*8)

            lineTo(200f, 80f)
            lineTo(200f, 100f)
            lineTo(-200f, 100f)
            lineTo(-200f, -100f)
            close()
        }

}

enum class TickOrientation {
    TOP, START, END, BOTTOM
}

class TooltipShape(
    private val cornerRadiusDp: Dp,
    private val tickHeight: Dp,
    private val tickOrientation: TickOrientation
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val cornerRadius = with(density) { cornerRadiusDp.toPx() }
        val tickHeight = with(density) { tickHeight.toPx() }

        return Outline.Generic(
            Path().apply {
                reset()
                //Top left arc
                arcTo(
                    rect = Rect(
                        left = 0f,
                        top = 0f,
                        right = 2 * cornerRadius,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                if (tickOrientation == TickOrientation.TOP) {
                    println("tickHeight TOP == $tickHeight")
                    lineTo(x = size.width * 0.5f - tickHeight * 0.5f, y = 0f)
//                    lineTo(x = size.width * 0.5f, y = -tickHeight)
                    val roundnessRadius = tickHeight/12
//                    lineTo(x = (size.width * 0.5f) - (roundnessRadius), y = -tickHeight + (roundnessRadius/2))
//                    lineTo(x = (size.width * 0.5f) - (roundnessRadius), y = -tickHeight)
                    lineTo(x = (size.width * 0.5f) - (roundnessRadius), y = -tickHeight)

                    arcTo(
//                        rect = Rect(left = (size.width * 0.5f) - (roundnessRadius), top = -(tickHeight+ (roundnessRadius/2)), (size.width * 0.5f) + (roundnessRadius), -tickHeight + (roundnessRadius*1.5f)),
                        rect = Rect(
                            left = (size.width * 0.5f) - (roundnessRadius),
                            top = -tickHeight-roundnessRadius,
                            (size.width * 0.5f) + (roundnessRadius),
                            -tickHeight + (roundnessRadius)
                        ),
                        startAngleDegrees = 180f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = false
                    )


                    lineTo(x = size.width * 0.5f + roundnessRadius, y = -tickHeight)
                    lineTo(x = size.width * 0.5f + tickHeight * 0.5f, y = 0f)

                    /*lineTo(x = size.width * 0.5f - tickHeight * 0.5f, y = 0f)
                    val roundnessRadius = tickHeight / 12
                    lineTo(x = (size.width * 0.5f) - roundnessRadius, y = -tickHeight)

                    arcTo(
                        rect = Rect(
                            left = (size.width * 0.5f) - (roundnessRadius),
                            top = -tickHeight - roundnessRadius,
                            right = (size.width * 0.5f) + (roundnessRadius),
                            bottom = -tickHeight + roundnessRadius
                        ),
                        startAngleDegrees = 180f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = false
                    )

                    lineTo(x = size.width * 0.5f + roundnessRadius, y = -tickHeight)
                    lineTo(x = size.width * 0.5f + tickHeight * 0.5f, y = 0f)*/



                }
                lineTo(x = size.width - 2 * cornerRadius, y = 0f)
                //Top right arc
                arcTo(
                    rect = Rect(
                        left = size.width - 2 * cornerRadius,
                        top = 0f,
                        right = size.width,
                        bottom = 2 * cornerRadius
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                if (tickOrientation == TickOrientation.END && layoutDirection == LayoutDirection.Ltr
                    || tickOrientation == TickOrientation.START && layoutDirection == LayoutDirection.Rtl
                ) {
                    println("tickHeight START == $tickHeight")
                    lineTo(x = size.width, y = (size.height * 0.5f - tickHeight * 0.5f))
//                    lineTo(x = size.width + tickHeight, y = size.height * 0.5f)
                    val roundnessRadius = tickHeight / 12
                    lineTo(x = (size.width + tickHeight), y = size.height * 0.5f - roundnessRadius)
                    arcTo(
                        rect = Rect(
                            left = size.width + tickHeight - roundnessRadius,
                            top = size.height * 0.5f - roundnessRadius,
                            right = size.width + tickHeight + roundnessRadius,
                            bottom = size.height * 0.5f + roundnessRadius
                        ),
                        startAngleDegrees = 270f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = false
                    )

                    lineTo(x = size.width, y = (size.height * 0.5f + tickHeight * 0.5f))

                    /*val roundnessRadius = tickHeight / 8
                    lineTo(x = size.width * 0.5f + tickHeight * 0.5f - roundnessRadius, y = 0f)

                    arcTo(
                        rect = Rect(
                            left = size.width * 0.5f + tickHeight * 0.5f - 2 * roundnessRadius,
                            top = -roundnessRadius,
                            right = size.width * 0.5f + tickHeight * 0.5f,
                            bottom = roundnessRadius
                        ),
                        startAngleDegrees = 270f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = false
                    )

                    lineTo(x = size.width * 0.5f + tickHeight * 0.5f, y = -tickHeight)
                    lineTo(x = size.width * 0.5f - tickHeight * 0.5f, y = -tickHeight)*/

                }
                lineTo(x = size.width, y = size.height - 2 * cornerRadius)
                // Bottom right arc
                arcTo(
                    rect = Rect(
                        left = size.width - 2 * cornerRadius,
                        top = size.height - 2 * cornerRadius,
                        right = size.width,
                        bottom = size.height
                    ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false
                )
                if (tickOrientation == TickOrientation.BOTTOM) {
                    lineTo(x = size.width * 0.5f + tickHeight * 0.5f, y = size.height)
                    lineTo(x = size.width * 0.5f, y = size.height + tickHeight)
                    lineTo(x = size.width * 0.5f - tickHeight * 0.5f, y = size.height)
                }
                lineTo(x = 2 * cornerRadius, y = size.height)
                // Bottom left arc
                arcTo(
                    rect = Rect(
                        left = 0f,
                        top = size.height - 2 * cornerRadius,
                        right = 2 * cornerRadius,
                        bottom = size.height
                    ),
                    startAngleDegrees = 90.0f,
                    sweepAngleDegrees = 90.0f,
                    forceMoveTo = false
                )
                if (tickOrientation == TickOrientation.START && layoutDirection == LayoutDirection.Ltr
                    || tickOrientation == TickOrientation.END && layoutDirection == LayoutDirection.Rtl
                ) {
                    lineTo(x = 0f, y = (size.height * 0.5f + tickHeight * 0.5f))
                    lineTo(x = -tickHeight, y = size.height * 0.5f)
                    lineTo(x = 0f, y = (size.height * 0.5f - tickHeight * 0.5f))
                }
                lineTo(x = 0f, y = cornerRadius)
            }
        )
    }
}

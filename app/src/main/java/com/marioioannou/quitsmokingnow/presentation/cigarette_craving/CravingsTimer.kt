package com.marioioannou.quitsmokingnow.presentation.cigarette_craving

import android.media.MediaPlayer
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.marioioannou.quitsmokingnow.R
import com.marioioannou.quitsmokingnow.presentation.cigarette_craving.utils.Constants
import com.marioioannou.quitsmokingnow.presentation.cigarette_craving.utils.Constants.formatTime
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Shape

@Composable
fun CravingsTimer(
    time: String,
    progress: Float,
    isPlaying: Boolean,
    isLottiePlaying: Boolean,
    celebrate: Boolean,
    optionSelected: () -> Unit
) {

    //var isPLottiePlaying by remember { mutableStateOf(true) }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (celebrate) {
            //ShowCelebration()
        }

//        Text(
//            text = "Timer",
//            color = androidx.compose.ui.graphics.Color.Magenta,
//            fontSize = 25.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 50.dp, bottom = 20.dp)
//
//        )
//
//        Text(
//            text = "1 minute to launch...",
//            color = androidx.compose.ui.graphics.Color.Magenta,
//            fontSize = 16.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(20.dp)
//        )
//
//        Text(
//            text = "Click to start or stop countdown",
//            color = androidx.compose.ui.graphics.Color.Magenta,
//            fontSize = 14.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//        )

        CountDownIndicator(
            progress = progress,
            time = time,
            size = 350,
            stroke = 15,
            isLottiePlaying = isLottiePlaying
        )

        CountDownButton(
            modifier = Modifier
                .size(70.dp),
            isLottiePlaying = isPlaying,
            isPlaying = isPlaying
        ) {
            optionSelected()
        }
    }


}

@Composable
fun CountDownIndicator(
    progress: Float,
    time: String,
    size: Int,
    stroke: Int,
    isLottiePlaying: Boolean
) {

    val context = LocalContext.current

//    val mediaPlayer = remember {
//        MediaPlayer.create(context, R.raw.calm_track).apply {
//            isLooping = true
//        }
//    }
//
//    DisposableEffect(key1 = isLottiePlaying) {
//        if (isLottiePlaying) {
//            if (!mediaPlayer.isPlaying) {
//                mediaPlayer.start()
//            }
//        } else {
//            if (mediaPlayer.isPlaying) {
//                mediaPlayer.pause()
//                mediaPlayer.seekTo(0)
//            }
//        }
//
//        onDispose {
//            if (mediaPlayer.isPlaying) {
//                mediaPlayer.stop()
//            }
//            mediaPlayer.release()
//        }
//    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
    )

    Box(
        modifier = Modifier.size(size.dp * 1.5f).padding(top = 100.dp),
        contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.calm_anim_waves_bigger))

        LottieAnimation(
            modifier = Modifier.size(size.dp * 1.5f),
            alignment = Alignment.Center,
            composition = composition,
            isPlaying = isLottiePlaying,
            iterations = LottieConstants.IterateForever
        )

        CircularProgressIndicatorBackGround(
            modifier = Modifier
                .size(size.dp/1.3f),
            color = colorResource(R.color.dark_cyan),
            stroke = stroke
        )

        CircularProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .size(size.dp/1.3f),
            color = colorResource(R.color.teal_200),
            strokeWidth = stroke.dp,
        )

        Text(
            text = time,
            //color = colorResource(R.color.teal_700),
            color = colorResource(R.color.darker_dark_cyan),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CircularProgressIndicatorBackGround(
    modifier: Modifier = Modifier,
    color: Color,
    stroke: Int
) {
    val style = with(LocalDensity.current) { Stroke(stroke.dp.toPx()) }

    Canvas(
        modifier = modifier,
        onDraw = {

            val innerRadius = (size.minDimension - style.width) / 2

            drawArc(
                color = color,
                startAngle = 0f,
                sweepAngle = 360f,
                topLeft = Offset(
                    (size / 2.0f).width - innerRadius,
                    (size / 2.0f).height - innerRadius
                ),
                size = Size(innerRadius * 2, innerRadius * 2),
                useCenter = false,
                style = style
            )
        }
    )
}

@Composable
fun CountDownButton(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    isLottiePlaying: Boolean,
    optionSelected: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 50.dp)
    ) {

        Button(
            onClick = {
                optionSelected()
            },
            modifier =
            Modifier
                .height(70.dp)
                .width(200.dp),

            shape = RoundedCornerShape(25.dp),

            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.dark_cyan),
                contentColor = colorResource(id = R.color.white),
            ),

            ) {
            val pair = if (!isPlaying) {
                "START"
            } else {
                "STOP"
            }

            Text(
                pair,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun ShowCelebration() {

    AndroidView(

        modifier = Modifier
            //.size(80.dp, 50.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            //.padding(top = 20.dp),

        factory = { ctx ->

            KonfettiView(context = ctx).apply {
            }
        },

        update = {
            it.build()
                .addColors(
                    android.graphics.Color.YELLOW,
                    android.graphics.Color.GREEN,
                    android.graphics.Color.MAGENTA
                )
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(nl.dionsegijn.konfetti.models.Size(12))
                .setPosition(-50f, -50f, -50f)
                .streamFor(300, 5000L)
        }
    )
}


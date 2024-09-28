package com.marioioannou.quitsmokingnow.presentation.cigarette_counter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.marioioannou.quitsmokingnow.R
import com.marioioannou.quitsmokingnow.ui.theme.ButtonBackground
import com.marioioannou.quitsmokingnow.ui.theme.CyanSecondary
import com.marioioannou.quitsmokingnow.ui.theme.GreenPrimary
import java.nio.file.WatchEvent


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CigaretteCounterScreen() {

    val viewModel: CigaretteCounterViewModel = viewModel()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.cigarette_counter_bg),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.TopCenter),
        ) {

            Text(
                text = "Did you smoke any cigarettes today?",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 64.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            )

            Text(
                text = viewModel.cigaretteCounterState.cigaretteCount.toString(),// TODO
                fontWeight = FontWeight.Bold,
                fontSize = 128.sp,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 32.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        )

        Button(
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.elevation(3.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp, 16.dp, 16.dp, 96.dp)
                .height(100.dp),
            onClick = { viewModel.increaseCount() },
            colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cigarette_image),
                contentDescription = "Clickable image",
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize()
            )
        }

    }

}

@Preview(
    showSystemUi = true
)
@Composable
fun UICigaretteCounterScreen() {
    CigaretteCounterScreen()
}

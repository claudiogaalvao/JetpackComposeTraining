package com.cgcreativesolutions.jetpackcomposetraining.demo

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationsDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        InfiniteTransition()
    }
}

@Composable
fun ExpandableCard() {
    var showContent by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    enabled = true,
                    onClick = {
                        showContent = showContent.not()
                    }
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Title",
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Arrow"
            )
        }
        // Sem animacao
        if (showContent) {
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus finibus tortor non molestie rutrum. Duis ut posuere ex, sit amet laoreet justo. Aenean quis fringilla libero, eget malesuada nisl. Praesent elementum diam quis ante aliquet bibendum. Aliquam molestie nisi vitae nisl egestas, vitae pellentesque augue ultrices. Mauris rutrum suscipit tellus, id lobortis est sagittis non. Donec aliquet viverra tincidunt. Morbi condimentum tempor elit, sit amet lacinia purus congue ac.")
        }
        // Com animacao
//            AnimatedVisibility(showContent) {
//                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus finibus tortor non molestie rutrum. Duis ut posuere ex, sit amet laoreet justo. Aenean quis fringilla libero, eget malesuada nisl. Praesent elementum diam quis ante aliquet bibendum. Aliquam molestie nisi vitae nisl egestas, vitae pellentesque augue ultrices. Mauris rutrum suscipit tellus, id lobortis est sagittis non. Donec aliquet viverra tincidunt. Morbi condimentum tempor elit, sit amet lacinia purus congue ac.")
//            }
    }
}

@Composable
fun TransitionAlpha() {
    var alphaValue by remember {
        mutableFloatStateOf(1f)
    }
    val animatedAlpha by animateFloatAsState(
        targetValue = alphaValue,
        animationSpec = tween(
            durationMillis = 2000
        )
    )
    Text(
        modifier = Modifier
            .background(color = Color.Black.copy(alpha = animatedAlpha))
            .padding(12.dp)
            .clickable(
                enabled = true,
                onClick = {
                    alphaValue = if (alphaValue == 1f) {
                        0.5f
                    } else {
                        1f
                    }
                }
            ),
        text = "Click to see animation",
        fontSize = 20.sp
    )
}

@Composable
fun TransitionColor() {
    var textColor by remember {
        mutableStateOf(Color.Black)
    }
    val animatedColor by animateColorAsState(
        targetValue = textColor,
        animationSpec = tween(
            durationMillis = 2000
        )
    )
    Text(
        modifier = Modifier
            .background(color = animatedColor)
            .padding(12.dp)
            .clickable(
                enabled = true,
                onClick = {
                    textColor = if (textColor == Color.Black) {
                        Color.Red
                    } else {
                        Color.Black
                    }
                }
            ),
        text = "Click to see animation",
        fontSize = 20.sp
    )
}

@Composable
fun AnimateContentSize() {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .animateContentSize()
            .height(if (expanded) 400.dp else 200.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                expanded = !expanded
            }

    ) {
    }
}

@Composable
fun AnimatedPadding() {
    var toggled by remember {
        mutableStateOf(false)
    }
    val animatedPadding by animateDpAsState(
        if (toggled) {
            0.dp
        } else {
            20.dp
        },
        label = "padding"
    )
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .padding(animatedPadding)
            .background(Color(0xff53D9A1))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                toggled = !toggled
            }
    )
}

@Composable
fun InfiniteTransition() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF60DDAD),
        targetValue = Color(0xFF4285F4),
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "color"
    )

    Text(
        text = "Hello Compose",
        color = animatedColor,
        fontSize = 32.sp
    )
}
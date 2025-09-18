package com.cgcreativesolutions.jetpackcomposetraining.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cgcreativesolutions.jetpackcomposetraining.R

@Composable
fun ComponentsDemo() {
    ArtistCard()
}

@Composable
fun ArtistCard() {
    Row {
        ArtistAvatar()
        Column {
            Text("Michelangelo Simoni")
            Text("3 minutes ago")
        }
    }
}

@Composable
fun ArtistAvatar() {
    Box {
        Image(
            modifier = Modifier.size(40.dp).padding(2.dp).clip(CircleShape),
            painter = painterResource(R.drawable.michelangelo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Icon(
            Icons.Filled.CheckCircle,
            contentDescription = "Check mark",
            modifier = Modifier
                .size(14.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentsDemoPreview() {
    _root_ide_package_.com.cgcreativesolutions.jetpackcomposetraining.ui.theme.JetpackComposeTrainingTheme {
        ComponentsDemo()
    }
}
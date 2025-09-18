package com.cgcreativesolutions.jetpackcomposetraining.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// 1. Definição do CompositionLocal
val LocalFontSize = compositionLocalOf { 16.sp }

// 2. Consumo em um Composable
@Composable
fun TextWithLocalFont(text: String) {
    Text(
        text = text,
        fontSize = LocalFontSize.current
    )
}

// 3. Provedor que altera o valor
@Composable
fun CompositionLocalFontSizeDemo() {
    Column {
        TextWithLocalFont("Texto com tamanho padrão (16sp)")

        CompositionLocalProvider(LocalFontSize provides 24.sp) {
            TextWithLocalFont("Texto com tamanho sobrescrito (24sp)")
        }

        TextWithLocalFont("Volta pro padrão (16sp)")
    }
}

// Level 1
// 1. Criando o Local
data class User(val name: String, val isPremium: Boolean)
val LocalUser = staticCompositionLocalOf<User> {
    error("Nenhum usuário disponível")
}

// 2. Composable que consome
@Composable
fun GreetingLevel1() {
    val user = LocalUser.current
    Text("Olá, ${user.name}! Premium: ${user.isPremium}")
}

// 3. Provedor
@Composable
fun CompositionLocalUserLevel1Demo() {
    val user = User("Claudio", true)

    CompositionLocalProvider(LocalUser provides user) {
        GreetingLevel1()
    }
}

// Level 2
// 1. Criando o Local

object UserManager {
    val user: User
        @Composable @ReadOnlyComposable get() = LocalUser.current
}

// 2. Composable que consome
@Composable
fun GreetingLevel2() {
    Text("Olá, ${UserManager.user.name}! Premium: ${UserManager.user.isPremium}")
}

// 3. Provedor
@Composable
fun CompositionLocalUserLevel2Demo() {
    val user = User("Claudio", true)

    UserManager(user) {
        GreetingLevel2()
    }
}

@Composable
fun UserManager(user: User, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalUser provides user) {
        content()
    }
}

@Composable
@Preview
fun CompositionLocalFontSizeDemoPreview() {
    CompositionLocalFontSizeDemo()
}

@Composable
@Preview
fun CompositionLocalUserLevel1DemoPreview() {
    CompositionLocalUserLevel1Demo()
}

@Composable
@Preview
fun CompositionLocalUserLevel2DemoPreview() {
    CompositionLocalUserLevel2Demo()
}
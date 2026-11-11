package org.example.composestarter

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TwoTexts() {
    Column {
        Text("This is text.")
        Text("This is ALSO text.")
    }
}

@Composable
fun TwoTextsStyled() {
    Column {
        Text("This is text.", color = Color.Red)
        Text("This is ALSO text.", color = Color.Green)
    }
}

@Composable
fun FavouriteProgrammingLanguage() {
    val nameState = remember { mutableStateOf("") }

    Column {
        TextField(value = nameState.value, onValueChange = {
            nameState.value = it
        })
        Text("Your favourite programming language is... ${nameState.value}")
    }
}

@Composable
fun ButtonCounter() {
    val counterState = remember { mutableStateOf(0) }
    Button(onClick = { counterState.value++ }) {
        Text("Increase")
    }
    Column {
        Text("Counter is ${counterState.value}")
    }
}

@Composable
fun LengthConvert() {
    val feetState = remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            singleLine = true,
            value = feetState.value,
            onValueChange = {
                feetState.value = it
            },
            label = { Text("Enter feet: ") }
        )

        if (feetState.value != "") {
            if (feetState.value.toDoubleOrNull() == null) {
                Text("Error: Feet must be a number")
            } else {
                Text("${feetState.value.toDouble() * 0.305} metres")
            }
        }
    }
}

@Composable
fun FakeLogin() {
    val username = "alex"
    val password = "password"
    var loggedIn = remember { mutableStateOf(false) }
    val usernameState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    if (!loggedIn.value) {
        TextField(usernameState.value, onValueChange = {
            usernameState.value = it
        },
        label = { Text("Enter your username") })
        TextField(passwordState.value, onValueChange = {
            passwordState.value = it
        },
        label = { Text("Enter your password") })
        Button(
            onClick = {
                if (usernameState.value == username && passwordState.value == password) {
                    loggedIn.value = true
                }
            }
        ) { Text("Login") }

    } else {
        Text("Welcome, $username")
        Button(
            onClick = {
                loggedIn.value = false
            }
        ) { Text("Logout") }
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column {
        FavouriteProgrammingLanguage()
        Spacer(Modifier.height(16.dp))
        ButtonCounter()
        Spacer(Modifier.height(16.dp))
        LengthConvert()
        Spacer(Modifier.height(16.dp))
        FakeLogin()
        }
    }
}
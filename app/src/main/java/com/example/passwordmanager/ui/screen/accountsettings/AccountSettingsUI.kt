package com.example.passwordmanager.ui.screen.accountsettings

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Composable
fun SettingsLabelText(text: String) {
    Text(
        text = text,
        color = colorResource(id = R.color.settings_label_text),
        fontFamily = FontFamily(
            Font(R.font.nunito_regular)
        ),
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun SettingsTextField(text: String, hideText: Boolean = false) {
    val currentText = rememberSaveable { mutableStateOf(text) }
    Column {
        BasicTextField(
            value = currentText.value,
            onValueChange = { currentText.value = it },
            textStyle = TextStyle(
                fontFamily = FontFamily(
                    Font(R.font.nunito_regular)
                ),
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                color = colorResource(id = R.color.settings_value_text),
                background = Color.Transparent
            ),
            maxLines = 1,
            singleLine = true,
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,

            modifier = Modifier
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.gradient_line),
            contentDescription = "",
            alignment = Alignment.TopStart
        )
    }
}

@Composable
fun PasswordField(password: String) {
    val hidePassword = rememberSaveable { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1.0f)
                .padding(end = 10.dp)
        ) {
            SettingsLabelText(text = stringResource(id = R.string.account_pass_label))
            SettingsTextField(password, hideText = hidePassword.value)
        }
        Image(
            painter = painterResource(id = R.drawable.eye),
            contentDescription = stringResource(id = R.string.show_password_icon),
            modifier = Modifier
                .size(20.dp)
                .clickable {
                    hidePassword.value = !hidePassword.value
                }
        )
    }
}

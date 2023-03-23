package com.example.passwordmanager.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.theme.PasswordManagerTheme

@Composable
fun AccountElement(name: String, email: String) {
    Row (modifier = Modifier.fillMaxSize()){
        Column {
            Text(name, color = colorResource(id = R.color.account_title), fontFamily = FontFamily(
                Font(R.font.nunito_regular)
            ), fontWeight = FontWeight.W400, fontSize = 18.sp)
            Text(email, color = colorResource(id = R.color.email), fontFamily = FontFamily(
                Font(R.font.nunito_regular)
            ), fontWeight = FontWeight.W400, fontSize = 14.sp)
        }
        Column {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PasswordManagerTheme {
        AccountElement(name = "Apple", email = "sazbak@gmail.com")
    }
}

package com.example.passwordmanager.ui.screen.accountsettings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.theme.PasswordManagerTheme

class AccountSettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: ""
        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""
        val url = intent.getStringExtra("url") ?: ""

        setContent {
            PasswordManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .background(colorResource(id = R.color.settings_bottom_bg))
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 29.dp),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Image(
                                painterResource(id = R.drawable.settings_bg),
                                contentDescription = stringResource(
                                    id = R.string.settings_bg_content
                                ),
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(581.dp)
                            )
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = stringResource(id = R.string.settings_title),
                                    color = colorResource(id = R.color.settings_title),
                                    fontFamily = FontFamily(
                                        Font(R.font.nunito_regular)
                                    ),
                                    fontWeight = FontWeight.W500,
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(top = 46.dp, bottom = 76.dp)
                                )
                                Column(
                                    modifier = Modifier
                                        .padding(bottom = 46.dp, start = 23.dp, end = 23.dp)
                                        .fillMaxWidth()
                                ) {
                                    Column(
                                        Modifier
                                            .padding(bottom = 32.dp)
                                    ) {
                                        SettingsLabelText(text = stringResource(id = R.string.account_name_label))
                                        SettingsTextField(name)
                                    }
                                    Column(Modifier.padding(bottom = 32.dp)) {
                                        SettingsLabelText(text = stringResource(id = R.string.account_email_label))
                                        SettingsTextField(email)
                                    }
                                    Box(Modifier.padding(bottom = 32.dp)) {
                                        PasswordField(password = password)
                                    }
                                    Column {
                                        SettingsLabelText(text = stringResource(id = R.string.website_url_label))
                                        SettingsTextField(url)
                                    }
                                }
                                OutlinedButton(
                                    onClick = { },
                                    border = BorderStroke(
                                        0.5.dp,
                                        colorResource(id = R.color.settings_save_border)
                                    ),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        backgroundColor = Color.Transparent
                                    ),
                                    shape = RoundedCornerShape(16.5.dp),
                                    modifier = Modifier.padding(bottom = 31.dp)
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.details_save_btn),
                                        color = colorResource(id = R.color.settings_save_text),
                                        fontFamily = FontFamily(
                                            Font(R.font.nunito_regular)
                                        ),
                                        fontWeight = FontWeight.W400,
                                        fontSize = 18.sp,
                                    )
                                }
                            }
                        }
                        OutlinedButton(
                            onClick = { finish() },
                            border = BorderStroke(
                                0.5.dp,
                                colorResource(id = R.color.button_outline)
                            ),
                            shape = RoundedCornerShape(16.5.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.dismiss),
                                color = colorResource(id = R.color.button_outline),
                                fontFamily = FontFamily(
                                    Font(R.font.nunito_regular)
                                ),
                                fontWeight = FontWeight.W400,
                                fontSize = 18.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}
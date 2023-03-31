package com.example.passwordmanager.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.theme.PasswordManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel by viewModels<MainViewModel>()
                    Box {
                        Column {
                            Box(Modifier.fillMaxWidth()) {
                                Image(
                                    painter = painterResource(id = R.drawable.top_bar),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Row(Modifier.padding(top = 39.dp)) {
                                    Text(
                                        text = stringResource(id = R.string.main_page_title),
                                        color = colorResource(id = R.color.main_page_title),
                                        fontFamily = FontFamily(
                                            Font(R.font.nunito_regular)
                                        ),
                                        fontWeight = FontWeight.W500,
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.weight(1.0f)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.swar_order),
                                        contentDescription = stringResource(id = R.string.swap_order),
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clickable {
                                                viewModel.switchOrder()
                                            }
                                    )
                                }
                            }
                            AccountList(
                                viewModel.accounts,
                                viewModel.dialogState,
                                viewModel::updateActiveAccountPassword
                            )
                        }
                        viewModel.showDialog().invoke()
                    }
                }
            }
        }
    }
}





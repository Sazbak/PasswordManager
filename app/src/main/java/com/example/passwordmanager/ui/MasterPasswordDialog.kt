package com.example.passwordmanager.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.passwordmanager.R

@Composable
fun MasterPasswordDialog() {
    var showDialog = rememberSaveable { mutableStateOf(false) }.value

    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false },
            content = {
                Column(
                    Modifier.background(
                        colorResource(id = R.color.master_pass_dialog_bg),
                        RoundedCornerShape(26.dp)
                    )
                ) {
                    Column(Modifier.background(color = colorResource(id = R.color.app_signature_color))) {
                        Text(
                            text = stringResource(id = R.string.master_pass_dialog_title),
                            color = colorResource(id = R.color.master_pass_dialog_title),
                            fontFamily = FontFamily(
                                Font(R.font.nunito_regular)
                            ),
                            fontWeight = FontWeight.W500,
                            fontSize = 18.sp
                        )
                        TextField(
                            value = "",
                            onValueChange = { },
                            label = { },
                            modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 21.dp)
                        )
                    }
                    Row {
                        DialogButton(text = stringResource(id = R.string.master_pass_dialog_show_btn), onClick = {})
                        DialogButton(text = stringResource(id = R.string.master_pass_dialog_cancel_btn), onClick = {})
                    }
                }
            }
        )
    }
}

@Composable
fun DialogButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(
            text = text,
            color = colorResource(id = R.color.app_signature_color),
            fontFamily = FontFamily(
                Font(R.font.nunito_regular)
            ),
            fontWeight = FontWeight.W400,
            fontSize = 18.sp
        )
    }
}
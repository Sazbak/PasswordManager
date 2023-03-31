package com.example.passwordmanager.ui.dialog

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.screen.main.Dialogs

@Composable
fun MasterPasswordDialog(
    masterPassword: String,
    dialogHandler: MutableState<Dialogs>
) {
    val inputText = remember { mutableStateOf("") }

    GeneralDialog(
        buttonLeftClick = {
            dialogHandler.value =
                if (inputText.value == masterPassword) {

                    Dialogs.ACCOUNTPASSWORD

                } else {
                    Dialogs.WRONGPASSWORD
                }

        },
        buttonLeftText = stringResource(id = R.string.master_pass_dialog_show_btn),
        buttonRightText = stringResource(id = R.string.dismiss),
        dialogHandler = dialogHandler
    ) {
        Text(
            text = stringResource(id = R.string.master_pass_dialog_title),
            color = colorResource(id = R.color.master_pass_dialog_title),
            fontFamily = FontFamily(
                Font(R.font.nunito_regular)
            ),
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 23.dp)
        )
        TextField(
            value = inputText.value,
            onValueChange = {
                inputText.value = it
            },
            label = { },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = colorResource(id = R.color.master_pass_dialog_text_bottom),
                unfocusedIndicatorColor = colorResource(id = R.color.master_pass_dialog_text_bottom),
            ),
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, bottom = 21.dp)
        )
    }
}


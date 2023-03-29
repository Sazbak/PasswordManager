package com.example.passwordmanager.ui.dialog

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.Dialogs
import com.example.passwordmanager.R

@Composable
fun WrongPasswordDialog(
    dialogHandler: MutableState<Dialogs>
) {
    GeneralDialog(
        buttonLeftClick = {
            dialogHandler.value =
                Dialogs.MASTERPASSWORD
        },
        buttonLeftText = stringResource(id = R.string.wrong_pass_dialog_again_btn),
        buttonRightText = stringResource(id = R.string.wrong_pass_dialog_cancel_btn),
        dialogHandler = dialogHandler
    ) {
        Text(
            text = stringResource(id = R.string.wrong_pass_dialog_title),
            color = colorResource(id = R.color.master_pass_dialog_title),
            fontFamily = FontFamily(
                Font(R.font.nunito_regular)
            ),
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 14.dp)
        )
    }
}
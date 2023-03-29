package com.example.passwordmanager.ui.dialog

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.Dialogs
import com.example.passwordmanager.R

@Composable
fun AccountPasswordDialog(
    accountPassword: String,
    dialogHandler: MutableState<Dialogs>
) {
    GeneralDialog(
        buttonLeftClick = { dialogHandler.value = Dialogs.PASSWORDCOPIED },
        buttonLeftText = stringResource(id = R.string.account_pass_dialog_copy_btn),
        buttonRightText = stringResource(id = R.string.account_pass_dialog_cancel_btn),
        dialogHandler = dialogHandler
    ) {
        Text(
            text = stringResource(id = R.string.account_pass_dialog_pass_label),
            fontFamily = FontFamily(
                Font(R.font.nunito_regular)
            ),
            color = colorResource(R.color.account_pass_dialog_title),
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 15.dp, bottom = 9.dp)
        )
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = accountPassword,
            color = colorResource(R.color.account_pass_dialog_pass),
            fontWeight = FontWeight.W700,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 14.dp)
        )
    }
}
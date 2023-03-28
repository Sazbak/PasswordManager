package com.example.passwordmanager.ui.dialog

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R

@Composable
fun AccountPasswordDialog(
    accountPass: String,
    dialogHandler: MutableState<@Composable () -> Unit>
) {
    GeneralDialog(
        buttonLeftClick = {},
        buttonLeftText = stringResource(id = R.string.account_pass_dialog_copy_btn),
        buttonRightText = stringResource(id = R.string.account_pass_dialog_cancel_btn),
        dialogHandler = dialogHandler
    ) {
        Text(text = stringResource(id = R.string.account_pass_dialog_pass_label))
        Spacer(modifier = Modifier.height(9.dp))
        Text(text = accountPass)
    }
}
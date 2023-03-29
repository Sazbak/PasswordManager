package com.example.passwordmanager.ui.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.passwordmanager.Dialogs
import com.example.passwordmanager.R

@Composable
fun PasswordCopiedDialog(dialogHandler: MutableState<Dialogs>) {
    Dialog(
        onDismissRequest = { dialogHandler.value = Dialogs.NODIALOG },
        content = {
            Box(Modifier.padding(horizontal = 24.dp)) {
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.app_signature_color),
                            RoundedCornerShape(26.dp)
                        )
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.copied_pass_dialog_text),
                        fontFamily = FontFamily(
                            Font(R.font.nunito_regular)
                        ),
                        color = colorResource(R.color.account_pass_dialog_title),
                        fontWeight = FontWeight.W700,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 15.dp)
                    )
                }
            }
        }
    )
}
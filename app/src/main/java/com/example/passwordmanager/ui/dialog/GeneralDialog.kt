package com.example.passwordmanager.ui.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.screen.main.Dialogs

@Composable
fun GeneralDialog(
    buttonLeftClick: () -> Unit,
    buttonLeftText: String,
    buttonRightText: String,
    dialogHandler: MutableState<Dialogs>,
    topLayout: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = { dialogHandler.value = Dialogs.NODIALOG },
        content = {
            Box(Modifier.padding(horizontal = 24.dp)) {
                Column(
                    Modifier.background(
                        colorResource(id = R.color.master_pass_dialog_bg),
                        RoundedCornerShape(26.dp)
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        Modifier
                            .background(
                                color = colorResource(id = R.color.app_signature_color),
                                RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp)
                            )
                            .padding(horizontal = 60.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        topLayout()
                    }
                    Row(Modifier.padding(vertical = 18.5.dp)) {
                        DialogButton(
                            text = buttonLeftText,
                            onClick = buttonLeftClick
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        DialogButton(
                            text = buttonRightText,
                            onClick = {
                                dialogHandler.value = Dialogs.NODIALOG
                            }
                        )
                    }
                }
            }
        }
    )
}


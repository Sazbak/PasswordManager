package com.example.passwordmanager.ui.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Composable
fun DialogButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = colorResource(id = R.color.master_pass_dialog_button_bg)
        ),
        border = BorderStroke(
            1.dp,
            colorResource(id = R.color.button_outline)
        ),
        shape = RoundedCornerShape(16.5.dp)
    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.app_signature_color),
            fontFamily = FontFamily(
                Font(R.font.nunito_regular)
            ),
            fontWeight = FontWeight.W400,
            fontSize = 18.sp,
        )
    }
}
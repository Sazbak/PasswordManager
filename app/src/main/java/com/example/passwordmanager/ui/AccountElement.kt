package com.example.passwordmanager.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.theme.PasswordManagerTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun AccountElement(name: String, email: String) {
    val imageSize = 30.dp

    Column {
        Row (modifier = Modifier.padding(start = 22.dp, end = 22.dp, top = 15.8.dp, bottom = 13.2.dp), verticalAlignment = Alignment.CenterVertically){
            Column(modifier = Modifier.weight(1.0f)) {
                Text(name, color = colorResource(id = R.color.account_title), fontFamily = FontFamily(
                    Font(R.font.nunito_regular)
                ), fontWeight = FontWeight.W400, fontSize = 18.sp)
                Text(email, color = colorResource(id = R.color.email), fontFamily = FontFamily(
                    Font(R.font.nunito_regular)
                ), fontWeight = FontWeight.W400, fontSize = 14.sp)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = stringResource(id = R.string.search_icon_content),
                    modifier = Modifier.size(imageSize)
                )
                Image(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = stringResource(id = R.string.info_icon_content),
                    modifier = Modifier.size(imageSize)
                )
            }
        }
        Divider(color = colorResource(id = R.color.divider), thickness = 1.dp)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PasswordManagerTheme {
        AccountElement(name = "Apple", email = "sazbak@gmail.com")
    }
}

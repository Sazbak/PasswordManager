package com.example.passwordmanager.ui.screen.main

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R
import com.example.passwordmanager.model.Account
import com.example.passwordmanager.ui.screen.accountsettings.AccountSettingsActivity

@Composable
fun AccountList(
    accountListState: State<List<Account>>,
    dialogHandler: MutableState<Dialogs>,
    accountPasswordUpdater: (String) -> Unit
) {
    LazyColumn {
        items(accountListState.value) { account ->
            AccountElement(
                name = account.name,
                email = account.email,
                accountPassword = account.password,
                url = account.url,
                accountPasswordUpdater = { accountPasswordUpdater(account.password) },
                dialogHandler = dialogHandler
            )
        }
    }
}

@Composable
fun AccountElement(
    name: String,
    email: String,
    accountPassword: String,
    url: String,
    accountPasswordUpdater: () -> Unit,
    dialogHandler: MutableState<Dialogs>
) {
    val imageSize = 30.dp
    val context = LocalContext.current

    Column {
        Row(
            modifier = Modifier.padding(
                start = 22.dp,
                end = 22.dp,
                top = 15.8.dp,
                bottom = 13.2.dp
            ), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1.0f)) {
                Text(
                    name,
                    color = colorResource(id = R.color.account_title),
                    fontFamily = FontFamily(
                        Font(R.font.nunito_regular)
                    ),
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp
                )
                Text(
                    email, color = colorResource(id = R.color.email), fontFamily = FontFamily(
                        Font(R.font.nunito_regular)
                    ), fontWeight = FontWeight.W400, fontSize = 14.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = stringResource(id = R.string.search_icon_content),
                    modifier = Modifier
                        .size(imageSize)
                        .clickable {
                            accountPasswordUpdater()
                            dialogHandler.value = Dialogs.MASTERPASSWORD
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.info),
                    contentDescription = stringResource(id = R.string.info_icon_content),
                    modifier = Modifier
                        .size(imageSize)
                        .clickable {
                            val intent = Intent(context, AccountSettingsActivity::class.java)
                            intent.putExtra("name", name)
                            intent.putExtra("email", email)
                            intent.putExtra("password", accountPassword)
                            intent.putExtra("url", url)
                            context.startActivity(intent)
                        }
                )
            }
        }
        Divider(color = colorResource(id = R.color.divider), thickness = 1.dp)
    }

}
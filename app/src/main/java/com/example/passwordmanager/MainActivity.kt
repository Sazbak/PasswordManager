package com.example.passwordmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.passwordmanager.model.Account
import com.example.passwordmanager.model.AccountsResponse
import com.example.passwordmanager.ui.AccountElement
import com.example.passwordmanager.ui.theme.PasswordManagerTheme
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<MainViewModel>()

        setContent {
            PasswordManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AccountList(viewModel)
                }
            }
        }
    }
}
@Composable
fun AccountList(viewModel: MainViewModel) {
//    val accounts = listOf<Account>(
//        Account("Twitter", "sazbak@gmail.com"),
//        Account("Facebook", "sazbak@gmail.com"),
//        Account("Instagram", "sazbak@gmail.com"),
//        Account("Github", "sazbak@gmail.com")
//    )
    val accountListState = viewModel.accounts.collectAsStateWithLifecycle().value
    LazyColumn {
        items(accountListState) { account ->
            AccountElement(account.name, account.email)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//
//
//
//    PasswordManagerTheme {
//        AccountList(accounts)
//    }
//}
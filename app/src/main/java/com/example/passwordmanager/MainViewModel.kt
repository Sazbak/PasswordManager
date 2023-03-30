package com.example.passwordmanager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordmanager.model.Account
import com.example.passwordmanager.ui.dialog.AccountPasswordDialog
import com.example.passwordmanager.ui.dialog.MasterPasswordDialog
import com.example.passwordmanager.ui.dialog.PasswordCopiedDialog
import com.example.passwordmanager.ui.dialog.WrongPasswordDialog
import kotlinx.coroutines.launch

enum class Dialogs {
    MASTERPASSWORD,
    WRONGPASSWORD,
    ACCOUNTPASSWORD,
    PASSWORDCOPIED,
    NODIALOG
}

enum class AccountOrders {
    ATOZ,
    ZOTA
}

class MainViewModel : ViewModel() {
    private lateinit var _masterPassword: String
    private var _accountPassword = ""
    private var accountsOrder = AccountOrders.ATOZ
    val accounts = mutableStateOf<List<Account>>(emptyList())
    val dialogState =
        mutableStateOf(Dialogs.NODIALOG)

    init {
        fetchAccounts()
    }

    private fun fetchAccounts() {
        viewModelScope.launch {
            val response = APIClient.service.getAccounts()
            accounts.value = response.accounts.sortedBy { it.name }
            _masterPassword = response.masterPassword
        }
    }

    fun updateActiveAccountPassword(password: String) {
        _accountPassword = password
    }

    fun showDialog(): @Composable () -> Unit {
        return when (dialogState.value) {
            Dialogs.MASTERPASSWORD -> {
                {
                    MasterPasswordDialog(
                        masterPassword = _masterPassword,
                        dialogHandler = dialogState
                    )
                }
            }
            Dialogs.WRONGPASSWORD -> {
                { WrongPasswordDialog(dialogState) }
            }
            Dialogs.ACCOUNTPASSWORD -> {
                {
                    AccountPasswordDialog(
                        accountPassword = _accountPassword,
                        dialogHandler = dialogState
                    )
                }
            }
            Dialogs.PASSWORDCOPIED -> {
                {
                    LocalClipboardManager.current.setText(AnnotatedString(_accountPassword))
                    PasswordCopiedDialog(dialogHandler = dialogState)
                }
            }
            Dialogs.NODIALOG -> {
                { }
            }
        }
    }

    fun switchOrder() {
        accounts.value = if (accountsOrder == AccountOrders.ZOTA) {
            accountsOrder = AccountOrders.ATOZ
            accounts.value.sortedBy { it.name }
        } else {
            accountsOrder = AccountOrders.ZOTA
            accounts.value.sortedByDescending { it.name }
        }
    }
}

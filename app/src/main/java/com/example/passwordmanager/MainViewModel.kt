package com.example.passwordmanager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordmanager.model.Account
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val accounts = mutableStateOf<List<Account>>(emptyList())
    val dialogHandler =
        mutableStateOf<@Composable () -> Unit>({})

    init {
        fetchAccounts()
    }

    private fun fetchAccounts() {
        viewModelScope.launch {
            val response = APIClient.service.getAccounts()
            accounts.value = response.accounts
        }
    }
}

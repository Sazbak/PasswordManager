package com.example.passwordmanager.model;

data class AccountsResponse(
   val accounts: List<Account>,
   val masterPassword: String
)

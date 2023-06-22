package com.rami.kiparocleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rami.cleancodetest.data.repository.UserRepoImpl
import com.rami.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepo by lazy(LazyThreadSafetyMode.NONE) {
        UserRepoImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.rami.cleancodetest.domain.usecase.GetUserNameUseCase(
            userRepo = userRepo
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.rami.cleancodetest.domain.usecase.SaveUerNameUseCase(
            userRepo = userRepo
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }


}
package com.rami.kiparocleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rami.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.rami.domain.usecase.GetUserNameUseCase
import com.rami.domain.usecase.SaveUerNameUseCase
import rami.data.repository.UserRepoImpl

class MainViewModelFactory(
   context: Context
) : ViewModelProvider.Factory {

    private val userRepo by lazy(LazyThreadSafetyMode.NONE) {
        UserRepoImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepo = userRepo
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
       SaveUerNameUseCase(
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
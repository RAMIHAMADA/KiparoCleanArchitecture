package com.rami.kiparocleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rami.cleancodetest.data.repository.UserRepoImpl
import com.rami.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.rami.cleancodetest.domain.usecase.GetUserNameUseCase
import com.rami.cleancodetest.domain.usecase.SaveUerNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUerNameUseCase,
) : ViewModel() {


    var resultLive = MutableLiveData<String>()

    init {
        Log.e("COP", "VM created")
    }

    override fun onCleared() {
        Log.e("COP", "VM created")
        super.onCleared()
    }

    fun save(text: String) {
        val params = com.rami.cleancodetest.domain.models.SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLive.value  = "Save result = $resultData"
    }

    fun load() {
        val userName: com.rami.cleancodetest.domain.models.UserName =
            getUserNameUseCase.execute()
        resultLive.value  = "${userName.firstName} ${userName.lastName}"
    }
}
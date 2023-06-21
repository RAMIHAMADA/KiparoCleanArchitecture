package com.rami.cleancodetest.domain.usecase

import com.rami.cleancodetest.domain.models.SaveUserNameParam
import com.rami.cleancodetest.domain.repository.UserRepo

class SaveUerNameUseCase(private val userRepo: UserRepo) {

    fun execute(param: SaveUserNameParam): Boolean{
       val result: Boolean = userRepo.saveName(saveParam = param)
        return result
    }
}
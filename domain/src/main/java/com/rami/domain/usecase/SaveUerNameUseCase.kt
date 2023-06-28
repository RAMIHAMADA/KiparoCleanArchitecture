package com.rami.domain.usecase


import com.rami.domain.models.SaveUserNameParam
import com.rami.domain.ripository.UserRepo

class SaveUerNameUseCase(private val userRepo: UserRepo) {

    fun execute(param: SaveUserNameParam): Boolean{
       val result: Boolean = userRepo.saveName(saveParam = param)
        return result
    }
}
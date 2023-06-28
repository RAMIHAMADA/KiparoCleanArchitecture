package com.rami.domain.usecase


import com.rami.domain.models.UserName
import com.rami.domain.ripository.UserRepo

class GetUserNameUseCase(private val userRepo: UserRepo) {

    fun execute(): UserName {
        return userRepo.getName()
    }
}
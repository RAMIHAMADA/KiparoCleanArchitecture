package com.rami.cleancodetest.domain.usecase

import com.rami.cleancodetest.domain.models.UserName
import com.rami.cleancodetest.domain.repository.UserRepo

class GetUserNameUseCase(private val userRepo: UserRepo) {

    fun execute(): UserName {
        return userRepo.getName()
    }
}
package com.rami.cleancodetest.domain.repository

import com.rami.cleancodetest.domain.models.SaveUserNameParam
import com.rami.cleancodetest.domain.models.UserName

interface UserRepo {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}
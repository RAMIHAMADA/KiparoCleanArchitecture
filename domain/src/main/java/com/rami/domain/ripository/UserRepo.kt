package com.rami.domain.ripository


import com.rami.domain.models.SaveUserNameParam
import com.rami.domain.models.UserName

interface UserRepo {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}
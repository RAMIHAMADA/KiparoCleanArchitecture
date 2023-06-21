package com.rami.cleancodetest.data.storage

import com.rami.cleancodetest.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}
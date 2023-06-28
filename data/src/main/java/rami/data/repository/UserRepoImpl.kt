package rami.data.repository

import com.rami.cleancodetest.data.storage.models.User
import com.rami.cleancodetest.data.storage.UserStorage
import com.rami.domain.models.SaveUserNameParam
import com.rami.domain.models.UserName
import com.rami.domain.ripository.UserRepo


class UserRepoImpl(private val userStorage: UserStorage) : UserRepo {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)

    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }


}
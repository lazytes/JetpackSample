package io.github.lazytes.jetpack.data.source.local

import io.github.lazytes.jetpack.data.User
import io.github.lazytes.jetpack.data.source.Local
import io.github.lazytes.jetpack.data.source.UserDataSource

/**
 * @author lazytes
 */
@Local
class UserLocalDataSource private constructor() : UserDataSource {

    companion object {
        val INSTANCE: UserLocalDataSource by lazy { UserLocalDataSource() }

        private val SAVED_DATA = HashMap<Int, User>()
    }

    override fun addUser(user: User, callback: (Int) -> Unit) {
        user.id?.let { SAVED_DATA[it] = user }
    }

    override fun deleteUser(user: User) {
        SAVED_DATA.remove(user.id)
        TODO("Not yet implemented")
    }

    override fun updateAddress(address: String) {
        TODO("Not yet implemented")
    }
}
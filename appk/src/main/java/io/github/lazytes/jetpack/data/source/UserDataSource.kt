package io.github.lazytes.jetpack.data.source

import io.github.lazytes.jetpack.data.User

/**
 * @author lazytes
 */
interface UserDataSource {

    fun updateAddress(address: String)

    fun addUser(user: User, callback: (Int) -> Unit)

    fun deleteUser(user: User)
}
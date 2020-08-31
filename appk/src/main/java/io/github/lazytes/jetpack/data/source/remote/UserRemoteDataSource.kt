package io.github.lazytes.jetpack.data.source.remote

import io.github.lazytes.jetpack.data.User
import io.github.lazytes.jetpack.data.source.Remote
import io.github.lazytes.jetpack.data.source.UserDataSource
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author lazytes
 */
@Remote
class UserRemoteDataSource private constructor() : UserDataSource {

    companion object {
        val INSTANCE: UserRemoteDataSource
                by lazy(LazyThreadSafetyMode.NONE) { UserRemoteDataSource() }

        private val AUTO_ID = AtomicInteger()
        private val CACHED = ArrayList<User>()
    }

    override fun addUser(user: User, callback: (Int) -> Unit) {
        with(AUTO_ID.incrementAndGet()) {
            if (this % 3 == 0) callback.invoke(-1)
            else CACHED.add(user.also { it.id = this }).also { callback.invoke(user.id!!) }
        }
    }

    override fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun updateAddress(address: String) {
        TODO("Not yet implemented")
    }
}
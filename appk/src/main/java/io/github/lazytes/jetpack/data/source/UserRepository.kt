/*
 * Copyright 2020 lazytes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.lazytes.jetpack.data.source

import io.github.lazytes.jetpack.data.User
import io.github.lazytes.jetpack.data.source.local.UserLocalDataSource
import io.github.lazytes.jetpack.data.source.remote.UserRemoteDataSource

/**
 * model层
 *
 * @author lazytes
 */
class UserRepository constructor(
    @Local private val localDataSource: UserLocalDataSource,
    @Remote private val remoteDataSource: UserRemoteDataSource
) : UserDataSource {

    override fun addUser(user: User, callback: (Int) -> Unit) {
        remoteDataSource.addUser(user) {
            localDataSource.addUser(user) { }
            callback.invoke(it)
        }
    }

    override fun deleteUser(user: User) {
        localDataSource.deleteUser(user)
        remoteDataSource.deleteUser(user)
    }

    override fun updateAddress(address: String) {
        localDataSource.updateAddress(address)
        remoteDataSource.updateAddress(address)
    }
}
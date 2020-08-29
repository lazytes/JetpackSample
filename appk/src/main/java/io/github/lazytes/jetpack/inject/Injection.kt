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

package io.github.lazytes.jetpack.inject

import io.github.lazytes.jetpack.MainViewModelFactory
import io.github.lazytes.jetpack.data.UserRepository

/**
 * Repository和Factory应为全局变量
 *
 * 所以通过object来实现单例
 *
 * 也可通过dagger2或者dagger hilt来实现依赖注入(IOC)
 *
 * @author lazytes
 */
object Injection {

    private fun getUserRepository(): UserRepository {
        return UserRepository()
    }

    fun provideMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(getUserRepository())
    }
}
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

package io.github.lazytes.jetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.lazytes.jetpack.data.source.UserRepository
import java.lang.IllegalArgumentException

/**
 * 当[ViewModel]的构造函数带参数时,需要实现[ViewModelProvider.Factory]来生成[ViewModel]
 *
 * @author lazytes
 * @see ViewModelProvider.Factory
 * @see MainViewModel
 */
class MainViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // 判断传入的class是否匹配
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            // 在这里生成ViewModel对象
            return MainViewModel(repository) as T
        }
        // 不匹配时抛出异常
        throw IllegalArgumentException("factory require class ${MainViewModel::class.simpleName}")
    }
}
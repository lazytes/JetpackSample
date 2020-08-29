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

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.lazytes.jetpack.data.UserRepository

/**
 *
 * [ViewModel]的构造函数带参数时无法通过
 * ```
 * class MainFragment : Fragment() {
 *      override fun onActivityCreated(savedInstanceState: Bundle?) {
 *          super.onActivityCreated(savedInstanceState)
 *          val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
 *      }
 * }
 * ```
 * 获得
 *
 * 所以需要实现[Factory][androidx.lifecycle.ViewModelProvider.Factory]来获得[MainViewModel]
 *
 * @author lazytes
 * @see ViewModel
 * @see androidx.lifecycle.ViewModelProvider
 * @see MainViewModelFactory
 */
class MainViewModel(
    private val repository: UserRepository
) : ViewModel() {
    val user = MutableLiveData<String>()
}
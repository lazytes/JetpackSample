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

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.github.lazytes.jetpack.databinding.MainFragmentBinding
import io.github.lazytes.jetpack.inject.Injection

/**
 *
 * @author lazytes
 */
class MainFragment : Fragment() {
    private var binding: MainFragmentBinding? = null

    // 通过fragment-ktx实现延迟加载
    private val viewModel: MainViewModel by viewModels {
        Injection.provideMainViewModelFactory()
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = MainFragmentBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
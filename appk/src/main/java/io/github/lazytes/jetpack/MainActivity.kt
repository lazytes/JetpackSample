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
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import io.github.lazytes.jetpack.databinding.MainActivityBinding

/**
 * 使用的库包括: ViewBinding,Lifecycle
 *
 * View层相关查看[MainFragment]
 *
 * @author lazytes
 * @see MainFragment
 */
class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.simpleName

        /**
         * 建议使用[DefaultLifecycleObserver]代替注解来实现
         *
         * 打印每个生命周期查看[Activity][android.app.Activity]和
         * [LifecycleObserver][androidx.lifecycle.LifecycleObserver]的执行顺序
         *
         */
        class MainObserver : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                Log.d(TAG, "Observer onCreate")
            }

            override fun onStart(owner: LifecycleOwner) {
                Log.d(TAG, "Observer onStart")
            }

            override fun onResume(owner: LifecycleOwner) {
                Log.d(TAG, "Observer onResume")
            }

            override fun onPause(owner: LifecycleOwner) {
                Log.d(TAG, "Observer onPause")
            }

            override fun onStop(owner: LifecycleOwner) {
                Log.d(TAG, "Observer onStop")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                Log.d(TAG, "Observer onDestroy")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding 在 Activity 中的用法
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(supportFragmentManager) {
            findFragmentById(binding.frameContent.id).takeIf { it == null }.run {
                // fragment-ktx 简化
                commit { add(binding.frameContent.id, MainFragment.newInstance()) }
            }
        }

        lifecycle.addObserver(MainObserver())
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}
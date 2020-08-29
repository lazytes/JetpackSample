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
import androidx.appcompat.app.AppCompatActivity
import io.github.lazytes.jetpack.databinding.MainActivityBinding

/**
 *
 * @author lazytes
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fragment =
            supportFragmentManager.findFragmentById(binding.frameContent.id) as MainFragment?
        if (fragment == null) {
            fragment = MainFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(binding.frameContent.id, fragment).commit()
        }
    }
}
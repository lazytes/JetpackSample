package io.github.lazytes.jetpack.data

/**
 * @author lazytes
 */
data class User(var id: Int?, var name: String, var address: String?) {
    constructor(name: String, address: String?) : this(null, name, address)
}
package ru.vood.generator.read.dto

class KeyValDto<T> {
    var key: String? = null
    var `val`: T? = null
        private set

    constructor()
    constructor(key: String?, `val`: T) {
        this.key = key
        this.`val` = `val`
    }

    fun setVal(`val`: T) {
        this.`val` = `val`
    }
}
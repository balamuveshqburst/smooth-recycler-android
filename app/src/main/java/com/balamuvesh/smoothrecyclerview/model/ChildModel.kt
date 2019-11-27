package com.balamuvesh.smoothrecyclerview.model

data class ChildModel(private val _size: Int? = null) {
    val size = _size ?: 10
}
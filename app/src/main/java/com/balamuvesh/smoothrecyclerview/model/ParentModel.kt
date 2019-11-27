package com.balamuvesh.smoothrecyclerview.model

data class ParentModel(val _size: Int? = null) {
    val title: String = "HEAD"
    val size = _size ?: 10
}
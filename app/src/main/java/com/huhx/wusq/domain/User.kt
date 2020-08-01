package com.huhx.wusq.domain

data class User(
    val id: Int,
    var fullname: String,
    var imageUrl: String,
    var signature: String,
    var createTime: String
)
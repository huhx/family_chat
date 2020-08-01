package com.huhx.family.listener

import com.huhx.family.domain.User

interface OnItemClickListener {

    fun onItemClick(user: User)

    fun onItemLongClick(user: User)
}
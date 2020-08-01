package com.huhx.wusq.listener

import com.huhx.wusq.domain.User

interface OnItemClickListener {

    fun onItemClick(user: User)

    fun onItemLongClick(user: User)
}
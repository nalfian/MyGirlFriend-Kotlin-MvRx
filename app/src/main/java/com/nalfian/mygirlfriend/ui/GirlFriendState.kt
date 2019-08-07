package com.nalfian.mygirlfriend.ui

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.nalfian.mygirlfriend.data.MyGirlFriend

data class GirlFriendState(
    val girlFriends: Async<List<MyGirlFriend>> = Uninitialized,
    val lovedGirlFriendId: Long? = null,
    val meetupRequest: Async<MyGirlFriend> = Uninitialized
) : MvRxState {
    val lovedMyGirlFriend: MyGirlFriend? = girlFriend(lovedGirlFriendId)

    fun girlFriend(girlFriendId: Long?): MyGirlFriend? = girlFriends()?.firstOrNull { it.id == girlFriendId }
}
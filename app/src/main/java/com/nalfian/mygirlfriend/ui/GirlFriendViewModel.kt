package com.nalfian.mygirlfriend.ui

import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.nalfian.mygirlfriend.MyGirlFriendApplication
import com.nalfian.mygirlfriend.internal.MvRxViewModel
import com.nalfian.mygirlfriend.data.MyGirlFriendRepository
import io.reactivex.schedulers.Schedulers

class GirlFriendViewModel(
    state: GirlFriendState,
    private val myGirlFriendRepository: MyGirlFriendRepository
) : MvRxViewModel<GirlFriendState>(state) {

    init {
        myGirlFriendRepository.getDogs()
            .subscribeOn(Schedulers.io())
            .execute { copy(girlFriends = it) }
    }

    fun loveGirlFriend(girlFriendId: Long) = setState { copy(lovedGirlFriendId = girlFriendId) }

    fun meetLoved() = withState { state ->
        val loveGirlFriend = state.lovedMyGirlFriend ?: throw IllegalStateException("You must love a girlfriend first!")
        myGirlFriendRepository.meetGirlFriend(loveGirlFriend)
            .subscribeOn(Schedulers.io())
            .execute { copy(meetupRequest = it) }
    }

    companion object : MvRxViewModelFactory<GirlFriendViewModel, GirlFriendState> {
        override fun create(viewModelContext: ViewModelContext, state: GirlFriendState): GirlFriendViewModel? {
            val myGirlFriendRepository = viewModelContext.app<MyGirlFriendApplication>().myGirlFriendRepository
            return GirlFriendViewModel(state, myGirlFriendRepository)
        }
    }
}
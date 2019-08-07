package com.nalfian.mygirlfriend.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.nalfian.mygirlfriend.R
import com.nalfian.mygirlfriend.internal.withModels
import com.nalfian.mygirlfriend.ui.views.girlFriendRow
import com.nalfian.mygirlfriend.ui.views.titleRow
import kotlinx.android.synthetic.main.fragment_mygirlfriend.*

class MeetupFragment : BaseMvRxFragment() {
    private val viewModel: GirlFriendViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_meetup, container, false)
    }

    override fun invalidate() = withState(viewModel) { state ->
        recyclerView.withModels {
            titleRow {
                id("title")
                title(R.string.meet_your_girlfriend)
            }
            state.meetupRequest()?.let { girlFriend ->
                girlFriendRow {
                    id(girlFriend.id)
                    girlFriend(girlFriend)
                }
            }
        }
    }
}
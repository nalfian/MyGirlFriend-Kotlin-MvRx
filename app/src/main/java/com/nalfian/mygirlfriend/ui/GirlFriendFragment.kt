package com.nalfian.mygirlfriend.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.*
import com.nalfian.mygirlfriend.R
import com.nalfian.mygirlfriend.internal.withModels
import com.nalfian.mygirlfriend.ui.views.girlFriendRow
import kotlinx.android.synthetic.main.fragment_mygirlfriend.*

class GirlFriendFragment : BaseMvRxFragment() {

    private val viewModel: GirlFriendViewModel by activityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.asyncSubscribe(GirlFriendState::meetupRequest, onSuccess = {
            findNavController().navigate(R.id.action_meetup)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mygirlfriend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adoptButton.setOnClickListener {
            viewModel.meetLoved()
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        loadingAnimation.isVisible = state.girlFriends is Loading || state.meetupRequest is Loading

        adoptButton.isVisible = state.lovedMyGirlFriend != null
        adoptButton.text = getString(R.string.meetup, state.lovedMyGirlFriend?.name)

        recyclerView.isVisible = state.meetupRequest is Uninitialized || state.meetupRequest is Fail
        recyclerView.withModels {
            state.girlFriends()?.forEach { girlFriend ->
                girlFriendRow {
                    id(girlFriend.id)
                    girlFriend(girlFriend)
                    clickListener { _ ->
                        findNavController().navigate(
                            R.id.actionDetail,
                            GirlFriendDetailFragment.arg(girlFriend.id)
                        )
                    }
                }
            }
        }
    }
}
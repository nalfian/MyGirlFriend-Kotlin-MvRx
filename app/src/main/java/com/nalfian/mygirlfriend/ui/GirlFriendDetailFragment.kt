package com.nalfian.mygirlfriend.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.*
import com.nalfian.mygirlfriend.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_mygirlfriend_detail.*

class GirlFriendDetailFragment : BaseMvRxFragment() {

    private val viewModel: GirlFriendViewModel by activityViewModel()
    private val myGirlFriendId: Long by args()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mygirlfriend_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loveButton.setOnClickListener {
            viewModel.loveGirlFriend(myGirlFriendId)
            findNavController().popBackStack()
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        val myGirlFriend = state.girlFriend(myGirlFriendId) ?: throw IllegalStateException("Cannot find girlfriend with id $myGirlFriendId")
        Picasso.with(requireContext())
            .load(myGirlFriend.imageUrl)
            .into(image)
        nameView.text = myGirlFriend.name
        descriptionView.text = myGirlFriend.description
    }

    companion object {
        fun arg(dogId: Long): Bundle {
            val args = Bundle()
            args.putLong(MvRx.KEY_ARG, dogId)
            return args
        }
    }
}
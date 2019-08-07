package com.nalfian.mygirlfriend.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.nalfian.mygirlfriend.R
import com.nalfian.mygirlfriend.data.MyGirlFriend
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.girlfriend_row.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class GirlFriendRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.girlfriend_row, this, true)
    }

    @ModelProp
    fun setGirlFriend(myGirlFriend: MyGirlFriend) {
        Picasso.with(context)
            .load(myGirlFriend.imageUrl)
            .into(image)
        nameView.text = myGirlFriend.name
    }

    @CallbackProp
    fun setClickListener(listener: OnClickListener?) {
        setOnClickListener(listener)
    }
}
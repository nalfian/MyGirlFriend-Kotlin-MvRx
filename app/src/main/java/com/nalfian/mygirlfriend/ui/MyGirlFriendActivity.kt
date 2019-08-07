package com.nalfian.mygirlfriend.ui

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import com.nalfian.mygirlfriend.R

class MyGirlFriendActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mygirlfriend)
    }
}


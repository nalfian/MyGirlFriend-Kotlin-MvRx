package com.nalfian.mygirlfriend

import android.app.Application
import com.nalfian.mygirlfriend.data.MyGirlFriendRepository

class MyGirlFriendApplication : Application() {
    val myGirlFriendRepository = MyGirlFriendRepository()
}

package com.diyetistan.diyetistanapp.helper

import android.support.v4.app.Fragment
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.ui.*

enum class BottomNavigationPosition(val position: Int, val id: Int) {
    HOME(0, R.id.home),
    DASHBOARD(1, R.id.dashboard),
    NOTIFICATIONS(2, R.id.notifications),
    PROFILE(3, R.id.profile),
    BLOG(3, R.id.blog);
}

fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.HOME.id -> BottomNavigationPosition.HOME
    BottomNavigationPosition.DASHBOARD.id -> BottomNavigationPosition.DASHBOARD
    BottomNavigationPosition.NOTIFICATIONS.id -> BottomNavigationPosition.NOTIFICATIONS
    BottomNavigationPosition.PROFILE.id -> BottomNavigationPosition.PROFILE
    BottomNavigationPosition.BLOG.id -> BottomNavigationPosition.BLOG
    else -> BottomNavigationPosition.HOME
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.HOME -> ProfileFragment.newInstance()
    BottomNavigationPosition.DASHBOARD -> BmrFragment.newInstance()
    BottomNavigationPosition.NOTIFICATIONS -> DiyetFragment.newInstance()
    BottomNavigationPosition.PROFILE -> TarifFragment.newInstance()
    BottomNavigationPosition.BLOG -> BlogFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.HOME -> ProfileFragment.TAG
    BottomNavigationPosition.DASHBOARD -> BmrFragment.TAG
    BottomNavigationPosition.NOTIFICATIONS -> DiyetFragment.TAG
    BottomNavigationPosition.PROFILE -> TarifFragment.TAG
    BottomNavigationPosition.BLOG -> BlogFragment.TAG
}


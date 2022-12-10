package com.example.assignment_6_cvbuilderapp_week_5_9

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return AboutMeFragment()
            }
            2 -> {
                return WorkFragment()
            }
            3 -> ContactFragment()
            else -> return HomeFragment()
        }
    }
}
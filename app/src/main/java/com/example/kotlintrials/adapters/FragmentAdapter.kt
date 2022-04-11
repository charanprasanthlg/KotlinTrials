package com.example.kotlintrials.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlintrials.fragments.ActionFragment
import com.example.kotlintrials.fragments.WidgetFragment

internal class FragmentAdapter(var context: Context, fm: FragmentManager, var totalTabs : Int):
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                WidgetFragment()
            }
            1 -> {
                ActionFragment()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}
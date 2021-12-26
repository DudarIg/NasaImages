package ru.dudar_ig.nasaimages.ui.globus

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(private val fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    private val fragments = arrayOf(EarchFragment(), MarsFragment(), MoonFragment())

    override fun getItem(position: Int): Fragment {
        val viewFragment = when(position) {
            0 -> fragments[0]
            1 -> fragments[1]
            2 -> fragments[2]
            else -> fragments[0]
        }
        return viewFragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Земля"
            1 -> "Марс"
            2 -> "Луна"
            else -> "Земля"
        }
    }

    override fun getCount(): Int {
        return fragments.size
    }


}
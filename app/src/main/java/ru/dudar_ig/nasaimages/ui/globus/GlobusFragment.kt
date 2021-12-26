package ru.dudar_ig.nasaimages.ui.globus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ru.dudar.nasaimages.ui.globus.ViewPagerAdapter
import ru.dudar_ig.nasaimages.R

class GlobusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_globus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view_pager = view.findViewById<ViewPager>(R.id.view_pager)
        val tab_layout = view.findViewById<TabLayout>(R.id.tab_layout)

        view_pager.adapter = ViewPagerAdapter(childFragmentManager)
        tab_layout.setupWithViewPager(view_pager)

    }

    companion object {
        @JvmStatic
        fun newInstance() = GlobusFragment()
    }
}
package ru.dudar_ig.nasaimages.ui.globus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dudar_ig.nasaimages.ui.globus.ViewPagerAdapter
import ru.dudar_ig.nasaimages.databinding.ActivityGlobusBinding

class GlobusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGlobusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlobusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

    }
}
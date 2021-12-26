package ru.dudar.nasaimage.ui.globus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dudar.nasaimage.databinding.ActivityGlobusBinding

class GlobusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGlobusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlobusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

    }
}
package ru.dudar_ig.nasaimages.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.dudar_ig.nasaimages.ui.SettingsFragment
import ru.dudar_ig.nasaimages.R
import ru.dudar_ig.nasaimages.databinding.ActivityMainBinding
import ru.dudar_ig.nasaimages.ui.globus.GlobusFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val thema = getPreferences(MODE_PRIVATE).getString(SettingsFragment.THEMA, "1")
        if (thema!!.contains("1")) {
            // изменение темы
            setTheme(R.style.Theme_NasaImage)
        } else
        {
            setTheme(R.style.Theme_NasaImage1)
        }
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomMenu()

        val imageFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (imageFragment == null) {
            val fragment = ImageFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }

    private fun initBottomMenu() {
        binding.bottomMenu.setOnItemSelectedListener { item ->
            val fragment : Fragment
            when (item.itemId) {
                R.id.as_settings -> {
                    fragment = SettingsFragment.newInstance()
                }
                else -> {
//                    intent = Intent(this,GlobusActivity::class.java )
//                    startActivity(intent)
                        fragment = GlobusFragment.newInstance()
                }
            }
            supportFragmentManager.popBackStack()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

            true
        }
    }
}
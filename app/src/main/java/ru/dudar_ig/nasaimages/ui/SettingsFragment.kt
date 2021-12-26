package ru.dudar_ig.nasaimages.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import ru.dudar_ig.nasaimages.R
import ru.dudar_ig.nasaimages.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {


    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var thema: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        val themaTek = requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
            .getString(THEMA, "1")
        if (themaTek!!.contains("1"))
            binding.chip1.isChecked = true else binding.chip2.isChecked = true

        binding.chipGroup.setOnCheckedChangeListener { chipGroup, position ->
            chipGroup.findViewById<Chip>(position)?.let {
                thema = it.text as String
            }
            val sharedPref = requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
            sharedPref?.edit().let {
                it?.putString(THEMA, thema)
                it?.commit()
            }
            requireActivity().recreate()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()

        const val THEMA = "thema"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
package ru.dudar_ig.nasaimages.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.api.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.dudar_ig.nasaimages.ui.ImageViewModel
import ru.dudar_ig.nasaimages.R
import ru.dudar_ig.nasaimages.databinding.ImageFragmentBinding

class ImageFragment : Fragment(R.layout.image_fragment) {

    private var _binding: ImageFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ImageViewModel>()
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    companion object {
        fun newInstance() = ImageFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ImageFragmentBinding.bind(view)

        bottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.bottom_sheet_container))
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED


        val textBottomHeader = view.findViewById<TextView>(R.id.bottom_sheet_description_header)
        val textBottom = view.findViewById<TextView>(R.id.bottom_sheet_description)

        binding.textTIL.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://en.wikipedia.org/wiki/${binding.inputText.text.toString()}")
            })
        }

        viewModel.imageVM.observe(this, Observer {
            binding.nasaIV.load(it.url)
            textBottomHeader.text = it.title
            textBottom.text = it.explanation
        })

        binding.yestoday2Chip.setOnClickListener {
            viewModel.image2.observe(this, Observer {
                binding.nasaIV.load(it.url)
                textBottomHeader.text = it.title
                textBottom.text = it.explanation
            })
        }

        binding.yestodayChip.setOnClickListener {
            viewModel.image1.observe(this, Observer {
                binding.nasaIV.load(it.url)
                textBottomHeader.text = it.title
                textBottom.text = it.explanation
            })
        }

        binding.todayChip.setOnClickListener {
            viewModel.imageVM.observe(this, Observer {
                binding.nasaIV.load(it.url)
                textBottomHeader.text = it.title
                textBottom.text = it.explanation
            })
        }
    }



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}
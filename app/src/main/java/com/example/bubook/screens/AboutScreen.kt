package com.example.bubook.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.navigation.fragment.findNavController
import com.example.bubook.R
import com.example.bubook.databinding.ScreenAboutBinding
import com.example.bubook.localStorage.Resources

class AboutScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.screen_about, container, false)
        val binding = ScreenAboutBinding.bind(view)
        binding.imageFilterView3.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.apply {
            constraintLayout.setBackgroundColor(Resources.mainColor)
            textView.setTextColor(Resources.textColor)
            textView3.setTextColor(Resources.textColor)
            rootView.setBackgroundResource(Resources.infoScreenImage)
        }





        return view
    }






}
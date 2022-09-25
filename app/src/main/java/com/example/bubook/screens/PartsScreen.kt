package com.example.bubook.screens

import android.os.Bundle
import android.os.LocaleList
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.example.bubook.R
import com.example.bubook.databinding.ScreenPartsBinding
import com.example.bubook.localStorage.LocalStorage
import com.example.bubook.localStorage.Resources
import com.example.bubook.utills.AdapterRV


class PartsScreen : Fragment() {

    private val adapter = AdapterRV()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.screen_parts, container, false)
        val binding = ScreenPartsBinding.bind(view)
        binding.recycler.adapter = adapter
        adapter.submitList(LocalStorage.partlist)

        binding.apply {
            constraintLayout.setBackgroundColor(Resources.mainColor)
            rootView.setBackgroundResource(Resources.infoScreenImage)
        }


        adapter.initOnclicListener {
            findNavController().navigate(R.id.action_parts_Screen_to_info_Screen , Bundle().apply { this.putSerializable("part" , it) })
        }





      binding.imageFilterView3.setOnClickListener {
          findNavController().navigateUp()
      }




        return view
    }

}
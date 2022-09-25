package com.example.bubook.screens

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import com.dolatkia.animatedThemeManager.AppTheme
import com.dolatkia.animatedThemeManager.ThemeFragment
import com.dolatkia.animatedThemeManager.ThemeManager
import com.example.bubook.R
import com.example.bubook.databinding.ScreenEnterBinding
import com.example.bubook.localStorage.Resources
import com.example.bubook.utills.theme.LightTheme
import com.example.bubook.utills.theme.MyTheme
import com.example.bubook.utills.theme.NightTheme


class EnterScreen :  ThemeFragment() {

    lateinit var binding : ScreenEnterBinding

    @SuppressLint("ResourceType")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.screen_enter, container, false)
        binding = ScreenEnterBinding.bind(view)

        //Toast.makeText(requireContext(), resources.displayMetrics.toString(), Toast.LENGTH_LONG).show()


        //binding.imageFilterView.setBackgroundResource()

        binding.appbutton.setOnClickListener {
            findNavController().navigate(R.id.action_enter_Screen_to_parts_Screen)
        }
        
        binding.about.setOnClickListener{
        findNavController().navigate(R.id.action_enter_Screen_to_about_Screen)
        }

        binding.theme.setOnClickListener {

            if (ThemeManager.instance.getCurrentTheme()!!.id() == 0){
                ThemeManager.instance.changeTheme(NightTheme() , it)
            }
            else if (ThemeManager.instance.getCurrentTheme()!!.id() == 1){
                ThemeManager.instance.reverseChangeTheme(LightTheme() , it)
            }
        }
        return binding.root
    }



    override fun syncTheme(appTheme: AppTheme) {
        val myTheme = appTheme as MyTheme
        val mContext = requireContext()

        binding.apply {
            requireActivity().window.navigationBarColor = myTheme.pageBgColor(mContext)
            requireActivity().window.statusBarColor = myTheme.mainColor(mContext);
            bgImage.setImageResource(myTheme.startScreenBg(mContext))
            textView.setTextColor(myTheme.textColor(mContext))
            textView2.setTextColor(myTheme.textColor(mContext))
            theme.setBackgroundResource(myTheme.btnBackground(mContext))
            appbutton.setBackgroundResource(myTheme.btnBackground(mContext))
            about.setBackgroundResource(myTheme.btnBackground(mContext))
            theme.setImageResource(myTheme.themeBtnIcon(mContext))
        }


        Resources.mainColor = myTheme.mainColor(mContext)
        Resources.dialogBgColor = myTheme.dialogBgColor(mContext)
        Resources.themeBtnIcon = myTheme.themeBtnIcon(mContext)
        Resources.textColor = myTheme.textColor(mContext)
        Resources.infoScreenImage = myTheme.infoScreenImage(mContext)
        Resources.pageBgColor = myTheme.pageBgColor(mContext)
        Resources.startScreenImage = myTheme.startScreenImage(mContext)
        Resources.btnBackground = myTheme.btnBackground(mContext)
        Resources.itemBackground = myTheme.itemBackground(mContext)


    }

}
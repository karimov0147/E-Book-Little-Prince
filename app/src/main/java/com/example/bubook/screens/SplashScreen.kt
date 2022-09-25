package com.example.bubook.screens

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bubook.R
import com.example.bubook.databinding.ScreenSplashBinding
import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {

    private val navController by lazy(LazyThreadSafetyMode.NONE) { findNavController() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var binding = ScreenSplashBinding.bind(view)

        requireActivity().window.navigationBarColor = Color.parseColor("#000000")
        requireActivity().window.statusBarColor = Color.parseColor("#000000")

        binding.logo.animate()
            .alpha(1f)
            .setDuration(800)
            .withEndAction {
                binding.logo.animate()
                    .alpha(0f)
                    .setDuration(800)
                    .withEndAction {  navController.navigate(R.id.action_splashScreen_to_enter_Screen) }
                    .start()
            }.start()




//        CoroutineScope(Dispatchers.IO).launch {
//            delay(1600)
//            withContext(Dispatchers.Main) {
//
//            }
//        }
    }

}
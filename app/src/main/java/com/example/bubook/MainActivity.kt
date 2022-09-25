package com.example.bubook

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.dolatkia.animatedThemeManager.AppTheme
import com.dolatkia.animatedThemeManager.ThemeActivity
import com.example.bubook.databinding.ActivityMainBinding
import com.example.bubook.utills.theme.LightTheme

class MainActivity : ThemeActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun syncTheme(appTheme: AppTheme) {

    }

    override fun getStartTheme(): AppTheme {
        return LightTheme()
    }

}
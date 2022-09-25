package com.example.bubook.utills.theme

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.bubook.R

class NightTheme : MyTheme {

    override fun startScreenBg(context: Context): Int = R.drawable.back_night

    override fun mainColor(context: Context): Int = Color.parseColor("#2196F3")

    override fun startScreenImage(context: Context): Int = R.drawable.back_night

    override fun infoScreenImage(context: Context): Int = R.drawable.back_two_night

    override fun textColor(context: Context): Int = Color.parseColor("#FFFFFF")

    override fun pageBgColor(context: Context): Int = Color.parseColor("#000000")

    override fun dialogBgColor(context: Context): Int = Color.parseColor("#01364E")

    override fun themeBtnIcon(context: Context): Int = R.drawable.ic_baseline_bedtime_24

    override fun btnBackground(context: Context): Int = R.drawable.btn_background_night

    override fun itemBackground(context: Context): Int = R.drawable.item_background_night

    companion object {
        const val themeId = 1
    }

    override fun id(): Int {
        return themeId
    }
}
package com.example.bubook.utills.theme

import android.content.Context
import android.graphics.Color
import com.example.bubook.R

class LightTheme : MyTheme {
    override fun startScreenBg(context: Context):Int = R.drawable.back

    override fun mainColor(context: Context) : Int = Color.parseColor("#8EE02E")

    override fun startScreenImage(context: Context): Int = R.drawable.back

    override fun infoScreenImage(context: Context): Int = R.drawable.back_two

    override fun textColor(context: Context): Int = Color.parseColor("#000000")

    override fun pageBgColor(context: Context): Int = Color.parseColor("#FFFFFF")

    override fun dialogBgColor(context: Context): Int = Color.parseColor("#FBFEE3")

    override fun themeBtnIcon(context: Context): Int = R.drawable.ic_baseline_wb_sunny_24

    override fun btnBackground(context: Context): Int = R.drawable.btn_background

    override fun itemBackground(context: Context): Int = R.drawable.item_background

    companion object {
        const val themeId = 0
    }

    override fun id(): Int {
        return themeId
    }
}
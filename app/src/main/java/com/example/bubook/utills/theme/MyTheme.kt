package com.example.bubook.utills.theme

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import com.dolatkia.animatedThemeManager.AppTheme

interface MyTheme : AppTheme {

    fun startScreenBg(context: Context): Int

    fun mainColor(context: Context) : Int

    fun startScreenImage(context: Context) : Int

    fun infoScreenImage(context: Context) : Int

    fun textColor(context: Context) : Int

    fun pageBgColor(context: Context) : Int

    fun dialogBgColor(context: Context) : Int

    fun themeBtnIcon(context: Context) : Int

    fun btnBackground(context: Context) : Int

    fun itemBackground(context: Context) : Int

}
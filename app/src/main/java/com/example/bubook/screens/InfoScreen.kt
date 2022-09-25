package com.example.bubook.screens

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.dolatkia.animatedThemeManager.AppTheme
import com.dolatkia.animatedThemeManager.ThemeFragment
import com.dolatkia.animatedThemeManager.ThemeManager
import com.example.bubook.R
import com.example.bubook.databinding.CustomDialogBinding
import com.example.bubook.databinding.ScreenInfoBinding
import com.example.bubook.localStorage.Resources
import com.example.bubook.models.Part
import com.example.bubook.utills.theme.LightTheme
import com.example.bubook.utills.theme.MyTheme
import com.example.bubook.utills.theme.NightTheme
import kotlinx.coroutines.flow.combine


class InfoScreen : ThemeFragment() {

    lateinit var binding : ScreenInfoBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.screen_info, container, false)
        val part = arguments?.getSerializable("part") as Part
        binding = ScreenInfoBinding.bind(view)
        val sharedPreferences = requireActivity().getSharedPreferences("text_size" , Context.MODE_PRIVATE)

        binding.apply {
            toolbar.setBackgroundColor(Resources.mainColor)
            background.setBackgroundColor(Resources.pageBgColor)
            text.setTextColor(Resources.textColor)
            titleView.setTextColor(Resources.textColor)
        }


        binding.apply {
            titleView.text = part.title
            text.text = part.str1
            actionBarTitle.text = "${ part.title} Часть"
            text.textSize = (sharedPreferences.getInt("size" , 15)).toFloat()
            Glide.with(requireContext())
                .load(part.img1)
                .into(image)
        }

        binding.toolbar.apply {
            inflateMenu(R.menu.menu)
            setNavigationIcon(R.drawable.ic_baseline_keyboard_arrow_left_24)
            setNavigationOnClickListener{
               findNavController().navigateUp()
            }

        }





        binding.toolbar.setOnMenuItemClickListener(
            object : androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
                @SuppressLint("ResourceAsColor", "ResourceType")
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when(item?.itemId){
                        R.id.size ->{
                            val builder = AlertDialog.Builder(requireContext())
                            val customView = View.inflate(requireContext() , R.layout.custom_dialog , null)
                            val itembind = CustomDialogBinding.bind(customView)

                            val dialog = builder.setView(customView).create()
                            itembind.textView.setTextColor(Resources.textColor)
                            itembind.root.setBackgroundColor(Resources.dialogBgColor)

                            itembind.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                                @SuppressLint("CommitPrefEdits")
                                override fun onProgressChanged(
                                    seekBar: SeekBar?,
                                    progress: Int,
                                    fromUser: Boolean
                                ) {
                                    binding.text.textSize = progress.toFloat()
                                    sharedPreferences.edit().putInt("size" , progress).apply()
                                }

                                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                                }

                                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                                }

                            })
                            itembind.seekBar.progress = sharedPreferences.getInt("size" , 15)
                            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                            dialog.show()
                        }

                        R.id.ligth->{
                            ThemeManager.instance.changeTheme(LightTheme() , binding.root)
                        }
                        R.id.night->{
                            ThemeManager.instance.changeTheme(NightTheme() , binding.root)
                        }
                    }
                    return false
                }
            }
        )

        return view
    }

    override fun syncTheme(appTheme: AppTheme) {

        val myTheme = appTheme as MyTheme
        val mContext = requireContext()


        Resources.mainColor = myTheme.mainColor(mContext)
        Resources.dialogBgColor = myTheme.dialogBgColor(mContext)
        Resources.themeBtnIcon = myTheme.themeBtnIcon(mContext)
        Resources.textColor = myTheme.textColor(mContext)
        Resources.infoScreenImage = myTheme.infoScreenImage(mContext)
        Resources.pageBgColor = myTheme.pageBgColor(mContext)
        Resources.startScreenImage = myTheme.startScreenImage(mContext)
        Resources.btnBackground = myTheme.btnBackground(mContext)
        Resources.itemBackground = myTheme.itemBackground(mContext)

        binding.apply {
            toolbar.setBackgroundColor(Resources.mainColor)
            background.setBackgroundColor(Resources.pageBgColor)
            text.setTextColor(Resources.textColor)
            titleView.setTextColor(Resources.textColor)
            requireActivity().window?.statusBarColor = Resources.mainColor
            requireActivity().window.navigationBarColor = Resources.pageBgColor
        }



    }


}
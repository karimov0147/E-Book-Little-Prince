package com.example.bubook.utills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bubook.R
import com.example.bubook.databinding.ItemBinding
import com.example.bubook.localStorage.Resources
import com.example.bubook.models.Part

class AdapterRV : RecyclerView.Adapter<AdapterRV.ViewHolder>() {

    val list = ArrayList<Part>()
    lateinit var onClickListener : ((Part) -> Unit)

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val binding = ItemBinding.bind(view)
        fun bind(){
            binding.title.text = list[adapterPosition].title
            binding.itemBg.setBackgroundResource(Resources.itemBackground)
            itemView.setOnClickListener { onClickListener?.invoke(list[adapterPosition]) }
        }
    }
    companion object {
        const val themeId = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item , parent , false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = list.size

    fun submitList(newList : ArrayList<Part>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun initOnclicListener(l : ((Part) -> Unit)){
        onClickListener = l
    }

}
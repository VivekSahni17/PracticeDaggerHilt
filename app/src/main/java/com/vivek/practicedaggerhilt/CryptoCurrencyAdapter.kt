package com.vivek.practicedaggerhilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vivek.practicedaggerhilt.databinding.ListItemBinding

class CryptoCurrencyAdapter(private val cryptocurrency: List<Cryptocurrency>):RecyclerView.Adapter<CryptoCurrencyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val mBinding = ListItemBinding.inflate(inflater)
        return ViewHolder(mBinding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(cryptocurrency[position])
    override fun getItemCount(): Int = cryptocurrency.size

    inner class ViewHolder(private val mBinding:ListItemBinding) : RecyclerView.ViewHolder(mBinding.root){
        fun bind(item:Cryptocurrency){
            mBinding.cryptocurrency.text = item.toString()
            mBinding.executePendingBindings()

        }
    }

}

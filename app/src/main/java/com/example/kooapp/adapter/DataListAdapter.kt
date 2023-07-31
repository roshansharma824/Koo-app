package com.example.kooapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.kooapp.R
import com.example.kooapp.databinding.ItemLayoutBinding
import com.example.kooapp.pojo.PostItem
import java.util.*

class DataListAdapter(
    private val data: ArrayList<PostItem>,
) : RecyclerView.Adapter<DataListAdapter.DataViewHolder>() {


    class DataViewHolder(itemView: ViewBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private val binding: ItemLayoutBinding
        fun onBind(data: PostItem) {
            binding.title.text = data.title
            binding.subTitle.text = data.body
        }

        init {
            binding = itemView as ItemLayoutBinding

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataListAdapter.DataViewHolder {
        val binding: ItemLayoutBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_layout, parent, false
        ) as ItemLayoutBinding
        return DataListAdapter.DataViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.onBind(data[position])

    fun addData(list: List<PostItem>) {
        data.addAll(list)
    }


}
package com.example.kotlinhw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val blocks: List<Block>
    ):RecyclerView.Adapter<RecyclerViewAdapter.MainViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.block_view, parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int)
    {
        holder.bind(blocks[position])
    }

    override fun getItemCount(): Int
    {
        return blocks.size
    }

    class MainViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        private val cv : CardView = itemView.findViewById(R.id.block_view__cv)
        private val tv : TextView = itemView.findViewById(R.id.block_view__tv)

        fun bind(block : Block)
        {
            tv.text = block.number.toString()
            cv.setBackgroundColor(block.background)
        }
    }
}
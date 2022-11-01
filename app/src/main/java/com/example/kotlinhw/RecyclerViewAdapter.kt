package com.example.kotlinhw

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val fragments: List<Fragment>,
) : RecyclerView.Adapter<RecyclerViewAdapter.MainViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.container_view, null, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int)
    {
        holder.bind(fragments[position])
    }

    override fun getItemCount(): Int
    {
        return fragments.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(fragment : Fragment)
        {
            /// Здесь должна быть замена фрагмента, но выводит ошибку
            (itemView.context as ContainerActivity).onChangeViewFromFragment(fragment)
        }
    }
}
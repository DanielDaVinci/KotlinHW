package com.example.kotlinhw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinhw.databinding.ActivityMainBinding
import fragments.createSquareFragment

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val containers = mutableListOf<Fragment>()
        val rvAdapter = RecyclerViewAdapter(containers)
        binding.activityMainRv.adapter = rvAdapter
        binding.activityMainRv.layoutManager = GridLayoutManager(this, 3)

        binding.activityMainFab.setOnClickListener{
            containers.add(createSquareFragment(1))
            rvAdapter.notifyDataSetChanged()
        }
    }
}
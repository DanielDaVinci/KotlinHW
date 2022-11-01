package com.example.kotlinhw

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ContainerActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_view)
        Log.d("TEST", "Created")
    }

    fun onChangeViewFromFragment(fragment : Fragment)
    {
        val trasaction = supportFragmentManager.beginTransaction()
        trasaction.add(R.id.container_view__view, fragment)
        trasaction.commit()
    }
}
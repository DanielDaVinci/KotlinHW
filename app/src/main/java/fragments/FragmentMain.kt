package fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhw.Block
import com.example.kotlinhw.RecyclerViewAdapter
import com.example.kotlinhw.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FragmentMain : Fragment()
{
    private var blocks = mutableListOf<Block>()

    private val firstColor = Color.RED
    private val secondColor = Color.BLUE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.fragment_main__rv)
        val rvAdapter = RecyclerViewAdapter(blocks)
        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(view.context, getColumnCount(), RecyclerView.VERTICAL,false)

        if (savedInstanceState != null)
        {
            val amountBlocks = savedInstanceState.getInt("amountBlocks", 0)
            for(number in 1..amountBlocks)
                blocks.add(Block(number, if (blocks.size % 2 == 0) firstColor else secondColor))
        }

        view.findViewById<FloatingActionButton>(R.id.fragment_main__fab).setOnClickListener()
        {
            blocks.add(Block(blocks.size, if (blocks.size % 2 == 0) firstColor else secondColor))
            rvAdapter.notifyItemChanged(blocks.size)
        }
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState)
        outState.putInt("amountBlocks", blocks.size)
    }

    private fun getColumnCount(): Int
    {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> 3
            Configuration.ORIENTATION_LANDSCAPE -> 4
            else -> 0
        }
    }
}
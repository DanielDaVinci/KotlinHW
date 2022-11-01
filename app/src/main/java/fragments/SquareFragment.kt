package fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinhw.R

fun createSquareFragment(number : Int): SquareFragment
{
    return SquareFragment().apply {
        arguments = Bundle().apply { putInt("number", number) }
    }
}

class SquareFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.square_view, null, false)
        return view
    }
}
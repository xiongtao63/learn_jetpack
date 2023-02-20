package com.xiongtao.jetpack.livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xiongtao.jetpack.R


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_first, container, false)
        val seekBar = root.findViewById<SeekBar>(R.id.seekbar)
        val viewModel = activity?.let {
            ViewModelProvider(
                it,
                ViewModelProvider.AndroidViewModelFactory(it.application)
            ).get(MyViewModel2::class.java)
        }
        activity?.let {
            viewModel?.progress?.observe(it, { t ->
                if (t != null) {
                    seekBar.progress = t
                }
            })
        }
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel?.progress?.value=progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        return root
    }

}
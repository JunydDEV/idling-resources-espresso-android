package com.uiautomation_android.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.uiautomation_android.MainActivity

import com.uiautomation_android.R
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity

        view.findViewById<Button>(R.id.buttonGoToListing).setOnClickListener {
            activity.mIdlingResource?.setIdleState(false)

            //fake API call
            Timer().schedule(object: TimerTask(){
                override fun run() {
                    activity.mIdlingResource?.setIdleState(true)
                    findNavController().navigate(R.id.action_homeFragment_to_listFragment)
                }
            },5000)
        }
    }
}


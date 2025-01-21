package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the display of the menu from the MainActivity
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class MenuFragment : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuFragment
        {
            val fragment = MenuFragment()
            val bundle = Bundle()
            bundle.putSerializable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            state = it.getSerializable("state") as State
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }
}
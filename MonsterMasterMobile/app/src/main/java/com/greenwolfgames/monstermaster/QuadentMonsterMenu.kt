package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the display of the menu_monsters_quadent layout file
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class QuadentMonsterMenu : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): QuadentMonsterMenu
        {
            val fragment = QuadentMonsterMenu()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("QuadentMonsterMenu.onCreate","Quadent Monster Menu onCreate() triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_monsters_quadent, container, false)
    }
}
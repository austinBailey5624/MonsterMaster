package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


/**
 * Fragment to handle the display of the menu_monsters_trident layout file
 * @Author Austin Bailey
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class TridentMonsterMenu : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): TridentMonsterMenu
        {
            val fragment = TridentMonsterMenu()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("TridentMonsterMenu.onCreate","Trident Monster Menu onCreate() triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_monsters_trident, container, false)
    }
}
package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the menu_deity layout file
 * @Author Austin Bailey
 * @Year 2925
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class MenuDeity : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuDeity
        {
            Log.d("MenuDeity.newInstance","MenuDeity.newInstance triggered")
            val fragment = MenuDeity()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("MenuDeity.onCreate","Menu Deity Oncreate triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_deity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        view.findViewById<Button>(R.id.menu_deity_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
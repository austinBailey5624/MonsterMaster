package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the display of the menu_monsters side menu
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright Austin Bailey All Rights Reserved
 */
class MenuMonsters : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuMonsters
        {
            val fragment = MenuMonsters()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("MenuMonsters.onCreate","MenuMonsters onCreate() triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_monsters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_monsters_back),
            view.findViewById(R.id.menu_monsters_info)
        )

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),state.getMainCharacterElement())
        }

        view.findViewById<Button>(R.id.menu_monsters_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
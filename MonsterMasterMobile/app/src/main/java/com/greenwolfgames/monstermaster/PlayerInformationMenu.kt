package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

/**
 * fragment ot handle the display of the player information menu from the main activity
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class PlayerInformationMenu : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): PlayerInformationMenu {
            val fragment = PlayerInformationMenu()
            val bundle = Bundle()
            bundle.putSerializable("state", state)
            fragment.arguments = bundle
            return PlayerInformationMenu()
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
        return inflater.inflate(R.layout.menu_player_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

    }
}
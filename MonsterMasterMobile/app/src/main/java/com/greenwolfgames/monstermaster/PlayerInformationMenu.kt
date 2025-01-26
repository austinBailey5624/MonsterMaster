package com.greenwolfgames.monstermaster

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
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
        fun newInstance(state: State): PlayerInformationMenu
        {
            val fragment = PlayerInformationMenu()
            val bundle = Bundle()
            bundle.putSerializable("state", state)
            fragment.arguments = bundle
            return fragment
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

        arguments?.let{
            state = it.getSerializable("state") as State
        }

        // Ensure state is initialized properly, otherwise throw an exception
        if (!::state.isInitialized) {
            throw IllegalStateException("State cannot be null in PlayerInformationMenu.onViewCreated()")
        }

        val backgroundsToColor: List<ImageView> = listOf(
            view.findViewById(R.id.menu_player_information_background),
            view.findViewById(R.id.menu_player_information_name_background),
            view.findViewById(R.id.menu_player_information_portrait_background),
            view.findViewById(R.id.menu_player_information_status_background))

        var buttonsToColor: List<Button> = listOf(
            view.findViewById(R.id.menu_player_information_skills_button),
            view.findViewById(R.id.menu_player_information_elemental_affinity_button),
            view.findViewById(R.id.menu_player_information_back_button),
            view.findViewById(R.id.menu_player_information_deity_affinity_button)
        )

        val mainCharacterElement = state.getMainCharacterElement()

        for(background in backgroundsToColor)
        {
            background.setColorFilter(ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(mainCharacterElement)), PorterDuff.Mode.MULTIPLY)
        }

        for(button in buttonsToColor)
        {
            Element.colorButton(button,requireContext(),mainCharacterElement)
        }
    }
}
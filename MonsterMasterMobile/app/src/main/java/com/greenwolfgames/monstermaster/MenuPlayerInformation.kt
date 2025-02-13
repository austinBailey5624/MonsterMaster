package com.greenwolfgames.monstermaster

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * fragment ot handle the display of the player information menu from the main activity
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class MenuPlayerInformation : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuPlayerInformation
        {
            Log.d("PlayerInformationMenu.newInstance","PlayerInformationMenu newInstance() called")
            val fragment = MenuPlayerInformation()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("PlayerInformationMenu.onCreate", "OnCreate method of PlayerInformationMenu called")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        Log.d("PlayerInformationMenu.onCreateView","PlayerInformationMenu onCreateView() called")
        return inflater.inflate(R.layout.menu_player_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        // Ensure state is initialized properly, otherwise throw an exception
        if (!::state.isInitialized) {
            throw IllegalStateException("State cannot be null in PlayerInformationMenu.onViewCreated()")
        }

        val backgroundsToColor: List<ImageView> = listOf(
            view.findViewById(R.id.menu_player_information_background),
            view.findViewById(R.id.menu_player_information_name_background),
            view.findViewById(R.id.menu_player_information_portrait_background),
            view.findViewById(R.id.menu_player_information_status_background))

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_player_information_skills_button),
            view.findViewById(R.id.menu_player_information_elemental_affinity_button),
            view.findViewById(R.id.menu_player_information_back_button),
            view.findViewById(R.id.menu_player_information_deity_affinity_button)
        )

        val texts: List<TextView> = listOf(
            view.findViewById(R.id.menu_player_information_name),
            view.findViewById(R.id.menu_player_information_level_text),
            view.findViewById(R.id.menu_player_information_exp_to_next_level_text),
            view.findViewById(R.id.menu_player_information_weapon_text),
            view.findViewById(R.id.menu_player_information_physical_text),
            view.findViewById(R.id.menu_player_information_armor_text),
            view.findViewById(R.id.menu_player_information_magic_text),
            view.findViewById(R.id.menu_player_information_accessory_text),
            view.findViewById(R.id.menu_player_information_item_uses_text)
        )

        val playerNameText: TextView = texts[0]

        val playerPortrait: ImageView = view.findViewById(R.id.menu_player_information_portriat)

        val mainCharacterElement = state.getMainCharacterElement()

        for(background in backgroundsToColor)
        {
            background.setColorFilter(ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(mainCharacterElement)), PorterDuff.Mode.MULTIPLY)
        }

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),mainCharacterElement)
        }

        buttons[2].setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }

        for(text in texts)
        {
            text.setTextColor(Element.getTextColor(mainCharacterElement))
        }

        playerNameText.setText(state.playerName)
        playerPortrait.setImageResource(state.playerPortraitImageId)

        view.findViewById<Button>(R.id.menu_player_information_deity_affinity_button).setOnClickListener{
            openDeityAlignmentMenu()
        }

        view.findViewById<Button>(R.id.menu_player_information_elemental_affinity_button).setOnClickListener{
            openElementAlignmentMenu()
        }

        val playerBattleActor: BattleActor = state.getPlayerBattleActor()
        val statusBar: StatusBar = StatusBar.getStatusBar(playerBattleActor)

        val statusBarHealth: ImageView = view.findViewById(R.id.menu_player_information_status_bar_health)
        statusBarHealth.setImageResource(statusBar.health)

        val statusBarMana: ImageView = view.findViewById(R.id.menu_player_information_status_bar_mana)
        statusBarMana.setImageResource(statusBar.mana)

        val statusBarElement: ImageView = view.findViewById(R.id.menu_player_information_status_bar_element)
        statusBarElement.setImageResource(statusBar.elementSymbol)

        val statusBarHealthText: TextView = view.findViewById(R.id.menu_player_information_status_bar_health_text)

        statusBarHealthText.text = requireContext().getString(
            R.string.health_status,
            playerBattleActor.hpCurrent.toInt(),
            playerBattleActor.hpMax.toInt()
        )

        val statusBarManaText: TextView = view.findViewById(R.id.menu_player_information_status_bar_mana_text)

        statusBarManaText.text = requireContext().getString(
            R.string.health_status,
            playerBattleActor.mpCurrent.toInt(),
            playerBattleActor.mpMax.toInt()
        )
    }

    private fun openDeityAlignmentMenu() {
        val fragment = MenuDeities.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun openElementAlignmentMenu() {
        val fragment = MenuPlayerElements.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}
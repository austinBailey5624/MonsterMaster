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

    private var descriptionState: Int = 0

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

        val element = state.getMainCharacterElement()

        view.findViewById<ImageView>(R.id.menu_player_information_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_player_information_background_fade).setColorFilter(
            ContextCompat.getColor(requireContext(),Element.getTextColor(element)), PorterDuff.Mode.MULTIPLY)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_player_information_name),
            view.findViewById(R.id.menu_player_information_description),
            view.findViewById(R.id.menu_player_information_skills_button),
            view.findViewById(R.id.menu_player_information_elemental_affinity_button),
            view.findViewById(R.id.menu_player_information_back_button),
            view.findViewById(R.id.menu_player_information_deity_affinity_button)
        )

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),element)
        }

        val playerPortrait: ImageView = view.findViewById(R.id.menu_player_information_portriat)
        view.findViewById<Button>(R.id.menu_player_information_name).setText(state.playerName)
        playerPortrait.setImageResource(state.playerPortraitImageId)

        val playerBattleActor: BattleActor = state.getPlayerBattleActor()
        val statusBar: StatusBar = StatusBar.getStatusBar(playerBattleActor)

        val statusBarHealth: ImageView = view.findViewById(R.id.menu_player_information_status_bar_health)
        statusBarHealth.setImageResource(statusBar.health)

        val statusBarMana: ImageView = view.findViewById(R.id.menu_player_information_status_bar_mana)
        statusBarMana.setImageResource(statusBar.mana)

        val statusBarElement: ImageView = view.findViewById(R.id.menu_player_information_status_bar_element)
        statusBarElement.setImageResource(statusBar.elementSymbol)

        val statusBarHealthText: TextView = view.findViewById(R.id.menu_player_information_status_bar_health_text)

        val description: String = ContextCompat.getString(requireContext(),R.string.player_info_menu_level) + " "
                playerBattleActor.level.toString() + "\n\n" + ContextCompat.getString(requireContext(), R.string.player_info_menu_exp_to_next) +
                        " " + BattleActor.getExpRequiredForLevelUp(playerBattleActor.level,playerBattleActor.experience).toString() + " " +
                        ContextCompat.getString(requireContext(), R.string.player_info_tap_for_more_info)

        val description2: String = ContextCompat.getString(requireContext(),R.string.player_info_menu_weapon) + "\n" +
                ContextCompat.getString(requireContext(),R.string.player_info_menu_armor) + "\n" +
                ContextCompat.getString(requireContext(),R.string.player_info_menu_accessory) + "\n" +
                ContextCompat.getString(requireContext(), R.string.player_info_tap_for_more_info)

        val description3: String = ContextCompat.getString(requireContext(),R.string.player_info_menu_physical) + " " +
                playerBattleActor.physicalUses + "\n" +
                ContextCompat.getString(requireContext(),R.string.player_info_menu_magical) + " " +
                playerBattleActor.magicalUses + "\n" +
                ContextCompat.getString(requireContext(),R.string.player_info_menu_item_uses) + " " +
                playerBattleActor.itemUses  + "\n\n" +
                ContextCompat.getString(requireContext(), R.string.player_info_tap_for_more_info)

        view.findViewById<Button>(R.id.menu_player_information_description).setText(description)

        view.findViewById<Button>(R.id.menu_player_information_elemental_affinity_button).setOnClickListener{
            openElementAlignmentMenu()
        }

        view.findViewById<Button>(R.id.menu_player_information_back_button).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }

        view.findViewById<Button>(R.id.menu_player_information_deity_affinity_button).setOnClickListener{
            openDeityAlignmentMenu()
        }

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

        view.findViewById<Button>(R.id.menu_player_information_description).setOnClickListener{
            if(view.findViewById<Button>(R.id.menu_player_information_description).text.equals(description))
            {
                view.findViewById<Button>(R.id.menu_player_information_description).text = description2
            }
            else if(view.findViewById<Button>(R.id.menu_player_information_description).text.equals(description2))
            {
                view.findViewById<Button>(R.id.menu_player_information_description).text = description3
            }
            else
            {
                view.findViewById<Button>(R.id.menu_player_information_description).text = description
            }
        }
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
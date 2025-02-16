package com.greenwolfgames.monstermaster

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * side to handle the display of the menu from the MainActivity
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class MenuSide : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuSide
        {
            Log.d("MenuSide", "Creating new instance of MenuSide")
            val fragment = MenuSide()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MenuSide.onCreate", "OnCreate method of MenuSide called")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MenuSide.onCreateView","Menu Side onCreateView called")
        return inflater.inflate(R.layout.menu_side, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.side_menu_button_party),
            view.findViewById(R.id.side_menu_button_inventory),
            view.findViewById(R.id.side_menu_button_journal),
            view.findViewById(R.id.side_menu_button_encyclopedia),
            view.findViewById(R.id.side_menu_button_save),
            view.findViewById(R.id.side_menu_button_settings),
            view.findViewById(R.id.side_menu_button_credits),
            view.findViewById(R.id.side_menu_button_back)
        )
        for(button in buttons)
        {
            Element.colorButton(button, requireContext(), state.getMainCharacterElement())
        }

        val background: ImageView = view.findViewById(R.id.side_menu_background)
        background.setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getBackgroundColor(state.getMainCharacterElement())), PorterDuff.Mode.MULTIPLY)
        
        view.findViewById<ImageView>(R.id.side_menu_background_fade)

        view.findViewById<Button>(R.id.side_menu_button_party).setOnClickListener{
            openPlayerInformationMenu()
        }

        view.findViewById<Button>(R.id.side_menu_button_journal).setOnClickListener{
            openJournalMenu()
        }

        view.findViewById<Button>(R.id.side_menu_button_encyclopedia).setOnClickListener{
            openMonsterMenu()
        }

        view.findViewById<Button>(R.id.side_menu_button_inventory).setOnClickListener{
            openInventoryMenu()
        }
        
        view.findViewById<Button>(R.id.side_menu_button_credits).setOnClickListener{
            openCreditsMenu()
        }

        view.findViewById<Button>(R.id.side_menu_button_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun openPlayerInformationMenu()
    {
        val side = MenuPlayerInformation.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, side)
            .addToBackStack(null)
            .commit()
    }

    private fun openMonsterMenu() {
        val side = MenuMonstersElements.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, side)
            .addToBackStack(null)
            .commit()
    }
    
    private fun openCreditsMenu() {
        val side = MenuCredits.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, side)
            .addToBackStack(null)
            .commit()
    }

    private fun openInventoryMenu() {
        val side = MenuInventory.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, side)
            .addToBackStack(null)
            .commit()
    }

    private fun openJournalMenu() {
        val side = MenuJournal.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, side)
            .addToBackStack(null)
            .commit()
    }
}
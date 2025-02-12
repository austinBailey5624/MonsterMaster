package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the display of the menu_monsters side menu
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright Austin Bailey All Rights Reserved
 */
class MenuMonstersElements : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuMonstersElements
        {
            val fragment = MenuMonstersElements()
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
        return inflater.inflate(R.layout.menu_monsters_elements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val buttons: List<Button> = listOf(view.findViewById(R.id.menu_monsters_back),
            view.findViewById(R.id.menu_monsters_info))

        for (button in buttons)
        {
            Element.colorButton(button, requireContext(), state.getMainCharacterElement())
        }

        view.findViewById<Button>(R.id.menu_monsters_back).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_pyro).setOnClickListener {
            openMonstersMenu(Element.PYRO)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_steam).setOnClickListener {
            openMonstersMenu(Element.STEAM)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_fey).setOnClickListener {
            openMonstersMenu(Element.FEY)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_phoenix).setOnClickListener {
            openMonstersMenu(Element.PHOENIX)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_solar).setOnClickListener {
            openMonstersMenu(Element.SOLAR)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_demon).setOnClickListener {
            openMonstersMenu(Element.DEMON)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_lava).setOnClickListener {
            openMonstersMenu(Element.LAVA)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_aqua).setOnClickListener {
            openMonstersMenu(Element.AQUA)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_plant).setOnClickListener {
            openMonstersMenu(Element.PLANT)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_seabreeze).setOnClickListener {
            openMonstersMenu(Element.SEABREEZE)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_lunar).setOnClickListener {
            openMonstersMenu(Element.LUNAR)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_poison).setOnClickListener {
            openMonstersMenu(Element.POISON)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_dino).setOnClickListener {
            openMonstersMenu(Element.DINO)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_amphibious).setOnClickListener {
            openMonstersMenu(Element.AMPHIBIOUS)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_terra).setOnClickListener {
            openMonstersMenu(Element.TERRA)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_bird).setOnClickListener {
            openMonstersMenu(Element.BIRD)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_guardian).setOnClickListener {
            openMonstersMenu(Element.GUARDIAN)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_undead).setOnClickListener {
            openMonstersMenu(Element.UNDEAD)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_sand).setOnClickListener {
            openMonstersMenu(Element.SAND)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_weather).setOnClickListener {
            openMonstersMenu(Element.WEATHER)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_pegasus).setOnClickListener {
            openMonstersMenu(Element.PEGASUS)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_aero).setOnClickListener {
            openMonstersMenu(Element.AERO)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_angel).setOnClickListener {
            openMonstersMenu(Element.ANGEL)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_storm).setOnClickListener {
            openMonstersMenu(Element.STORM)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_justice).setOnClickListener {
            openMonstersMenu(Element.JUSTICE)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_ice).setOnClickListener {
            openMonstersMenu(Element.ICE)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_compassion).setOnClickListener {
            openMonstersMenu(Element.COMPASSION)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_cocka).setOnClickListener {
            openMonstersMenu(Element.COCKA)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_luxor).setOnClickListener {
            openMonstersMenu(Element.LUXOR)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_betrayer).setOnClickListener {
            openMonstersMenu(Element.BETRAYER)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_vengeance).setOnClickListener {
            openMonstersMenu(Element.VENGEANCE)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_deep).setOnClickListener {
            openMonstersMenu(Element.DEEP)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_rotten).setOnClickListener {
            openMonstersMenu(Element.ROTTEN)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_nightwing).setOnClickListener {
            openMonstersMenu(Element.NIGHTWING)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_redemption).setOnClickListener {
            openMonstersMenu(Element.REDEMPTION)
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_umbral).setOnClickListener {
            openMonstersMenu(Element.UMBRAL)
        }
    }


    private fun openMonstersMenu(element: Element)
    {
        if(Element.getMonsterHierarchyType(element) == EMonsterHierarchyType.BIDENT)
        {
            state.uiElement = element;
            val fragment = MenuMonstersBident.newInstance(state)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menu_frame_layout, fragment)
                .addToBackStack(null)
                .commit()
            return
        }
        else if(Element.getMonsterHierarchyType(element) == EMonsterHierarchyType.TRIDENT)
        {
            state.uiElement = element;
            val fragment = MenuMonstersTrident.newInstance(state)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menu_frame_layout, fragment)
                .addToBackStack(null)
                .commit()
            return
        }
        else if(Element.getMonsterHierarchyType(element) == EMonsterHierarchyType.QUADENT)
        {
            state.uiElement = element
            val fragment = MenuMonstersQuadent.newInstance(state)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menu_frame_layout, fragment)
                .addToBackStack(null)
                .commit()
            return
        }
        else if(Element.getMonsterHierarchyType(element) == EMonsterHierarchyType.QUINDENT)
        {
            state.uiElement = element
            val fragment = MenuMonstersQuindent.newInstance(state)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_menu_frame_layout, fragment)
                .addToBackStack(null)
                .commit()
            return
        }
        throw IllegalStateException("Unreachable code reached by mistake in MenuMonsters")
    }
}
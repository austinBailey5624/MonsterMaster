package com.greenwolfgames.monstermaster

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the display of the menu_monsters_bident layout file
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class BidentMonsterMenu : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): BidentMonsterMenu
        {
            val fragment = BidentMonsterMenu()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("BidentMonsterMenu.onCreate","Bident Monster Menu onCreate() triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_monsters_bident, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val element: Element = state.getUIElement()

        view.findViewById<ImageView>(R.id.menu_monsters_bident_background).setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_monsters_bident_element_symbol).setImageResource(Element.getSymbol(element))
        view.findViewById<ImageView>(R.id.menu_monsters_bident_element_symbol).apply {
            alpha = 0.5f // 50% transparency (value between 0.0 and 1.0)
        }

        view.findViewById<ImageView>(R.id.menu_monsters_bident_background_overlap).setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getTextColor(element)), PorterDuff.Mode.MULTIPLY)


        val texts: List<TextView> = listOf(
            view.findViewById(R.id.menu_monsters_bident_infant_text),
            view.findViewById(R.id.menu_monsters_bident_adolescent_text),
            view.findViewById(R.id.menu_monsters_bident_adult_text),
            view.findViewById(R.id.menu_monsters_bident_elder_text)
        )

        for( text in texts)
        {
            text.setTextColor(ContextCompat.getColor(requireContext(),Element.getTextColor(element)))
        }

        val imageViews: List<ImageView> = listOf(
            view.findViewById(R.id.menu_monsters_bident_infant_background),
            view.findViewById(R.id.menu_monsters_bident_adolescent_background),
            view.findViewById(R.id.menu_monsters_bident_adult_background),
            view.findViewById(R.id.menu_monsters_bident_elder_background)
        )

        for(imageView in imageViews)
        {
            imageView.setColorFilter(ContextCompat.getColor(requireContext(),
                Element.getButtonBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)
        }

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_monsters_bident_element_title),
            view.findViewById(R.id.menu_monsters_bident_back),
            view.findViewById(R.id.menu_monsters_bident_info)
        )

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),element)
        }

        view.findViewById<Button>(R.id.menu_monsters_bident_element_title).setText(Element.getName(requireContext(),element))

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_infant).setImageResource(Element.getInfantMonster(requireContext(),element).imageResourceId)
        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adolescent_physical).setImageResource(Element.getPhysicalAdolescentMonster(requireContext(),element).imageResourceId)
        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adolescent_magical).setImageResource(Element.getMagicalAdolescentMonster(requireContext(),element).imageResourceId)
        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adult_physical).setImageResource(Element.getPhysicalAdultMonster(requireContext(),element).imageResourceId)
        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adult_magical).setImageResource(Element.getMagicalAdultMonster(requireContext(),element).imageResourceId)
        view.findViewById<ImageButton>(R.id.menu_monsters_bident_elder_physical).setImageResource(Element.getPhysicalElderMonster(requireContext(),element).imageResourceId)
        view.findViewById<ImageButton>(R.id.menu_monsters_bident_elder_magical).setImageResource(Element.getMagicalElderMonster(requireContext(),element).imageResourceId)

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_infant).setOnClickListener{
            openMonsterTypeMenu(Element.getInfantMonster(requireContext(),element))
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adolescent_physical).setOnClickListener{
            openMonsterTypeMenu(Element.getPhysicalAdolescentMonster(requireContext(),element))
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adolescent_magical).setOnClickListener{
            openMonsterTypeMenu(Element.getMagicalAdolescentMonster(requireContext(),element))
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adult_physical).setOnClickListener{
            openMonsterTypeMenu(Element.getPhysicalAdultMonster(requireContext(),element))
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_adult_magical).setOnClickListener{
            openMonsterTypeMenu(Element.getMagicalAdultMonster(requireContext(),element))
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_elder_physical).setOnClickListener{
            openMonsterTypeMenu(Element.getPhysicalElderMonster(requireContext(),element))
        }

        view.findViewById<ImageButton>(R.id.menu_monsters_bident_elder_magical).setOnClickListener{
            openMonsterTypeMenu(Element.getMagicalElderMonster(requireContext(),element))
        }

        view.findViewById<Button>(R.id.menu_monsters_bident_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun openMonsterTypeMenu(monsterType: MonsterType)
    {
        state.uiMonsterType = monsterType
        val fragment = MonsterTypeMenu.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}
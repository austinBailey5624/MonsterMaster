package com.greenwolfgames.monstermaster

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the display of menu_monster_type layout file
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class MenuMonsterType : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuMonsterType
        {
            val fragment = MenuMonsterType()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("MonsterTypeMenu.onCreate","MonsterTypeMenu.oncreate() triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.menu_monster_type, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val monster: MonsterType = state.getUIMonsterType()

        val element: Element = monster.element

        view.findViewById<ImageView>(R.id.menu_monster_type_background).setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)
        view.findViewById<ImageView>(R.id.menu_monster_type_background_faded).setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getTextColor(element)),PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_monster_type_element_symbol).setImageResource(Element.getSymbol(element))
        view.findViewById<ImageView>(R.id.menu_monster_type_image).setImageResource(state.getUIMonsterType().imageResourceId)

        view.findViewById<ImageView>(R.id.menu_monster_type_info_background).setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)
        val description: String = ContextCompat.getString(requireContext(),R.string.menu_monster_type_description) + " " + monster.description

        //TODO: Location, traits, items dropped
        view.findViewById<TextView>(R.id.menu_monster_type_description).text = description


        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_monster_type_title),
            view.findViewById(R.id.menu_monster_type_seen),
            view.findViewById(R.id.menu_monster_type_slain),
            view.findViewById(R.id.menu_monster_type_owned),
            view.findViewById(R.id.menu_monster_evolved_from),
            view.findViewById(R.id.menu_monster_type_physical_evolution),
            view.findViewById(R.id.menu_monster_type_balanced_evolution),
            view.findViewById(R.id.menu_monster_type_magical_evolution),
            view.findViewById(R.id.menu_monster_type_back)
        )

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),element)
        }

        setButtonAutoResizing(buttons)

        setTextAutoResizing(
            listOf(
                view.findViewById(R.id.menu_monster_type_description),
                view.findViewById(R.id.menu_monster_type_location),
                view.findViewById(R.id.menu_monster_type_traits),
                view.findViewById(R.id.menu_monster_type_items_dropped)
            )
        )



        view.findViewById<Button>(R.id.menu_monster_type_title).setText(monster.name)

        var text: String
        if (monster.previousEvolutionIndex > 0)
        {
            text = ContextCompat.getString(requireContext(),
                R.string.menu_monster_type_evolved_from) + " " + MonsterTypeManager.getMonsterType(
                requireContext(),
                monster.previousEvolutionIndex).name
            view.findViewById<Button>(R.id.menu_monster_evolved_from).setText(text)
            view.findViewById<Button>(R.id.menu_monster_evolved_from).setOnClickListener{
                refreshWithNewMonster(MonsterTypeManager.getMonsterType(requireContext(),monster.previousEvolutionIndex))
            }
        }
        else
        {
            view.findViewById<Button>(R.id.menu_monster_evolved_from).setText("")//TODO Clean up
        }
        if (monster.physicalEvolutionIndex > 0)
        {
            text = ContextCompat.getString(requireContext(),
                R.string.menu_monster_type_physical_evolution) + " " + MonsterTypeManager.getMonsterType(
                requireContext(),
                monster.physicalEvolutionIndex).name
            view.findViewById<Button>(R.id.menu_monster_type_physical_evolution).setText(text)
            view.findViewById<Button>(R.id.menu_monster_type_physical_evolution).setOnClickListener{
                refreshWithNewMonster(MonsterTypeManager.getMonsterType(requireContext(),monster.physicalEvolutionIndex))
            }
        }
        else
        {
            view.findViewById<Button>(R.id.menu_monster_type_physical_evolution).setText("")//TODO Clean up
        }
        if (monster.balancedEvolutionIndex > 0)
        {
            text = ContextCompat.getString(requireContext(),
                R.string.menu_monster_type_balanced_evolution) + " " + MonsterTypeManager.getMonsterType(
                requireContext(),
                monster.balancedEvolutionIndex).name
            view.findViewById<Button>(R.id.menu_monster_type_balanced_evolution).setText(text)
            view.findViewById<Button>(R.id.menu_monster_type_balanced_evolution).setOnClickListener{
                refreshWithNewMonster(MonsterTypeManager.getMonsterType(requireContext(),monster.balancedEvolutionIndex))
            }
        }
        else
        {
            view.findViewById<Button>(R.id.menu_monster_type_balanced_evolution).setText("")//TODO Clean up
        }
        if (monster.magicalEvolutionIndex > 0)
        {
            text = ContextCompat.getString(requireContext(),
                R.string.menu_monster_type_magical_evolution) + " " + MonsterTypeManager.getMonsterType(
                requireContext(),
                monster.magicalEvolutionIndex).name
            view.findViewById<Button>(R.id.menu_monster_type_magical_evolution).setText(text)
            view.findViewById<Button>(R.id.menu_monster_type_magical_evolution).setOnClickListener{
                refreshWithNewMonster(MonsterTypeManager.getMonsterType(requireContext(),monster.magicalEvolutionIndex))
            }
        }
        else
        {
            view.findViewById<Button>(R.id.menu_monster_type_magical_evolution).setText("")//TODO Clean up
        }

        view.findViewById<Button>(R.id.menu_monster_type_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    fun refreshWithNewMonster(monsterType: MonsterType)
    {
        state.uiMonsterType = monsterType
        val fragment = newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, fragment)//TODO be aware removed .addToBackStack(null) to seeif that would work
            .commit()
    }

    private fun setTextAutoResizing(texts: List<TextView>)
    {
        for(text in texts)
        {
            text.setAutoSizeTextTypeUniformWithConfiguration(
                10,  // Minimum text size in sp
                33, // Maximum text size in sp
                2,   // Step granularity in sp
                TypedValue.COMPLEX_UNIT_SP
            )
        }
    }

    private fun setButtonAutoResizing(buttons: List<Button>)
    {
        for(button in buttons)
        {
            button.setAutoSizeTextTypeUniformWithConfiguration(
                12,
                60,
                2,
                TypedValue.COMPLEX_UNIT_SP
            )
        }
    }
}

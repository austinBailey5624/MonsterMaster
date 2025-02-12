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
        super.onViewCreated(view, savedInstanceState)
        val deity: Deity = state.uiDeity
        val element: Element = Deity.getElement(deity)

        view.findViewById<ImageView>(R.id.menu_deity_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_deity_background_fade).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getTextColor(element)), PorterDuff.Mode.MULTIPLY)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_deity_title),
            view.findViewById(R.id.menu_deity_entropic_nature),
            view.findViewById(R.id.menu_deity_element),
            view.findViewById(R.id.menu_deity_status),
            view.findViewById(R.id.menu_deity_back)
        )

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),element)
        }

        view.findViewById<Button>(R.id.menu_deity_title).text = Deity.getName(requireContext(),deity)

        val entropicNature: EntropicNature = Deity.getEntropicNature(deity)
        view.findViewById<ImageView>(R.id.menu_deity_entropic_nature_symbol).setImageResource(EntropicNature.getSymbol(entropicNature))
        view.findViewById<ImageView>(R.id.menu_deity_element_symbol).setImageResource(Element.getSymbol(element))
        view.findViewById<Button>(R.id.menu_deity_entropic_nature).setText(EntropicNature.getName(requireContext(),entropicNature))
        view.findViewById<Button>(R.id.menu_deity_element).setText(Element.getName(requireContext(), element))
        view.findViewById<ImageView>(R.id.menu_deity_symbol).setImageResource(Deity.getSymbol(deity))
        view.findViewById<Button>(R.id.menu_deity_status).setText(Deity.getDeityRelationshipStatus(deity,requireContext(),state))
        view.findViewById<ImageView>(R.id.menu_deity_description_background).setColorFilter(ContextCompat.getColor(requireContext(),Element.getBackgroundColor(element)),PorterDuff.Mode.MULTIPLY)
        view.findViewById<TextView>(R.id.menu_deity_description).setText(Deity.getDescription(requireContext(),deity))
        view.findViewById<TextView>(R.id.menu_deity_description).setTextColor(Element.getTextColor(element))

        view.findViewById<Button>(R.id.menu_deity_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
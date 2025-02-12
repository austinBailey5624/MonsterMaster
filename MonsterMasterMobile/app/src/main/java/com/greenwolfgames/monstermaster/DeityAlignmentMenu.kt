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
 * Fragment to handle the menu_deity_alignment layout file
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class DeityAlignmentMenu : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): DeityAlignmentMenu
        {
            val fragment = DeityAlignmentMenu()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("DeityAlignmentMenu.onCreate","Deity Alignment Menu onCreate() triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_diety_alignment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageView>(R.id.menu_deity_alignment_lawful_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
            Element.getButtonBackgroundColor(Element.LUXOR)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_deity_alignment_neutral_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getButtonBackgroundColor(Element.INITIAL)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_deity_alignment_chaotic_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getButtonBackgroundColor(Element.UMBRAL)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_deity_alignment_lawful_text).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getTextColor(Element.LUXOR)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_deity_alignment_neutral_text).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getTextColor(Element.INITIAL)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_deity_alignment_chaotic_text).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getTextColor(Element.UMBRAL)), PorterDuff.Mode.MULTIPLY)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_deity_back_button),
            view.findViewById(R.id.menu_deity_info)
        )

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),Element.PHYSICAL)
        }

        view.findViewById<Button>(R.id.menu_deity_back_button).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
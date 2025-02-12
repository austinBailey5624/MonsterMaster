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
            bundle.putParcelable("state", state)
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
                Element.getButtonBackgroundColor(Element.PHYSICAL)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_deity_alignment_chaotic_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getButtonBackgroundColor(Element.UMBRAL)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<TextView>(R.id.menu_deity_alignment_lawful_text)
            .setTextColor(ContextCompat.getColor(requireContext(),
                Element.getTextColor(Element.LUXOR)))

        view.findViewById<TextView>(R.id.menu_deity_alignment_neutral_text)
            .setTextColor(ContextCompat.getColor(requireContext(),
                Element.getTextColor(Element.INITIAL)))

        view.findViewById<TextView>(R.id.menu_deity_alignment_chaotic_text)
            .setTextColor(ContextCompat.getColor(requireContext(),
                Element.getTextColor(Element.UMBRAL)))

        val buttons: List<Button> = listOf(view.findViewById(R.id.menu_deity_back_button),
            view.findViewById(R.id.menu_deity_info))

        colorForDeity(view.findViewById(R.id.menu_deity_anu_background),view.findViewById(R.id.menu_deity_anu_text),Deity.ANU)
        colorForDeity(view.findViewById(R.id.menu_deity_velhu_background),view.findViewById(R.id.menu_deity_velhu_text),Deity.VELHU)
        colorForDeity(view.findViewById(R.id.menu_deity_sid_background),view.findViewById(R.id.menu_deity_sid_text),Deity.SID)
        colorForDeity(view.findViewById(R.id.menu_deity_gabriel_background),view.findViewById(R.id.menu_deity_gabriel_text),Deity.GABRIEL)
        colorForDeity(view.findViewById(R.id.menu_deity_ahros_background),view.findViewById(R.id.menu_deity_ahros_text),Deity.AHROS)
        colorForDeity(view.findViewById(R.id.menu_deity_pythion_background),view.findViewById(R.id.menu_deity_pythion_text),Deity.PYTHION)
        colorForDeity(view.findViewById(R.id.menu_deity_bennu_background),view.findViewById(R.id.menu_deity_bennu_text),Deity.BENNU)
        colorForDeity(view.findViewById(R.id.menu_deity_neptune_background),view.findViewById(R.id.menu_deity_neptune_text),Deity.NEPTUNE)
        colorForDeity(view.findViewById(R.id.menu_deity_gaia_background),view.findViewById(R.id.menu_deity_gaia_text),Deity.GAIA)
        colorForDeity(view.findViewById(R.id.menu_deity_bacchus_background),view.findViewById(R.id.menu_deity_bacchus_text),Deity.BACCHUS)
        colorForDeity(view.findViewById(R.id.menu_deity_mars_background),view.findViewById(R.id.menu_deity_mars_text),Deity.MARS)
        colorForDeity(view.findViewById(R.id.menu_deity_thanatos_background),view.findViewById(R.id.menu_deity_thanatos_text),Deity.THANATOS)
        colorForDeity(view.findViewById(R.id.menu_deity_acheron_background),view.findViewById(R.id.menu_deity_acheron_text),Deity.ACHERON)
        colorForDeity(view.findViewById(R.id.menu_deity_illian_background),view.findViewById(R.id.menu_deity_illian_text),Deity.ILLIAN)
        colorForDeity(view.findViewById(R.id.menu_deity_webspinner_background),view.findViewById(R.id.menu_deity_webspinner_text),Deity.WEBSPINNER)
        colorForDeity(view.findViewById(R.id.menu_deity_muir_background),view.findViewById(R.id.menu_deity_muir_text),Deity.MUIR)
        colorForDeity(view.findViewById(R.id.menu_deity_malacathe_background),view.findViewById(R.id.menu_deity_malacathe_text),Deity.MALACATHE)
        colorForDeity(view.findViewById(R.id.menu_deity_enemy_background),view.findViewById(R.id.menu_deity_enemy_text),Deity.ENEMY)

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),Element.PHYSICAL)
        }

        view.findViewById<Button>(R.id.menu_deity_back_button).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun colorForDeity(imageView: ImageView, textView: TextView, deity: Deity)
    {
        val element: Element = Deity.getElement(deity)
        imageView.setColorFilter(ContextCompat.getColor(requireContext(), Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)
        textView.setTextColor(ContextCompat.getColor(requireContext(), Element.getTextColor(element)))
    }
}
package com.greenwolfgames.monstermaster;

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
 * Fragment to handle the menu_journal layout file
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
public class MenuJournal : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuJournal
        {
            val fragment = MenuJournal()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.menu_journal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        val element: Element = state.getMainCharacterElement()

        view.findViewById<ImageView>(R.id.menu_journal_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_journal_background_fade).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_journal_title),
            view.findViewById(R.id.menu_journal_active),
            view.findViewById(R.id.menu_journal_completed),
            view.findViewById(R.id.menu_journal_quest_1),
            view.findViewById(R.id.menu_journal_quest_2),
            view.findViewById(R.id.menu_journal_quest_3),
            view.findViewById(R.id.menu_journal_quest_4),
            view.findViewById(R.id.menu_journal_quest_5),
            view.findViewById(R.id.menu_journal_previous),
            view.findViewById(R.id.menu_journal_next),
            view.findViewById(R.id.menu_journal_back),
            view.findViewById(R.id.menu_journal_info)
        )

        for(button in buttons)
        {
            Element.colorButton(button, requireContext(), element)
        }

        view.findViewById<Button>(R.id.menu_journal_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
package com.greenwolfgames.monstermaster

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
 * Fragment to handle the display of the menu from the MainActivity
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class MenuFragment : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuFragment
        {
            val fragment = MenuFragment()
            val bundle = Bundle()
            bundle.putSerializable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            state = it.getSerializable("state") as State
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.fragment_menu_button_1),
            view.findViewById(R.id.fragment_menu_button_2),
            view.findViewById(R.id.fragment_menu_button_3),
            view.findViewById(R.id.fragment_menu_button_4),
            view.findViewById(R.id.fragment_menu_button_5),
            view.findViewById(R.id.fragment_menu_button_6),
            view.findViewById(R.id.fragment_menu_button_7),
            view.findViewById(R.id.fragment_menu_button_8)
        )
        for(button in buttons)
        {
            Element.colorButton(button, requireContext(), state.getMainCharacterElement())
        }

        val background: ImageView = view.findViewById(R.id.fragment_menu_background)
        background.setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getBackgroundColor(state.getMainCharacterElement())), PorterDuff.Mode.MULTIPLY)

        buttons[0].setOnClickListener{
            openPlayerInformationMenu()
        }

        buttons[7].setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }


    private fun openPlayerInformationMenu()
    {
        val fragment = PlayerInformationMenu.newInstance(state)
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, fragment)
            .addToBackStack(null) // Adds this transaction to the back stack
            .commit()
    }
}
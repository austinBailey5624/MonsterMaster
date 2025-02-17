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
 * Fragment to handle the menu_inventory layout file
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class MenuInventory: Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuInventory
        {
            val fragment = MenuInventory()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.d("MenuInventory.onCreate()","MenuInventory() triggered")
        super.onCreate(savedInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.menu_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        val element: Element = state.getMainCharacterElement()

        view.findViewById<ImageView>(R.id.menu_inventory_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_inventory_background_fade).setColorFilter(
            ContextCompat.getColor(requireContext(),Element.getTextColor(element)), PorterDuff.Mode.MULTIPLY)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_inventory_title),
            view.findViewById(R.id.menu_inventory_gold),
            view.findViewById(R.id.menu_inventory_weapons),
            view.findViewById(R.id.menu_inventory_armor),
            view.findViewById(R.id.menu_inventory_accessory),
            view.findViewById(R.id.menu_inventory_useable),
            view.findViewById(R.id.menu_inventory_back)
        )

        for(button in buttons)
        {
            Element.colorButton(button, requireContext(), element)
        }

        view.findViewById<Button>(R.id.menu_inventory_gold).setText(ContextCompat.getString(requireContext(),R.string.menu_inventory_gold) + " " + state.currentGold)

        view.findViewById<Button>(R.id.menu_inventory_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
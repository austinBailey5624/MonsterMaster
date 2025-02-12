package com.greenwolfgames.monstermaster

import android.content.Intent
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Fragment to handle the menu_credits layout file
 * @Author Austin Bailey
 * @Year 2025
 *
 * @Copyright 2025 Austin Bailey All Rights Reserved
 */
class MenuCredits : Fragment()
{
    companion object
    {
        fun newInstance(): MenuCredits
        {
            return MenuCredits()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_credits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageView>(R.id.menu_credits_background).setColorFilter(
            ContextCompat.getColor(requireContext(),
                Element.getBackgroundColor(Element.NEUTRAL)),PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_credits_background_fade).setColorFilter(
            ContextCompat.getColor(requireContext(),Element.getTextColor(Element.NEUTRAL)),PorterDuff.Mode.MULTIPLY)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_credits_thanks),
            view.findViewById(R.id.menu_credits_austin_title),
            view.findViewById(R.id.menu_credits_austin_name),
            view.findViewById(R.id.menu_credits_mattie_title),
            view.findViewById(R.id.menu_credits_mattie_name),
            view.findViewById(R.id.menu_credits_chatgpt_title),
            view.findViewById(R.id.menu_credits_chatgpt_name),
            view.findViewById(R.id.menu_credits_your_title),
            view.findViewById(R.id.menu_credits_your_name),
            view.findViewById(R.id.menu_credits_back)
        )

        for(button in buttons)
        {
            Element.colorButton(button,requireContext(),Element.NEUTRAL)
        }

        view.findViewById<Button>(R.id.menu_credits_austin_name).setOnClickListener {
            val url = "https://github.com/austinBailey5624"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


        view.findViewById<Button>(R.id.menu_credits_austin_title).setOnClickListener {
            val url = "https://github.com/austinBailey5624"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.menu_credits_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}

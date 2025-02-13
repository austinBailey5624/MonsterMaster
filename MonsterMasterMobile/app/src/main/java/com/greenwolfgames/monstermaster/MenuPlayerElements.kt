package com.greenwolfgames.monstermaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import android.widget.ImageButton

/**
 * Fragment to handle the display of the player elements menu from the player information menu
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright Austin Bailey 2025 All Rights Reserved
 */
class MenuPlayerElements : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuPlayerElements
        {
            Log.d("MenuPlayerElements.newInstance","MenuPlayerElements newInstance() called")
            val fragment = MenuPlayerElements()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(saveInstanceState: Bundle?)
    {
        Log.d("MenuPlayerElements.onCreate()","On create method of Player Elements Menu called")
        super.onCreate(saveInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        Log.d("MenuPlayerElements.onCreateView","MenuPlayerElements onCreateView() called")
        return inflater.inflate(R.layout.menu_player_elements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)

        // Ensure state is initialized properly, otherwise throw an exception
        if (!::state.isInitialized) {
            throw IllegalStateException("State cannot be null in PlayerInformationMenu.onViewCreated()")
        }

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_player_elements_back),
            view.findViewById(R.id.menu_player_elements_info)
        )

        for(button in buttons)
        {
            Element.colorButton(button, requireContext(), state.getMainCharacterElement())
        }

        var coversByElement = mutableMapOf<Element, ImageView>(
            Element.PYRO to view.findViewById(R.id.menu_player_elements_pyro_cover),
            Element.LAVA to view.findViewById(R.id.menu_player_elements_lava_cover),
            Element.DINO to view.findViewById(R.id.menu_player_elements_dino_cover),
            Element.SAND to view.findViewById(R.id.menu_player_elements_sand_cover),
            Element.JUSTICE to view.findViewById(R.id.menu_player_elements_justice_cover),
            Element.VENGEANCE to view.findViewById(R.id.menu_player_elements_vengeance_cover),
            Element.STEAM to view.findViewById(R.id.menu_player_elements_steam_cover),
            Element.AQUA to view.findViewById(R.id.menu_player_elements_aqua_cover),
            Element.AMPHIBIOUS to view.findViewById(R.id.menu_player_elements_amphibious_cover),
            Element.WEATHER to view.findViewById(R.id.menu_player_elements_weather_cover),
            Element.ICE to view.findViewById(R.id.menu_player_elements_ice_cover),
            Element.DEEP to view.findViewById(R.id.menu_player_elements_deep_cover),
            Element.FEY to view.findViewById(R.id.menu_player_elements_fey_cover),
            Element.PLANT to view.findViewById(R.id.menu_player_elements_plant_cover),
            Element.TERRA to view.findViewById(R.id.menu_player_elements_terra_cover),
            Element.PEGASUS to view.findViewById(R.id.menu_player_elements_pegasus_cover),
            Element.COMPASSION to view.findViewById(R.id.menu_player_elements_compassion_cover),
            Element.ROTTEN to view.findViewById(R.id.menu_player_elements_rotten_cover),
            Element.PHOENIX to view.findViewById(R.id.menu_player_elements_phoenix_cover),
            Element.SEABREEZE to view.findViewById(R.id.menu_player_elements_seabreeze_cover),
            Element.BIRD to view.findViewById(R.id.menu_player_elements_bird_cover),
            Element.AERO to view.findViewById(R.id.menu_player_elements_aero_cover),
            Element.COCKA to view.findViewById(R.id.menu_player_elements_cocka_cover),
            Element.NIGHTWING to view.findViewById(R.id.menu_player_elements_nightwing_cover),
            Element.SOLAR to view.findViewById(R.id.menu_player_elements_solar_cover),
            Element.LUNAR to view.findViewById(R.id.menu_player_elements_lunar_cover),
            Element.GUARDIAN to view.findViewById(R.id.menu_player_elements_guardian_cover),
            Element.ANGEL to view.findViewById(R.id.menu_player_elements_angel_cover),
            Element.LUXOR to view.findViewById(R.id.menu_player_elements_luxor_cover),
            Element.REDEMPTION to view.findViewById(R.id.menu_player_elements_redemption_cover),
            Element.DEMON to view.findViewById(R.id.menu_player_elements_demon_cover),
            Element.POISON to view.findViewById(R.id.menu_player_elements_poison_cover),
            Element.UNDEAD to view.findViewById(R.id.menu_player_elements_undead_cover),
            Element.STORM to view.findViewById(R.id.menu_player_elements_storm_cover),
            Element.BETRAYER to view.findViewById(R.id.menu_player_elements_betrayer_cover),
            Element.UMBRAL to view.findViewById(R.id.menu_player_elements_umbral_cover)
        )

        var buttonsByElement = mutableMapOf<Element, ImageButton>(
            Element.PYRO to view.findViewById(R.id.menu_player_elements_pyro),
            Element.LAVA to view.findViewById(R.id.menu_player_elements_lava),
            Element.DINO to view.findViewById(R.id.menu_player_elements_dino),
            Element.SAND to view.findViewById(R.id.menu_player_elements_sand),
            Element.JUSTICE to view.findViewById(R.id.menu_player_elements_justice),
            Element.VENGEANCE to view.findViewById(R.id.menu_player_elements_vengeance),
            Element.STEAM to view.findViewById(R.id.menu_player_elements_steam),
            Element.AQUA to view.findViewById(R.id.menu_player_elements_aqua),
            Element.AMPHIBIOUS to view.findViewById(R.id.menu_player_elements_amphibious),
            Element.WEATHER to view.findViewById(R.id.menu_player_elements_weather),
            Element.ICE to view.findViewById(R.id.menu_player_elements_ice),
            Element.DEEP to view.findViewById(R.id.menu_player_elements_deep),
            Element.FEY to view.findViewById(R.id.menu_player_elements_fey),
            Element.PLANT to view.findViewById(R.id.menu_player_elements_plant),
            Element.TERRA to view.findViewById(R.id.menu_player_elements_terra),
            Element.PEGASUS to view.findViewById(R.id.menu_player_elements_pegasus),
            Element.COMPASSION to view.findViewById(R.id.menu_player_elements_compassion),
            Element.ROTTEN to view.findViewById(R.id.menu_player_elements_rotten),
            Element.PHOENIX to view.findViewById(R.id.menu_player_elements_phoenix),
            Element.SEABREEZE to view.findViewById(R.id.menu_player_elements_seabreeze),
            Element.BIRD to view.findViewById(R.id.menu_player_elements_bird),
            Element.AERO to view.findViewById(R.id.menu_player_elements_aero),
            Element.COCKA to view.findViewById(R.id.menu_player_elements_cocka),
            Element.NIGHTWING to view.findViewById(R.id.menu_player_elements_nightwing),
            Element.SOLAR to view.findViewById(R.id.menu_player_elements_solar),
            Element.LUNAR to view.findViewById(R.id.menu_player_elements_lunar),
            Element.GUARDIAN to view.findViewById(R.id.menu_player_elements_guardian),
            Element.ANGEL to view.findViewById(R.id.menu_player_elements_angel),
            Element.LUXOR to view.findViewById(R.id.menu_player_elements_luxor),
            Element.REDEMPTION to view.findViewById(R.id.menu_player_elements_redemption),
            Element.DEMON to view.findViewById(R.id.menu_player_elements_demon),
            Element.POISON to view.findViewById(R.id.menu_player_elements_poison),
            Element.UNDEAD to view.findViewById(R.id.menu_player_elements_undead),
            Element.STORM to view.findViewById(R.id.menu_player_elements_storm),
            Element.BETRAYER to view.findViewById(R.id.menu_player_elements_betrayer),
            Element.UMBRAL to view.findViewById(R.id.menu_player_elements_umbral)
        )

        val elements: List<Element> = Element.getAllColoredElements()

        var convertedScoreByElement = mutableMapOf<Element, Double>().withDefault {0.0}
        var score: Double
        var maxScore= 0.0

        for(element in elements)
        {
            score = state.getElementalScoreForMainCharacterElementCalculation(element)
            if(score > maxScore)
            {
                maxScore = score
            }
            convertedScoreByElement[element] = score
        }
        for(element in elements)
        {
            coversByElement[element]!!.alpha =
                1 - ((convertedScoreByElement[element]?.div(maxScore))?.toFloat() ?: throw IllegalStateException("Element cannot be null"))
        }

        for((element, imageButton) in buttonsByElement)
        {
            imageButton.setOnClickListener{
                openPlayerElementMenu(element)
            }
        }

        view.findViewById<Button>(R.id.menu_player_elements_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun openPlayerElementMenu(element: Element)
    {
        state.uiElement = element
        val fragment = MenuPlayerElement.newInstance(state)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_menu_frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}
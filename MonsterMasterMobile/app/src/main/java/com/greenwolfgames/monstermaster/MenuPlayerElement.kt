package com.greenwolfgames.monstermaster;

import android.content.Context
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
import java.util.Locale

/**
 * Fragment to handle the display of the player element menu
 * @Author: Austin Bailey
 * @Year: 2025
 *
 * @Copyright: Austin Bailey 2025 All Rights Reserved
 */
public class MenuPlayerElement : Fragment()
{
    private lateinit var state: State

    companion object
    {
        fun newInstance(state: State): MenuPlayerElement
        {
            Log.d("MenuPlayerElement.newInstance","MenuPlayerElement newInstance() called")
            val fragment = MenuPlayerElement()
            val bundle = Bundle()
            bundle.putParcelable("state", state)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(saveInstanceState: Bundle?)
    {
        Log.d("MenuPlayerElement.onCreate()","On create method of Player Element Menu called.")
        super.onCreate(saveInstanceState)
        state = arguments?.getParcelable("state") ?: throw IllegalStateException("State cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        Log.d("MenuPlayerElement.onCreateView","MenuPlayerElement onCreateView() called")
        return inflater.inflate(R.layout.menu_player_element, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val buttons: List<Button> = listOf(
            view.findViewById(R.id.menu_player_element_title),
            view.findViewById(R.id.menu_player_element_description),
            view.findViewById(R.id.menu_player_element_back)
        )

        val element: Element = state.getUIElement()

        for(button in buttons)
        {
            Element.colorButton(button, requireContext(), element)
        }

        view.findViewById<ImageView>(R.id.menu_player_element_background).setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getBackgroundColor(element)), PorterDuff.Mode.MULTIPLY)

        view.findViewById<ImageView>(R.id.menu_player_element_background_fade).setColorFilter(ContextCompat.getColor(requireContext(),
            Element.getTextColor(element)), PorterDuff.Mode.MULTIPLY)
        view.findViewById<Button>(R.id.menu_player_element_title).text = Element.getName(requireContext(), element)

        val symbols: List<ImageView> = listOf(
            view.findViewById(R.id.menu_player_element_symbol),
            view.findViewById(R.id.menu_player_element_symbol_left),
            view.findViewById(R.id.menu_player_element_symbol_right)
        )

        for(symbol in symbols)
        {
            symbol.setImageResource(Element.getSymbol(element))
        }

        val score: Double = state.getElementalScoreForMainCharacterElementCalculation(element)
        val rank: Int = state.getMainCharacterElementalScoreRank(element)

        val modifier: Double = calculateModifier(score,rank)

        var bonusString: String =ContextCompat.getString(requireContext(),R.string.menu_element_score_5)
        if(modifier <0)
        {
            bonusString = ContextCompat.getString(requireContext(),R.string.menu_element_score_5_alt)
        }
        val description1: String =
            Element.getDescription(requireContext(),element) + "\n" + ContextCompat.getString(requireContext(),R.string.menu_element_tap_for_more_info)

        val description2: String =
                    ContextCompat.getString(requireContext(),R.string.menu_element_score_1) + " " + String.format(Locale.US,"%.3g",score) + " " +
                    ContextCompat.getString(requireContext(),R.string.menu_element_score_2) + " " + Element.getName(requireContext(),element) + " " +
                    ContextCompat.getString(requireContext(),R.string.menu_element_score_3) + " " + getRankWordForInt(requireContext(),rank) + " " +
                    ContextCompat.getString(requireContext(),R.string.menu_element_score_4) + " " + bonusString + " " +
                    parseModifier(calculateModifier(score,rank)) + " " +
                    ContextCompat.getString(requireContext(),R.string.menu_element_score_6) + " " + parseModifier(calculateModifier(score,rank)*1.2) + " " +
                    ContextCompat.getString(requireContext(),R.string.menu_element_score_7)

        view.findViewById<TextView>(R.id.menu_player_element_description)
            .setAutoSizeTextTypeUniformWithConfiguration(10,  // Minimum text size in sp
                33, // Maximum text size in sp
                2,   // Step granularity in sp
                TypedValue.COMPLEX_UNIT_SP)

        view.findViewById<TextView>(R.id.menu_player_element_description).setTextColor(ContextCompat.getColor(requireContext(),Element.getTextColor(element)))

        val maxScore = state.getMainCharacterMaxElementalScore()

        view.findViewById<ImageView>(R.id.menu_player_element_symbol_overlap).alpha = 1 - (score/maxScore).toFloat()

        view.findViewById<Button>(R.id.menu_player_element_description).text = description1

        view.findViewById<Button>(R.id.menu_player_element_description).setOnClickListener {
            if (view.findViewById<Button>(R.id.menu_player_element_description).text.equals(description1))
            {
                view.findViewById<Button>(R.id.menu_player_element_description).text = description2
            }
            else
            {
                view.findViewById<Button>(R.id.menu_player_element_description).text = description1
            }
        }

        view.findViewById<Button>(R.id.menu_player_element_back).setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    fun parseModifier(modifier: Double): String
    {
        return String.format(Locale.US,"%.3g",(modifier * 100)) + "%"
    }

    fun calculateModifier(score: Double, rank: Int): Double
    {
        return calculateRankModifier(rank) + calculateScoreModifier(score)
    }

    fun calculateRankModifier(rank: Int): Double
    {
        if(rank == 1)
        {
            return .3
        }
        if(rank == 2)
        {
            return .2
        }
        if(rank == 3)
        {
            return .15
        }
        if(rank == 4)
        {
            return .12
        }
        if(rank == 5)
        {
            return .1
        }
        if(rank == 6)
        {
            return .05
        }
        if(rank == 31)
        {
            return .05
        }
        if(rank == 32)
        {
            return -.1
        }
        if(rank == 33)
        {
            return -.12
        }
        if(rank == 34)
        {
            return -.15
        }
        if(rank == 35)
        {
            return -.2
        }
        if(rank == 36)
        {
            return -.3
        }
        return 0.0
    }

    class ThresholdScorePair(val threshold: Double, val score: Double)

    fun calculateScoreModifier(score: Double): Double
    {
        val thresholds: List<ThresholdScorePair> = listOf(
            ThresholdScorePair(1.0, 2.0),
            ThresholdScorePair(2.0, 4.0),
            ThresholdScorePair(3.0, 5.0),
            ThresholdScorePair(4.0, 6.0),
            ThresholdScorePair(6.0, 7.0),
            ThresholdScorePair(8.0, 8.0),
            ThresholdScorePair(12.0, 9.0),
            ThresholdScorePair(16.0, 10.0),
            ThresholdScorePair(24.0, 11.0),
            ThresholdScorePair(32.0, 12.0),
            ThresholdScorePair(48.0, 13.0),
            ThresholdScorePair(64.0, 14.0),
            ThresholdScorePair(96.0, 15.0),
            ThresholdScorePair(128.0, 16.0),
            ThresholdScorePair(192.0, 17.0),
            ThresholdScorePair(256.0, 18.0),
            ThresholdScorePair(384.0, 19.0),
            ThresholdScorePair(512.0, 20.0),
            ThresholdScorePair(768.0, 21.0),
            ThresholdScorePair(1024.0, 22.0),
            ThresholdScorePair(1536.0, 23.0),
            ThresholdScorePair(2048.0, 24.0),
            ThresholdScorePair(3072.0, 25.0),
            ThresholdScorePair(4096.0, 26.0),
            ThresholdScorePair(6144.0, 27.0),
            ThresholdScorePair(8192.0, 28.0),
            ThresholdScorePair(12288.0, 28.0),
            ThresholdScorePair(16384.0, 30.0),
            ThresholdScorePair(24576.0, 31.0),
            ThresholdScorePair(32768.0, 32.0),
            ThresholdScorePair(49152.0, 33.0),
            ThresholdScorePair(65536.0, 34.0),
            ThresholdScorePair(98304.0, 35.0),
            ThresholdScorePair(131072.0, 36.0),
            ThresholdScorePair(196608.0, 37.0),
            ThresholdScorePair(262144.0, 38.0),
            ThresholdScorePair(393216.0, 39.0),
            ThresholdScorePair(524288.0, 40.0)
        )

        val threshold = thresholds.firstOrNull { score > it.threshold }
        if(threshold == null)
        {
            return 0.0
        }
        return threshold.score / 100.0
    }

    fun getRankWordForInt(context: Context, rank: Int): String
    {
        val rankWords: List<String> = listOf(
            ContextCompat.getString(context, R.string.rank_word_1),
            ContextCompat.getString(context, R.string.rank_word_2),
            ContextCompat.getString(context, R.string.rank_word_3),
            ContextCompat.getString(context, R.string.rank_word_4),
            ContextCompat.getString(context, R.string.rank_word_5),
            ContextCompat.getString(context, R.string.rank_word_6),
            ContextCompat.getString(context, R.string.rank_word_7),
            ContextCompat.getString(context, R.string.rank_word_8),
            ContextCompat.getString(context, R.string.rank_word_9),
            ContextCompat.getString(context, R.string.rank_word_10),
            ContextCompat.getString(context, R.string.rank_word_11),
            ContextCompat.getString(context, R.string.rank_word_12),
            ContextCompat.getString(context, R.string.rank_word_13),
            ContextCompat.getString(context, R.string.rank_word_14),
            ContextCompat.getString(context, R.string.rank_word_15),
            ContextCompat.getString(context, R.string.rank_word_16),
            ContextCompat.getString(context, R.string.rank_word_17),
            ContextCompat.getString(context, R.string.rank_word_18),
            ContextCompat.getString(context, R.string.rank_word_19),
            ContextCompat.getString(context, R.string.rank_word_20),
            ContextCompat.getString(context, R.string.rank_word_21),
            ContextCompat.getString(context, R.string.rank_word_22),
            ContextCompat.getString(context, R.string.rank_word_23),
            ContextCompat.getString(context, R.string.rank_word_24),
            ContextCompat.getString(context, R.string.rank_word_25),
            ContextCompat.getString(context, R.string.rank_word_26),
            ContextCompat.getString(context, R.string.rank_word_27),
            ContextCompat.getString(context, R.string.rank_word_28),
            ContextCompat.getString(context, R.string.rank_word_29),
            ContextCompat.getString(context, R.string.rank_word_30),
            ContextCompat.getString(context, R.string.rank_word_31),
            ContextCompat.getString(context, R.string.rank_word_32),
            ContextCompat.getString(context, R.string.rank_word_33),
            ContextCompat.getString(context, R.string.rank_word_34),
            ContextCompat.getString(context, R.string.rank_word_35),
            ContextCompat.getString(context, R.string.rank_word_36)
        )

        return rankWords.get(rank-1)//-1 since zero indexed
    }
}

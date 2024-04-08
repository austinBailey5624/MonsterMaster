package com.greenwolfgames.monstermaster

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale

class Scene12Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene12_monsters_call)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State

        val monsterImage = when (currentState.starterMonster) {
            "Spiten" -> R.drawable.spiten
            "Flapper" -> R.drawable.flapper
            "Bulbapup" -> R.drawable.bulbapup
            "Lumin" -> R.drawable.lumin
            "Minnow" -> R.drawable.minnow
            "Flarial" -> R.drawable.flarial
            "Deepfish" -> R.drawable.deepfish
            "Lona" -> R.drawable.lona
            "Tona" -> R.drawable.tona
            "Umbress" -> R.drawable.umbress
            else -> R.drawable.bulbapup
        }
        val monsterView = findViewById<ImageView>(R.id.monsterView)
        val monsterDrawable = ContextCompat.getDrawable(this, monsterImage)
        monsterView.setImageDrawable(monsterDrawable)
        monsterView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in_slow))

        val sceneItems = getStrings(currentState.starterMonster, currentState.previousSceneName)

        val button: Button = findViewById(R.id.button2)
        Utilities.hideButton(button, this@Scene12Activity)
        val items: List<TextView> = listOf(
            findViewById<TextView>(R.id.textView),
            findViewById<TextView>(R.id.textView2),
            findViewById<TextView>(R.id.textView3),
            findViewById<TextView>(R.id.textView4),
            findViewById<TextView>(R.id.textView5),
            findViewById<TextView>(R.id.textView6),
            findViewById<TextView>(R.id.textView7)
        )
        var index: Int = 0
        for (sceneItem in sceneItems) {
            items[index].setText(sceneItem)
            items[index].setTextColor(ContextCompat.getColor(this, R.color.invisible))
            index++
        }

        val fadeInAnimations: List<Animation> = listOf(
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(this, R.anim.fade_in_fast)
        )

        fadeInAnimations[sceneItems.size].setAnimationListener(object :
            Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                Element.colorButton(button, this@Scene12Activity, Element.LIGHT)
                button.startAnimation(
                    AnimationUtils.loadAnimation(
                        this@Scene12Activity,
                        R.anim.fade_in_fast
                    )
                )
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        for(i in 0..sceneItems.size-1)
        {
            fadeInAnimations[i].setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    items[i].startAnimation(fadeInAnimations[i + 1])
                    items[i].setTextColor(ContextCompat.getColor(this@Scene12Activity, R.color.whiteGray))
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
        }



        if (sceneItems.size == 5) {
            val constraintLayout = items[4].parent as ConstraintLayout
            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)
            constraintSet.connect(
                items[4].id,
                ConstraintSet.BOTTOM,
                button.id,
                ConstraintSet.TOP,
            )
            constraintSet.applyTo(constraintLayout)
            items[5].visibility = TextView.GONE
            items[6].visibility = TextView.GONE
        }
        if (sceneItems.size == 6) {
            val constraintLayout = items[5].parent as ConstraintLayout
            val constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)
            constraintSet.connect(
                items[5].id,
                ConstraintSet.BOTTOM,
                button.id,
                ConstraintSet.TOP,
            )
            constraintSet.applyTo(constraintLayout)
            items[6].visibility = TextView.GONE
        }
        val parent = findViewById<ConstraintLayout>(R.id.Parent)
        if(currentState.starterMonster == "Spiten" || currentState.starterMonster == "Flarial") {
            parent.setBackgroundColor(
                ContextCompat.getColor(
                    this@Scene12Activity,
                    R.color.darkRed
                )
            )
        }
        else if (currentState.starterMonster == "Flapper") {
            parent.setBackgroundColor(
                ContextCompat.getColor(
                    this@Scene12Activity,
                    R.color.darkYellow
                )
            )
        }
        else if (currentState.starterMonster == "Lumin") {
            parent.setBackgroundColor(ContextCompat.getColor(this@Scene12Activity, R.color.gray))
        }
        else if (currentState.starterMonster == "Minnow" || currentState.starterMonster == "Deepfish") {
            parent.setBackgroundColor(ContextCompat.getColor(this@Scene12Activity, R.color.blue))
        }
        else if (currentState.starterMonster == "Lona") {
            parent.setBackgroundColor(
                ContextCompat.getColor(
                    this@Scene12Activity,
                    R.color.lightCyanBlue
                )
            )
        }
        else if (currentState.starterMonster == "Tona") {
            parent.setBackgroundColor(
                ContextCompat.getColor(
                    this@Scene12Activity,
                    R.color.lightOrange
                )
            )
        }
        else if (currentState.starterMonster == "Bulbapup") {
            parent.setBackgroundColor(
                ContextCompat.getColor(
                    this@Scene12Activity,
                    R.color.forestGreen
                )
            )
        }
        else if(currentState.starterMonster == "Umbress")
        {
            parent.setBackgroundColor(ContextCompat.getColor(this@Scene12Activity, R.color.black))
        }
        else {
            parent.setBackgroundColor(ContextCompat.getColor(this@Scene12Activity, R.color.blue))
        }


        button.setOnClickListener {

            val textInputEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
            var temp: String = textInputEditText.text.toString()
            if(temp != "")
            {
                if(temp.length > 12)
                {
                    temp = temp.substring(0,12)
                }
                temp.toLowerCase(Locale.getDefault())
                temp = temp.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                currentState.playerName = temp.trim()

                currentState.previousSceneName = "Scene12Activity"
                val intent = Intent(this, Scene13Activity::class.java)
                intent.putExtra("state", currentState)
                startActivity(intent)
            }
        }
        items[0].startAnimation(fadeInAnimations[0])
    }

    override fun onBackPressed() {
        if (false) {
            super.onBackPressed()
        }
        // Do nothing here
    }

    fun getStrings(monsterName: String, prevSceneName: String): List<Int> {
        if (prevSceneName == "Scene8Activity") {
            if (monsterName == "Lumin") {
                return listOf(
                    R.string.scene12var1item1,
                    R.string.scene12var1item2,
                    R.string.scene12var1item3,
                    R.string.scene12var1item4,
                    R.string.scene12var1item5
                )
            }
            if (monsterName == "Flarial") {
                return listOf(
                    R.string.scene12var2item1,
                    R.string.scene12var2item2,
                    R.string.scene12var2item3,
                    R.string.scene12var2item4,
                    R.string.scene12var2item5
                )
            }
            if (monsterName == "Bulbapup") {
                return listOf(
                    R.string.scene12var3item1,
                    R.string.scene12var3item2,
                    R.string.scene12var3item3,
                    R.string.scene12var3item4,
                    R.string.scene12var3item5,
                    R.string.scene12var3item6
                )
            }
            if (monsterName == "Flapper") {
                return listOf(
                    R.string.scene12var4item1,
                    R.string.scene12var4item2,
                    R.string.scene12var4item3,
                    R.string.scene12var4item4,
                    R.string.scene12var4item5,
                    R.string.scene12var4item6,
                    R.string.scene12var4item7
                )
            }
            if (monsterName == "Tona") {
                return listOf(
                    R.string.scene12var5item1,
                    R.string.scene12var5item2,
                    R.string.scene12var5item3,
                    R.string.scene12var5item4,
                    R.string.scene12var5item5
                )
            }
        }
        if (prevSceneName == "Scene9Activity") {
            if (monsterName == "Lumin") {
                return listOf(
                    R.string.scene12var6item1,
                    R.string.scene12var6item2,
                    R.string.scene12var6item3,
                    R.string.scene12var6item4,
                    R.string.scene12var6item5
                )
            }
            if (monsterName == "Minnow") {
                return listOf(
                    R.string.scene12var7item1,
                    R.string.scene12var7item2,
                    R.string.scene12var7item3,
                    R.string.scene12var7item4,
                    R.string.scene12var7item5,
                    R.string.scene12var7item6
                )
            }
            if (monsterName == "Bulbapup") {
                return listOf(
                    R.string.scene12var8item1,
                    R.string.scene12var8item2,
                    R.string.scene12var8item3,
                    R.string.scene12var8item4,
                    R.string.scene12var8item5
                )
            }
            if (monsterName == "Flapper") {
                return listOf(
                    R.string.scene12var9item1,
                    R.string.scene12var9item2,
                    R.string.scene12var9item3,
                    R.string.scene12var9item4,
                    R.string.scene12var9item5,
                    R.string.scene12var9item6,
                    R.string.scene12var9item7
                )
            }
            if (monsterName == "Lona") {
                return listOf(
                    R.string.scene12var10item1,
                    R.string.scene12var10item2,
                    R.string.scene12var10item3,
                    R.string.scene12var10item4,
                    R.string.scene12var10item5,
                    R.string.scene12var10item6
                )
            }
        }
        if (prevSceneName == "Scene10Activity") {
            if (monsterName == "Spiten") {
                return listOf(
                    R.string.scene12var11item1,
                    R.string.scene12var11item2,
                    R.string.scene12var11item3,
                    R.string.scene12var11item4,
                    R.string.scene12var11item5
                )
            }
            if (monsterName == "Flapper") {
                return listOf(
                    R.string.scene12var12item1,
                    R.string.scene12var12item2,
                    R.string.scene12var12item3,
                    R.string.scene12var12item4,
                    R.string.scene12var12item5,
                )
            }
            if (monsterName == "Bulbapup") {
                return listOf(
                    R.string.scene12var13item1,
                    R.string.scene12var13item2,
                    R.string.scene12var13item3,
                    R.string.scene12var13item4,
                    R.string.scene12var13item5,
                    R.string.scene12var13item6
                )
            }
            if (monsterName == "Flarial") {
                return listOf(
                    R.string.scene12var14item1,
                    R.string.scene12var14item2,
                    R.string.scene12var14item3,
                    R.string.scene12var14item4,
                    R.string.scene12var14item5,
                    R.string.scene12var14item6
                )
            }
            if (monsterName == "Umbress") {
                return listOf(
                    R.string.scene12var15item1,
                    R.string.scene12var15item2,
                    R.string.scene12var15item3,
                    R.string.scene12var15item4,
                    R.string.scene12var15item5
                )
            }
        }
        if (prevSceneName == "Scene11Activity") {
            if (monsterName == "Minnow") {
                return listOf(
                    R.string.scene12var16item1,
                    R.string.scene12var16item2,
                    R.string.scene12var16item3,
                    R.string.scene12var16item4,
                    R.string.scene12var16item5
                )
            }
            if (monsterName == "Deepfish") {
                return listOf(
                    R.string.scene12var17item1,
                    R.string.scene12var17item2,
                    R.string.scene12var17item3,
                    R.string.scene12var17item4,
                    R.string.scene12var17item5
                )
            }
            if (monsterName == "Bulbapup") {
                return listOf(
                    R.string.scene12var18item1,
                    R.string.scene12var18item2,
                    R.string.scene12var18item3,
                    R.string.scene12var18item4,
                    R.string.scene12var18item5,
                    R.string.scene12var18item6
                )
            }
            if (monsterName == "Flapper") {
                return listOf(
                    R.string.scene12var19item1,
                    R.string.scene12var19item2,
                    R.string.scene12var19item3,
                    R.string.scene12var19item4,
                    R.string.scene12var19item5,
                    R.string.scene12var19item6,
                    R.string.scene12var19item7
                )
            }
            if (monsterName == "Umbress") {
                return listOf(
                    R.string.scene12var20item1,
                    R.string.scene12var20item2,
                    R.string.scene12var20item3,
                    R.string.scene12var20item4,
                    R.string.scene12var20item5
                )
            }
        }
        throw IllegalStateException("Invalid monsterName or prevSceneName passed to getStrings(). MonsterName: " + monsterName + " prevSceneName: " + prevSceneName)
    }

}
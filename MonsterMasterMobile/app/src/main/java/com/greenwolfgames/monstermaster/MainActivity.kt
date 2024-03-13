package com.greenwolfgames.monstermaster

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setScenario()

    }

    private fun setScenario(){
        val currentScenario: Scenario = getScenario()

        val buttons: List<Button> = listOf(findViewById(R.id.button1), findViewById(R.id.button2))

        val textViews: List<TextView> = listOf(findViewById(R.id.text1), findViewById(R.id.text2), findViewById(R.id.text3), findViewById(R.id.text4),
            findViewById(R.id.text5), findViewById(R.id.text6), findViewById(R.id.text7))

        val mainView: ConstraintLayout = findViewById(R.id.main)

        mainView.setBackgroundColor(ContextCompat.getColor(this, R.color.darkBackground))

        var index = 0
        for(button in buttons)
        {
            button.text = currentScenario.choices.get(index)
            button.setOnClickListener { Toast.makeText(this,  "$index clicked", Toast.LENGTH_SHORT).show()}
            button.setTextColor(ContextCompat.getColor(this,R.color.darkTextColor))
            index ++
        }
        index = 0
        for(textView in textViews)
        {
            if(currentScenario.statements.size <= index)
            {
                textView.visibility = View.INVISIBLE
            }
            else
            {
                textView.text = currentScenario.statements.get(index)
                textView.setTextColor(ContextCompat.getColor(this,R.color.darkTextColor))
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
            }
            index++
        }
    }

    private fun getScenario(): Scenario
    {
            val statements = mutableListOf<String>()
            statements += getString(R.string.scene1item1)
            statements += getString(R.string.scene1item2)
            statements += getString(R.string.scene1item3)
            statements += getString(R.string.scene1item4)
            statements += getString(R.string.scene1item5)
            statements += getString(R.string.scene1item6)
            val choices = mutableListOf<String>()
            choices += getString(R.string.scene1choice1)
            choices += getString(R.string.scene1choice2)
            val scenario = Scenario()
            scenario.statements = statements
            scenario.choices = choices
            return scenario
    }
}
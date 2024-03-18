package com.greenwolfgames.monstermaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Scene2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene2_forest)
        val extras = intent.extras
        val state = extras?.getSerializable("state") as? State

    }
}
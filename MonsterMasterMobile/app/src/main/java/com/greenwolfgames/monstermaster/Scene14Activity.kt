package com.greenwolfgames.monstermaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Scene14Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene14_players_room_initial)
        val extras = intent.extras
        val currentState = extras?.getSerializable("state") as State
    }
}
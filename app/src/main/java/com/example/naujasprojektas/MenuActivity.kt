package com.example.naujasprojektas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.naujasprojektas.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnStats = findViewById<Button>(R.id.btnStats)

        val btnAddStats = findViewById<Button>(R.id.btnAddStats)
        btnAddStats.setOnClickListener {
            val intent = Intent(this,AddStatsActivity::class.java)
            startActivity(intent)
        }

        btnStats.setOnClickListener {
            val intent = Intent(this,StatisticsActivity::class.java)
            startActivity(intent)
        }



    }


}
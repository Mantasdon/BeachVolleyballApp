package com.example.naujasprojektas

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class StatisticsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_statistics)
        // Retrieve the quantities from SharedPreferences
        val sharedPref = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        val savedPoints = sharedPref.getInt("SAVED_POINTS", 0)
        val savedBlocks = sharedPref.getInt("SAVED_BLOCKS", 0)
        val savedKills = sharedPref.getInt("SAVED_KILLS", 0)

        // Display the quantities in TextViews or use them as needed
        val pointsTextView = findViewById<TextView>(R.id.tvPoints)
        val blocksTextView = findViewById<TextView>(R.id.tvBlocks)
        val killsTextView = findViewById<TextView>(R.id.tvKills)

        pointsTextView.text = "Points: $savedPoints"
        blocksTextView.text = "Blocks: $savedBlocks"
        killsTextView.text = "Kills: $savedKills"

        val backButton = findViewById<Button>(R.id.btnBack)
        backButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}

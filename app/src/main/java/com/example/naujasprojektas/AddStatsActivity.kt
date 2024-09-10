package com.example.naujasprojektas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddStatsActivity : AppCompatActivity() {
    private lateinit var QQVPoints: QuantityCounterView
    private lateinit var QQVBlocks: QuantityCounterView
    private lateinit var QQVKills: QuantityCounterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_stats)

        QQVPoints = findViewById(R.id.quantityCounterViewPoints)
        QQVBlocks = findViewById(R.id.quantityCounterViewBlocks)
        QQVKills = findViewById(R.id.quantityCounterViewKills)

        val backButton = findViewById<Button>(R.id.btnBack)
        val saveButton = findViewById<Button>(R.id.btnSaveStats)

        saveButton.setOnClickListener {
            // Retrieve quantities from QuantityCounterView instances
            val points = QQVPoints.getQuantity() // Assuming you have a method to get the quantity
            val blocks = QQVBlocks.getQuantity() // Assuming you have a method to get the quantity
            val kills = QQVKills.getQuantity() // Assuming you have a method to get the quantity

            // Save the quantities in SharedPreferences
            val sharedPref = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putInt("SAVED_POINTS", points)
                putInt("SAVED_BLOCKS", blocks)
                putInt("SAVED_KILLS", kills)
                apply()
            }

            // Optionally show a message or handle post-save logic
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}

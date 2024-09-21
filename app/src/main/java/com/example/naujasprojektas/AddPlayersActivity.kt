package com.example.naujasprojektas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naujasprojektas.databinding.ActivityAddPlayersBinding
import com.example.naujasprojektas.db.PLayerDatabase
import com.example.naujasprojektas.db.Player

class AddPlayersActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAddPlayersBinding
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var clearButton: Button

    private lateinit var viewModel:PlayerViewModel
    private lateinit var playerRecyclerView: RecyclerView
    private lateinit var adapter: PlayerRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameEditText = findViewById(R.id.etName)
        emailEditText = findViewById(R.id.etEmail)
        saveButton = findViewById(R.id.btnSave)
        clearButton= findViewById(R.id.btnClear)
        playerRecyclerView = findViewById(R.id.rvPlayers)

        val dao = PLayerDatabase. getInstance(application).playerDao()
        val factory = PlayerViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(PlayerViewModel::class.java)

        saveButton.setOnClickListener {
            savePlayerData()
            clearInput()
        }

        clearButton.setOnClickListener {
            clearInput()
        }
        initRecyclerView()

    }

    private fun savePlayerData(){

       // val name = nameEditText.text.toString()
        //val email = emailEditText.text.toString()
       // val player = Player(0, name, email)
       // viewModel.insertPlayer(player)

        viewModel.insertPlayer(
            Player(
                0,
                nameEditText.text.toString(),
                emailEditText.text.toString()
            )
        )
    }


    private fun clearInput(){
        nameEditText.setText("")
        emailEditText.setText("")

    }

    private fun initRecyclerView(){

        playerRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlayerRecyclerViewAdapter()
        playerRecyclerView.adapter = adapter

        displayPlayerList()
    }
    private fun displayPlayerList(){

        viewModel.players.observe(this, {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

}
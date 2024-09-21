package com.example.naujasprojektas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.naujasprojektas.db.Player

class PlayerRecyclerViewAdapter():RecyclerView.Adapter<PlayerViewHolder>() {

    private val playerList = ArrayList<Player>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return  PlayerViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(playerList[position])
    }

    fun setList(players : List <Player>){
        playerList.clear()
        playerList.addAll(players)



    }

}

class PlayerViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    fun bind(player: Player){
        val nameTextView = view.findViewById<TextView>(R.id.tvPlayerName)
        val emailTextView = view.findViewById<TextView>(R.id.tvEmail)
        nameTextView.text = player.name
        emailTextView.text = player.name

    }
}
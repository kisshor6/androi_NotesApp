package com.example.march10_roomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRecyclerAdapter(private val context : Context, private val allContent : List<Content>, private val listener : ICONTENT) : RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        val textContent = itemview.findViewById<TextView>(R.id.content)
        val deleteButton = itemview.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))

        view.deleteButton.setOnClickListener {
            listener.onItemClicked(allContent[view.adapterPosition])
        }
        return view
    }

    override fun getItemCount(): Int {
        return allContent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentContent = allContent[position]
        holder.textContent.text = currentContent.title
    }
}

interface ICONTENT{
    fun onItemClicked(content: Content)
}
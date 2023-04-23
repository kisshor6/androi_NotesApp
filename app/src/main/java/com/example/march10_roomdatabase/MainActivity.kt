package com.example.march10_roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ICONTENT {
    lateinit var viewModel: ContentViewModel
    lateinit var recycler : RecyclerView
    lateinit var textContent : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)


        textContent = findViewById(R.id.EnteredContent)
        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(ContentViewModel::class.java)
        viewModel.allContent.observe(this, Observer {
            val adapter = NotesRecyclerAdapter(this, it, this)
            recycler.adapter = adapter
        })
    }

    fun SubmitData(view: View) {
        val contentText = textContent.text.toString()
        if (contentText.isNotEmpty()){
            viewModel.insertContent(Content(contentText))
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show()
            textContent.setText("")
        }

    }

    override fun onItemClicked(content: Content) {
        viewModel.deleteContent(content)
        Toast.makeText(this, "Data no ${content.id} Deleted", Toast.LENGTH_LONG).show()
    }
}
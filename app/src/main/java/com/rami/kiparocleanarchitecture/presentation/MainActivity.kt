package com.rami.kiparocleanarchitecture

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rami.kiparocleanarchitecture.presentation.MainViewModel
import com.rami.kiparocleanarchitecture.presentation.MainViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var vm: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("COP", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)


        val dataTextView = findViewById<TextView>(R.id.data_text_view)
        val dataEditText = findViewById<EditText>(R.id.data_edit_text)
        val sendButton = findViewById<Button>(R.id.send_button)
        val receiveButton = findViewById<Button>(R.id.receive_button)

        vm.resultLive.observe(this, Observer { text ->
            dataTextView.text = text

        })

        sendButton.setOnClickListener {
            //Клик на кнопку Save data
            val text = dataEditText.text.toString()
            vm.save(text)
        }

        receiveButton.setOnClickListener {
            //Клик на кнопку Get data
            vm.load()
        }

    }
}
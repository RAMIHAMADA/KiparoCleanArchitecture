package com.rami.kiparocleanarchitecture

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.rami.cleancodetest.data.repository.UserRepoImpl
import com.rami.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.rami.kiparocleanarchitecture.R
import com.rami.kiparocleanarchitecture.presentation.MainViewModel

class MainActivity : ComponentActivity() {
    private val userRepo by lazy(LazyThreadSafetyMode.NONE) {
        UserRepoImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.rami.cleancodetest.domain.usecase.GetUserNameUseCase(
            userRepo = userRepo
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.rami.cleancodetest.domain.usecase.SaveUerNameUseCase(
            userRepo = userRepo
        )
    }

    private lateinit var vm: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("COP", "Activity created")

        vm = MainViewModel()

        val dataTextView = findViewById<TextView>(R.id.data_text_view)
        val dataEditText = findViewById<EditText>(R.id.data_edit_text)
        val sendButton = findViewById<Button>(R.id.send_button)
        val receiveButton = findViewById<Button>(R.id.receive_button)

        sendButton.setOnClickListener {
            //Клик на кнопку Save data
            val text = dataEditText.text.toString()
            val params = com.rami.cleancodetest.domain.models.SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            //Клик на кнопку Get data

            val userName: com.rami.cleancodetest.domain.models.UserName =
                getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

    }
}
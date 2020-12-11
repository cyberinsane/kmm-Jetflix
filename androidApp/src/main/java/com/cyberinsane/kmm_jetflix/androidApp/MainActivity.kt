package com.cyberinsane.kmm_jetflix.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cyberinsane.kmm_jetflix.shared.JetflixApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading..."

        MainScope().launch {
            val popular = JetflixApi().getPopular()
            println(popular)
            popular.shows?.let {
                tv.text = it.map { it.name }.joinToString(separator = "\n")
            }
        }
    }
}

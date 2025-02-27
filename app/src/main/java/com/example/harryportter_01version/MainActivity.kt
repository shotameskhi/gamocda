package com.example.harryportter_01version

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.harryportter_01version.presentation.BookListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.clickButton).setOnClickListener {
            startActivity(Intent(this, BookListActivity::class.java))
        }
    }

}
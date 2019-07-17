package com.ubrain.shareviademoproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var mEtEnterText: EditText
    private lateinit var mBtnShareText: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mEtEnterText = findViewById<EditText>(R.id.et_enter_text)
        mBtnShareText = findViewById<Button>(R.id.btnShareText)


        mBtnShareText.setOnClickListener {
            if (mEtEnterText!!.text.trim().toString().isNotEmpty()) {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, mEtEnterText!!.text.toString())
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(sendIntent, "share Text Via"))
            }
        }
    }
}

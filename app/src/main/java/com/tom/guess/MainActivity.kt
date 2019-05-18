package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber=SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","secretNumber:"+secretNumber.secret)

    }

    fun check(view:View){
        val n=number.text.toString().toInt()
        Log.d("MainActivity","number:"+n)
        val diff=secretNumber.validate(n)
        var message="Bingo!!"
        if(diff<0){
            message="Bigger"
        }else if(diff>0){
            message="Smaller"
        }
        //Toast.makeText(this,message,Toast.LENGTH_LONG).show()//浮動訊息
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(message)
            .setPositiveButton("OK",null)
            .show()
    }
}

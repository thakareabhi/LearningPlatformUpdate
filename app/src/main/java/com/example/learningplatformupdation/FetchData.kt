package com.example.learningplatformupdation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FetchData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_data2)

        var vidid:String=""
        var k:String=""
        vidid= intent.getStringExtra("VDID").toString()
        k=intent.getStringExtra("K").toString()
        val editText = findViewById<EditText> (R.id.editText1)
        val Button = findViewById<Button>(R.id.button3)
        val tv2 = findViewById<TextView>(R.id.textView2)

        tv2.setText("")
        tv2.setText(vidid)

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference


        Button.setOnClickListener() {
            var str=editText.text.toString();
            if(str.length==11)
            {
                if(k.equals("A"))
                {
                    val demoRef: DatabaseReference = rootRef.child("VideoStrings").child("Video")
                    demoRef.setValue(vidid+"////"+str)
                    //demoRef.child(str).setValue(str)
                }
                if(k.equals("B"))
                {
                    val demoRef: DatabaseReference = rootRef.child("VideoStrings").child("Video1")
                    demoRef.setValue(vidid+"////"+str)
                    //demoRef.child(str).setValue(str)
                }
                if(k.equals("C"))
                {
                    val demoRef: DatabaseReference = rootRef.child("VideoStrings").child("Video2")
                    demoRef.setValue(vidid+"////"+str)
                    //demoRef.child(str).setValue(str)
                }
                Toast.makeText(applicationContext,"Update Done",Toast.LENGTH_SHORT).show()
                editText.setText("")
            }
            else
            {
                Toast.makeText(applicationContext,"Invalid String",Toast.LENGTH_SHORT).show()
                editText.setText("")
            }

        }

    }
}
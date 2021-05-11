package com.example.learningplatformupdation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var v:String=""
        val Buttonbeginer = findViewById<Button>(R.id.button)

        // finding the edit text
        val Buttonintermediate = findViewById<Button> (R.id.button1)

        val Buttonadvanced = findViewById<Button> (R.id.button2)

        //val Buttondelete = findViewById<Button> (R.id.button4)

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference


        Buttonbeginer.setOnClickListener() {
            val demoRef: DatabaseReference = rootRef.child("VideoStrings").child("Video")
            val intent = Intent(this, FetchData::class.java)

            demoRef.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {


                    v = dataSnapshot.getValue().toString();

                    var vidid=v.toString();

                    intent.putExtra("VDID",vidid)
                    var k="A";
                    intent.putExtra("K",k)
                    v=""
                    startActivity(intent)

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(this@MainActivity, "Error fetching data from firebase-Invalid Data Object", Toast.LENGTH_LONG)
                            .show()
                }
            })
        }

        Buttonintermediate.setOnClickListener() {
            val demoRef: DatabaseReference = rootRef.child("VideoStrings").child("Video1")
            val intent = Intent(this, FetchData::class.java)

            demoRef.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {


                    v = dataSnapshot.getValue().toString();

                    var vidid=v.toString();

                    intent.putExtra("VDID",vidid)
                    var k="B";
                    intent.putExtra("K",k)
                    v=""
                    startActivity(intent)

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(this@MainActivity, "Error fetching data from firebase-Invalid Data Object", Toast.LENGTH_LONG)
                            .show()
                }
            })

        }

        Buttonadvanced.setOnClickListener() {
            val demoRef: DatabaseReference = rootRef.child("VideoStrings").child("Video2")
            val intent = Intent(this, FetchData::class.java)

            demoRef.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {


                    v = dataSnapshot.getValue().toString();

                    var vidid=v.toString();

                    intent.putExtra("VDID",vidid)
                    var k="C";
                    intent.putExtra("K",k)
                    v=""
                    startActivity(intent)

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(this@MainActivity, "Error fetching data from firebase-Invalid Data Object", Toast.LENGTH_LONG)
                            .show()
                }
            })
        }

       /* Buttondelete.setOnClickListener() {
            val intent = Intent(this, DeleteAct::class.java)
            startActivity(intent)
        }*/


    }
}
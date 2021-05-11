package com.example.learningplatformupdation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
//Delete particular
class DeleteAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var radioGroup: RadioGroup? = null
        lateinit var radioButton: RadioButton
        lateinit var button: Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        radioGroup = findViewById(R.id.radioGroup)

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference


        val ButtonDel = findViewById<Button> (R.id.delbut)
        val editText = findViewById<EditText> (R.id.editTextstr)

        ButtonDel.setOnClickListener {
            var v1=editText.text.toString();
            if(v1.length==11)
            {
                val selectedOption: Int = radioGroup!!.checkedRadioButtonId
                radioButton = findViewById(selectedOption)

                if(radioButton.text.equals("Beginner"))
                {
                    val demoRef: DatabaseReference = rootRef.child("Trial").child("A")
                    demoRef.child(v1).removeValue()
                }
                else if(radioButton.text.equals("Intermediate"))
                {
                    val demoRef: DatabaseReference = rootRef.child("Trial").child("B")
                    demoRef.child(v1).removeValue()
                }
                else if(radioButton.text.equals("Advanced"))
                {
                    val demoRef: DatabaseReference = rootRef.child("Trial").child("C")
                    demoRef.child(v1).removeValue()
                }
                Toast.makeText(applicationContext,"Done", Toast.LENGTH_SHORT).show()
                editText.setText("")
            }
            else
            {
                Toast.makeText(applicationContext,"Invalid String", Toast.LENGTH_SHORT).show()
                editText.setText("")
            }
        }


    }
}
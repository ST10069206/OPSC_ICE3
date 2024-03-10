package com.example.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView

// creating a custom tag: 
//class CustomTextView @JvmOverloads constructor(
//    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
//) : AppCompatTextView(context, attrs, defStyleAttr) {
//
//    init {
//        // Perform any initialization here
//    }
//}

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNum1:EditText
    private lateinit var editTextNum2:EditText
    private lateinit var textAnswer:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Calculator"
    }

    fun onButtonClick(view: View)
    {
        editTextNum1= findViewById<EditText>(R.id.editTextNumber1)
        editTextNum2=findViewById<EditText>(R.id.editTextNumber2)
        textAnswer = findViewById<TextView>(R.id.editTextAnswer)

        val result :Double
        val num1=editTextNum1.text.toString().toDouble()
        val num2=editTextNum2.text.toString().toDouble()

        when (view.id)
        {
            R.id.btnAdd ->
                {
                    result= num1+num2
                    textAnswer.text= result.toString()
                }
            R.id.btnSubtract-> {
                result = num1 - num2
                textAnswer.text = result.toString()
            }
            R.id.btnMultiply->{
                result=num1*num2
                textAnswer.text=result.toString()
            }
            R.id.btnDivide->{
                if(num2 !=0.0) {
                    result = num1 / num2
                    textAnswer.text = result.toString()
                }
                else{
                    Toast.makeText(this, "Number cannot be zero", Toast.LENGTH_SHORT).show()

                }

            }
            R.id.btnClear->{
                editTextNum2.text.clear()
                editTextNum1.text.clear()
                textAnswer.text=""
            }
        }
    }
}
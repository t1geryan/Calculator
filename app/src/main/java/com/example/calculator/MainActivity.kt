package com.example.calculator

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        // scale animation (look at res/anim/scale.xml)
        val scaleAnim = AnimationUtils.loadAnimation(this,R.anim.scale)

        //Input and Output Fields
        val input = findViewById<TextView>(R.id.input)
        val output = findViewById<TextView>(R.id.output)


        /// add text to math operation input
        fun setTextFields(str: String) {
            if (output.text.isNotEmpty()) {
                input.text = output.text
                output.text = ""
            }
            input.append(str)
        }

        // ALL BUTTONS EXCEPT AC, Back and Result (equal) add their text to the input field

        //Symbol Buttons List
        val btn0 = findViewById<TextView>(R.id.btn_0)
        btn0.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn0.text.toString())
        }
        val btn1 = findViewById<TextView>(R.id.btn_1)
        btn1.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn1.text.toString())
        }
        val btn2 = findViewById<TextView>(R.id.btn_2)
        btn2.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn2.text.toString())
        }
        val btn3 = findViewById<TextView>(R.id.btn_3)
        btn3.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn3.text.toString())
        }
        val btn4 = findViewById<TextView>(R.id.btn_4)
        btn4.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn4.text.toString())
        }
        val btn5 = findViewById<TextView>(R.id.btn_5)
        btn5.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn5.text.toString())
        }
        val btn6 = findViewById<TextView>(R.id.btn_6)
        btn6.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn6.text.toString())
        }
        val btn7 = findViewById<TextView>(R.id.btn_7)
        btn7.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn7.text.toString())
        }
        val btn8 = findViewById<TextView>(R.id.btn_8)
        btn8.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn8.text.toString())
        }
        val btn9 = findViewById<TextView>(R.id.btn_9)
        btn9.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btn9.text.toString())
        }
        val btnDot = findViewById<TextView>(R.id.btn_dot)
        btnDot.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btnDot.text.toString())
        }
        val btnOB = findViewById<TextView>(R.id.btn_oBracket)
        btnOB.setOnClickListener {
            btnOB.startAnimation(scaleAnim)
            setTextFields(btnOB.text.toString())
        }
        val btnCB = findViewById<TextView>(R.id.btn_cBracket)
        btnCB.setOnClickListener {
            btnCB.startAnimation(scaleAnim)
            setTextFields(btnCB.text.toString())
        }
        val btnDiv = findViewById<TextView>(R.id.btn_div)
        btnDiv.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btnDiv.text.toString())
        }
        val btnProd = findViewById<TextView>(R.id.btn_prod)
        btnProd.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btnProd.text.toString())
        }
        val btnSum = findViewById<TextView>(R.id.btn_plus)
        btnSum.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btnSum.text.toString())
        }
        val btnSub = findViewById<TextView>(R.id.btn_sub)
        btnSub.setOnClickListener {
            it.startAnimation(scaleAnim)
            setTextFields(btnSub.text.toString())
        }

        // Action Buttons List
        val btnAC = findViewById<TextView>(R.id.btn_AC)
        btnAC.setOnClickListener { // delete all io fields text
            btnAC.startAnimation(scaleAnim)
            input.text = ""
            output.text = ""
        }
        val btnBack = findViewById<TextView>(R.id.btn_back)
        btnBack.setOnClickListener { // delete last symbol from input field and delete output field text at all
            it.startAnimation(scaleAnim)
            val str = input.text.toString()
            if (str.isNotEmpty())
                input.text = str.substring(0, str.length-1)
            output.text = ""
        }

        val btnRes = findViewById<TextView>(R.id.btn_res)
        btnRes.setOnClickListener {
            it.startAnimation(scaleAnim)
            try {
                // using library exp4j (take string get result)
                val ex = ExpressionBuilder(input.text.toString()).build()
                val result = ex.evaluate()

                //Output of integers without a dot, and double numbers with a dot
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    output.text = longRes.toString()
                else
                    output.text = result.toString()

            } catch (e:Exception) { // if bad input
                Log.d("Error!", "message: ${e.message}")
            }
        }





    }
}


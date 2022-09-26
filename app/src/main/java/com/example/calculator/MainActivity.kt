package com.example.calculator

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

        val scaleAnim = AnimationUtils.loadAnimation(this,R.anim.scale)

        //Input and Output Field
        val input = findViewById<TextView>(R.id.input)
        val output = findViewById<TextView>(R.id.output)

        fun setTextFields(str: String) {
            if (output.text.isNotEmpty()) {
                input.text = output.text
                output.text = ""
            }
            input.append(str)
        }

        // Action Buttons List
        val btnAC = findViewById<TextView>(R.id.btn_AC)
        btnAC.setOnClickListener {
            btnAC.startAnimation(scaleAnim)
            input.text = ""
            output.text = ""
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
        val btnRes = findViewById<TextView>(R.id.btn_res)
        btnRes.setOnClickListener {
            it.startAnimation(scaleAnim)
            try {
                val ex = ExpressionBuilder(input.text.toString()).build()
                val result = ex.evaluate()

                //  Вывод целых чисел без точки, а дробных с точкой
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    output.text = longRes.toString()
                else
                    output.text = result.toString()
            } catch (e:Exception) {
                Log.d("Ошибка!", "сообщение ${e.message}")
            }
        }

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
        val btnBack = findViewById<TextView>(R.id.btn_back)
        btnBack.setOnClickListener {
            it.startAnimation(scaleAnim)
            val str = input.text.toString()
            if (str.isNotEmpty())
                input.text = str.substring(0, str.length-1)
            output.text = ""
        }


    }
}


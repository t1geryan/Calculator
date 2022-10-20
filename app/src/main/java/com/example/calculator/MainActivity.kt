package com.example.calculator

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.roundToLong


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // scale animation (look at res/anim/scale.xml)
        val scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale)

        with(binding.output) {
            setOnLongClickListener {
                copyOutput()
            }
        }
        //Symbol Buttons List
        with(binding.btn0) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn1) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn2) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn3) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn4) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn5) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn6) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn7) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn8) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btn9) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDigitText(this.text.toString())
            }
        }
        with(binding.btnDot) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setDot(this.text.toString())
            }
        }
        with(binding.btnOBracket) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setTextFields(this.text.toString())
            }
        }
        with(binding.btnCBracket) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setTextFields(this.text.toString())
            }
        }
        with(binding.btnDiv) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setSymbolText(this.text.toString())
            }
        }
        with(binding.btnProd) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setSymbolText(this.text.toString())
            }
        }
        with(binding.btnPlus) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setSymbolText(this.text.toString())
            }
        }
        with(binding.btnSub) {
            setOnClickListener {
                startAnimation(scaleAnim)
                setSymbolText(this.text.toString())
            }
        }

        // Action Buttons List
        with(binding.btnAC) {
            setOnClickListener { // delete all io fields text
                startAnimation(scaleAnim)
                binding.input.text = ""
                binding.output.text = ""
            }
        }
        with(binding.btnBack) {
            setOnClickListener {
                startAnimation(scaleAnim)
                back()
            }
        }

        with(binding.btnRes) {
            setOnClickListener {
                startAnimation(scaleAnim)
                calculate()
            }
        }
    }

    private fun setTextFields(str: String) {
        binding.input.append(str)
    }

    private fun setSymbolText(str: String) {
        val input = binding.input.text.toString()
        if ((input.isEmpty()) or ((input.isNotEmpty()) && (input.last() !in "+-/*")))
            setTextFields(str)
        else if ((input.isNotEmpty()) && (input.last() in "+-/*")) {
            binding.input.text = input.substring(0, input.length-1)
            setTextFields(str)
        }
    }
    private fun setDigitText(str: String) {
        setTextFields(str)
        calculate()
    }

    private fun setDot(str: String) {
        val lastInputNumber = binding.input.text.split('+', '-', '/', '*', '(', ')').last()
        if ('.' !in lastInputNumber && binding.input.text.last() !in "+-/*()")
            setTextFields(str)
    }

    private fun back() { // delete last symbol from input field and delete output field text at all
        val str = binding.input.text.toString()
        if (str.isNotEmpty())
            binding.input.text = str.substring(0, str.length - 1)
        calculate()
    }
    private fun calculate() { //  take result from input, calculate and input it in output
        try {
            // using library exp4j (take string get result)
            val ex = ExpressionBuilder(binding.input.text.toString()).build()
            var result = ex.evaluate()

            //Output of integers without a dot, and double numbers with a dot
            val longRes = result.toLong()
            if (result == longRes.toDouble()) {
                val strRes = longRes.toString()
                if (strRes.length > 14)
                    binding.output.text = "..."
                else
                    binding.output.text = strRes
            }
            else {
                val fiveDigitPrecision = 100_000.0
                result = (result * fiveDigitPrecision).roundToLong() / fiveDigitPrecision
                binding.output.text = result.toString()
            }


        } catch (e: Exception) { // if bad input
            Log.d("Error!", "message: ${e.message}")
        }
    }

    private fun copyOutput(): Boolean {
        if (binding.output.text.isNotEmpty()) {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("Calc Result", binding.output.text)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(applicationContext, "Result is copied", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}


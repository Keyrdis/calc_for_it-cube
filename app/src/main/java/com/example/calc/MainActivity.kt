package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    var input: TextView? = null
    var output: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_clear = findViewById<AppCompatButton>(R.id.button_clear)
        input = findViewById(R.id.input)
        output = findViewById(R.id.output)
        val button_bracket_left = findViewById<AppCompatButton>(R.id.button_bracket_left)
        val button_bracket_right = findViewById<AppCompatButton>(R.id.button_bracket_right)
        val button_0 = findViewById<AppCompatButton>(R.id.button_0)
        val button_1 = findViewById<AppCompatButton>(R.id.button_1)
        val button_2 = findViewById<AppCompatButton>(R.id.button_2)
        val button_3 = findViewById<AppCompatButton>(R.id.button_3)
        val button_4 = findViewById<AppCompatButton>(R.id.button_4)
        val button_5 = findViewById<AppCompatButton>(R.id.button_5)
        val button_6 = findViewById<AppCompatButton>(R.id.button_6)
        val button_7 = findViewById<AppCompatButton>(R.id.button_7)
        val button_8 = findViewById<AppCompatButton>(R.id.button_8)
        val button_9 = findViewById<AppCompatButton>(R.id.button_9)
        val button_division = findViewById<AppCompatButton>(R.id.button_division)
        val button_multiply = findViewById<AppCompatButton>(R.id.button_multiply)
        val button_subtraction = findViewById<AppCompatButton>(R.id.button_subtraction)
        val button_addition = findViewById<AppCompatButton>(R.id.button_addition)
        val button_dot = findViewById<AppCompatButton>(R.id.button_dot)
        val button_equals = findViewById<AppCompatButton>(R.id.button_equals)




        button_clear.setOnClickListener {
            input!!.text = ""
            output!!.text = ""
        }

        button_bracket_left.setOnClickListener {
            input!!.text = addToInputText("(")
        }
        button_bracket_right.setOnClickListener {
            input!!.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            input!!.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            input!!.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            input!!.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            input!!.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            input!!.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            input!!.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            input!!.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            input!!.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            input!!.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            input!!.text = addToInputText("9")
        }
        button_division.setOnClickListener {
            input!!.text = addToInputText("÷")
        }
        button_multiply.setOnClickListener {
            input!!.text = addToInputText("×")
        }
        button_subtraction.setOnClickListener {
            input!!.text = addToInputText("-")
        }
        button_addition.setOnClickListener {
            input!!.text = addToInputText("+")
        }
        button_dot.setOnClickListener {
            input!!.text = addToInputText(".")
        }
        button_equals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${input!!.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var exception = input!!.text.replace(Regex("÷"), "/")
        exception = exception.replace(Regex("×"), "*")
        return exception
    }

    private fun showResult() {
        try {
            val exception = getInputExpression()
            val result = Expression(exception).calculate()
            if (result.isNaN()) {
                output!!.text = "Error"
                output!!.setTextColor(ContextCompat.getColor(this, R.color.red))


            } else {
                output!!.text = DecimalFormat("0.######").format(result).toString()
                output!!.setTextColor(ContextCompat.getColor(this, R.color.green))

            }
        } catch (e: Exception) {
            output!!.text = "Error"
            output!!.setTextColor(ContextCompat.getColor(this, R.color.red))

        }
    }
}
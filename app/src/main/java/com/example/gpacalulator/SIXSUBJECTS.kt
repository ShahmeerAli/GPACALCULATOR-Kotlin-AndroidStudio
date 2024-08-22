package com.example.gpacalulator

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SIXSUBJECTS : AppCompatActivity() {
    private lateinit var subject1: EditText
    private lateinit var subject2: EditText
    private lateinit var subject3: EditText
    private lateinit var subject4: EditText
    private lateinit var subject5: EditText
    private lateinit var subject6: EditText
    var sum: Double = 0.0
    val spinnerList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixsubjects)

        subject1 = findViewById(R.id.SixSubject1)
        subject2 = findViewById(R.id.SixSubject2)
        subject3 = findViewById(R.id.SixSubject3)
        subject4 = findViewById(R.id.SixSubject4)
        subject5 = findViewById(R.id.SixSubject5)
        subject6 = findViewById(R.id.SixSubject6)


        val spinnerAdapter = ArrayAdapter<String>(
            this@SIXSUBJECTS,
            android.R.layout.simple_list_item_checked,
            spinnerList
        )
        spinnerList.add("A")
        spinnerList.add("A-")
        spinnerList.add("B")
        spinnerList.add("B-")
        spinnerList.add("C")
        spinnerList.add("C-")
        spinnerList.add("D")
        spinnerList.add("D-")
        spinnerList.add("F")


        val gpa1: Spinner = findViewById(R.id.SixGpa1)
        val gpa2: Spinner = findViewById(R.id.SixGpa2)
        val gpa3: Spinner = findViewById(R.id.SixGpa3)
        val gpa4: Spinner = findViewById(R.id.SixGpa4)
        val gpa5: Spinner = findViewById(R.id.SixGpa5)
        val gpa6:Spinner=findViewById(R.id.SixGpa6)


        gpa1.adapter = spinnerAdapter
        gpa2.adapter = spinnerAdapter
        gpa3.adapter = spinnerAdapter
        gpa4.adapter = spinnerAdapter
        gpa5.adapter = spinnerAdapter
        gpa6.adapter=spinnerAdapter

        val txtResult: TextView = findViewById(R.id.Result6)

        val calculateBt: Button = findViewById(R.id.SixCalculateBt)


        calculateBt.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (subject1.text.isEmpty()
                    || subject4.text.isEmpty()
                    || subject3.text.isEmpty()
                    ||subject5.text.isEmpty()) {
                    Toast.makeText(
                        this@SIXSUBJECTS,
                        "Subjects Section cannot be Empty",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    sum = 0.0
                    CalGpa(gpa1)
                    CalGpa(gpa2)
                    CalGpa(gpa3)
                    CalGpa(gpa4)
                    CalGpa(gpa5)
                    CalGpa(gpa6)

                    val cgpa = sum / 6.0
                    val df = DecimalFormat("#.###")
                    txtResult.text = df.format(cgpa)
                }

            }
        })


    }


    private fun CalGpa(spinner: Spinner) {
        when (spinner.selectedItem.toString()) {
            "A" -> {
                sum += 4.0
            }

            "A-" -> {
                sum += 3.66
            }

            "B" -> {
                sum += 3.33
            }

            "B-" -> {
                sum += 3.01
            }

            "C" -> {
                sum += 2.66
            }

            "C-" -> {
                sum += 2.01
            }

            "D" -> {
                sum += 1.66
            }

            "D-" -> {
                sum += 1.01
            }

            "F" -> {
                sum += 0.0
            }

        }

    }
}
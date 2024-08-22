package com.example.gpacalulator

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Adapter
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
import com.airbnb.lottie.LottieAnimationView
import java.math.RoundingMode

class FiveSubjects : AppCompatActivity() {
    private lateinit var subject1: EditText
    private lateinit var subject2: EditText
    private lateinit var subject3: EditText
    private lateinit var subject4: EditText
    private lateinit var subject5: EditText
    var sum: Double = 0.0


    val spinnerList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_five_subjects)

        subject1 = findViewById(R.id.FSubject1)
        subject2 = findViewById(R.id.FSubject2)
        subject3 = findViewById(R.id.FSubject3)
        subject4 = findViewById(R.id.FSubject4)
        subject5 = findViewById(R.id.FSubject5)


        val spinnerAdapter = ArrayAdapter<String>(
            this@FiveSubjects,
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


        val gpa1: Spinner = findViewById(R.id.FGpa1)
        val gpa2: Spinner = findViewById(R.id.FGpa2)
        val gpa3: Spinner = findViewById(R.id.FGpa3)
        val gpa4: Spinner = findViewById(R.id.FGpa4)
        val gpa5: Spinner = findViewById(R.id.FGpa5)


        gpa1.adapter = spinnerAdapter
        gpa2.adapter = spinnerAdapter
        gpa3.adapter = spinnerAdapter
        gpa4.adapter = spinnerAdapter
        gpa5.adapter = spinnerAdapter

        val txtResult: TextView = findViewById(R.id.Result5)

        val calculateBt: Button = findViewById(R.id.FCalculateBt)


        calculateBt.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                if (subject1.text.isEmpty() || subject4.text.isEmpty() || subject3.text.isEmpty()||subject5.text.isEmpty()) {
                    Toast.makeText(
                        this@FiveSubjects,
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

                    val cgpa = sum / 5.0
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
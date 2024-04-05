package com.oneofone.legacylink


import com.oneofone.legacylink.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    //declare
    private lateinit var btnClear : Button
    private lateinit var btnCheck : Button
    private lateinit var ageInput : EditText
    private lateinit var answerTextView : TextView
    private lateinit var infoTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //initialize

        btnClear = findViewById(R.id.btnClear)
        btnCheck = findViewById(R.id.btnCheck)
        ageInput = findViewById(R.id.ageInput)
        answerTextView = findViewById(R.id.answerTextView)
        infoTextView = findViewById(R.id.infoTextView)

        //Button execution
        btnCheck.setOnClickListener {
            // assigning ageInput as an integer
            val age = ageInput.text.toString().toIntOrNull()
            // creating a range for the list to sit in
            if (age !=null && age in 20..100){

                val figure = when (age){
                    20 -> "Alexander the great"
                    25 -> "Tupac Shakur"
                    27 -> "Steve Irwin"
                    36 -> "Marilyn Monroe"
                    37 -> "Vincent van Gogh"
                    40 -> "Paul Walker"
                    50 -> "Michael Jackson"
                    69 -> "David Bowie"
                    70 -> "Winston Churchill"
                    76 -> "Albert Einstein"
                    80 -> "Marlon Brando"
                    82 -> "Frank Sinatra"
                    86 -> "Nikola Tesla"
                    95 -> "Nelson Mandela"
                    96 -> "Queen Elizabeth"
                    else -> "No historical figure found for age $age"
                }
                answerTextView.text = figure

            } else {
                // clear answerTextView
                answerTextView.text = ""
                Toast.makeText(this, "Please enter a valid age between 20 and 100.", Toast.LENGTH_SHORT).show()
            }
            // setting ageInput to a integer and if fails it will hold  null. this is stored to answer
            val answer = ageInput.text.toString().toIntOrNull()

            if (answer !=null && age in 20..100) {
                // creating a list which numbers are assigned to figures
                val figureinfo = when (age) {
                    20 -> "Alexander the great. He was a Macedonian king and a military leader."
                    25 -> "Tupac Shakur. He was a legendary rapper and actor."
                    27 -> "Steve Irwin. He was a renowned wildlife expert."
                    36 -> "Marilyn Monroe was a iconic Hollywood actress and model."
                    37 -> "Vincent van Gogh was a very influential Dutch painter."
                    40 -> "Paul Walker. He was famous and a beloved Hollywood actor known for his role in the Fast and Furious franchise."
                    50 -> "Michael Jackson. The King of Pop."
                    69 -> "David Bowie was an iconic musician"
                    70 -> "Winston Churchill. He was a great former Prime Minister of the United Kingdom, who led Britain to victory in the second world war."
                    76 -> "Albert Einstein, a theoretical physicist who revolutionized physics"
                    80 -> "Marlon Brando. He was a famous actor and icon"
                    82 -> "Frank Sinatra was a famous singer"
                    86 -> "Nikola Tesla. An inventor and electrical engineer who pioneered electrical power system that provides electricity for homes and buildings"
                    95 -> "Nelson Mandela. He was an anti-apartheid revolutionary and former President of South Africa."
                    96 -> "Queen Elizabeth was the former queen of United Kingdom"
                    else -> ""
                }
                // displaying the list on infoTextView
                infoTextView.text = figureinfo
            } else {
                // infoTextView Clears
                infoTextView.text = ""
            }
            // clears ageInput Field
            ageInput.setText("")
        }
        btnClear.setOnClickListener {
            // clears both answer and info TextView
            infoTextView.text = ""
            answerTextView.text = ""
        }
    }
}
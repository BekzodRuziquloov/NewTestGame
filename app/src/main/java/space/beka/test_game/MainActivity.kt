package space.beka.test_game

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var questions:TextView
    private lateinit var var_1:RadioButton
    private lateinit var var_2:RadioButton
    private lateinit var var_3:RadioButton
    private lateinit var var_4:RadioButton
    private lateinit var answers:Button
    private lateinit var rdg:RadioGroup
    var shart = -1
    var tJavob = 0
    var btnch=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions=findViewById<TextView>(R.id.question)
        var_1=findViewById<RadioButton>(R.id.variant_1)
        var_2=findViewById<RadioButton>(R.id.variant_2)
        var_3=findViewById<RadioButton>(R.id.variant_3)
        var_4=findViewById<RadioButton>(R.id.variant_4)
        answers=findViewById<Button>(R.id.answer)
        rdg=findViewById<RadioGroup>(R.id.radiogroup)
        randomMisolYoz()

        answers.setOnClickListener{
            if (var_1.isChecked) btnch=0
            if (var_2.isChecked) btnch=1
            if (var_3.isChecked) btnch=2
            if (var_4.isChecked) btnch=3
            
            if(btnch==shart){
                Toast.makeText(this, "Tog`ri Javob", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No tog`ri javob", Toast.LENGTH_SHORT).show()
            }
            rdg.clearCheck()
            btnch=-1
            randomMisolYoz()
        }

    }


var number1 = 0
var number2 = 0
var amal = 0

fun randomMisolYoz() {
    number1 = Random.nextInt(20)
    number2 = Random.nextInt(20)
    amal = Random.nextInt(4)
    when (amal) {
        0 -> {
            questions.text = "$number1+$number2"
            tJavob = number1 + number2
        }
        1 -> {
            if (number1 < number2) {
                randomMisolYoz()
                return
            }
            questions.text = "$number1-$number2"
            tJavob = number1 - number2
        }
        2 -> {
            questions.text = "$number1*$number2"
            tJavob = number1 * number2
        }
        3 -> {
            try {
                if (number1 % number2 != 0) {
                    randomMisolYoz()
                    return
                }
                questions.text = "$number1/$number2"
                tJavob = number1 / number2
            } catch (e: Exception) {
                randomMisolYoz()
                return
            }
        }
    }
    randomVariant()
}

    fun randomVariant(){
        var son1 = java.util.Random().nextInt(100)
        var son2 = java.util.Random().nextInt(100)
        var son3 = java.util.Random().nextInt(100)

        shart = java.util.Random().nextInt(4)

        if (son1 != son2 || son2 != son3 || son1 !=tJavob){
            when(shart){
                0-> {
                    var_1.text=tJavob.toString()
                    var_2.text=son1.toString()
                    var_3.text=son2.toString()
                    var_4.text=son3.toString()

                }
                1-> {
                    var_2.text=tJavob.toString()
                    var_1.text=son1.toString()
                    var_3.text=son2.toString()
                    var_4.text=son3.toString()

                }
                2-> {
                    var_3.text=tJavob.toString()
                    var_2.text=son1.toString()
                    var_1.text=son2.toString()
                    var_4.text=son3.toString()

                }
                3-> {
                    var_4.text=tJavob.toString()
                    var_2.text=son1.toString()
                    var_1.text=son2.toString()
                    var_3.text=son3.toString()

                }
            }
        }else{
            randomVariant()
        }

    }
}

package cristobal.ruiz.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0-> Nada, 1->Suma, 2->Resta, 3->Multiplicacion, 4->Division

    lateinit var tv_num1 : TextView
    lateinit var tv_num2 : TextView
    var numero2 : Int = 0
    var oper : Int = 0
    var total : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
    }

    fun pressButtons(view: View){
        var num1: String = tv_num1.text.toString()

        when (view.id){
            R.id.btn0 -> tv_num1.setText(num1 + "0")
            R.id.btn1 -> tv_num1.setText(num1 + "1")
            R.id.btn2 -> tv_num1.setText(num1 + "2")
            R.id.btn3 -> tv_num1.setText(num1 + "3")
            R.id.btn4 -> tv_num1.setText(num1 + "4")
            R.id.btn5 -> tv_num1.setText(num1 + "5")
            R.id.btn6 -> tv_num1.setText(num1 + "6")
            R.id.btn7 -> tv_num1.setText(num1 + "7")
            R.id.btn8 -> tv_num1.setText(num1 + "8")
            R.id.btn9 -> tv_num1.setText(num1 + "9")
        }
    }

    fun clickOperation(view: View){
        numero2 = tv_num1.text.toString().toInt()
        var numero1_text : String = tv_num1.text.toString()
        tv_num1.setText("")
        when(view.id){
            R.id.Suma ->{
                tv_num2.setText(numero1_text + "+")
                oper = 1
            }
            R.id.Resta ->{
                tv_num2.setText(numero1_text + "-")
                oper = 2
            }
            R.id.Mult ->{
                tv_num2.setText(numero1_text + "*")
                oper = 3
            }
            R.id.Division ->{
                tv_num2.setText(numero1_text + "/")
                oper = 4
            }

        }

    }
  /*  fun pressBtn1 (view:View){
        var txt2 : TextView = findViewById(R.id.tv_num2)

        txt2.text = txt2.text.toString() + "1"
    }
    fun pressBtn2 (view:View){
        var txt2: TextView = findViewById(R.id.tv_num2)

        txt2.text = txt2.text.toString() + "2"
    }*/



    fun pressBtnC (view: View){
        var txt1: TextView = findViewById(R.id.tv_num1)
        var txt2: TextView = findViewById(R.id.tv_num2)

        total+= 0

        txt1.text = ""
        txt2.text = ""
    }


}
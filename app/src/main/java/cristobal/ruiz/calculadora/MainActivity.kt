package cristobal.ruiz.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    //0-> Nada, 1->Suma, 2->Resta, 3->Multiplicacion, 4->Division

    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView
    var numero1: Double = 0.0
    var oper: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar: Button = findViewById(R.id.btnC)
        var btnigual: Button = findViewById(R.id.btnIgual)

        btnigual.setOnClickListener {
            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when (oper) {
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }
            tv_num2.setText(resp.toString())
            tv_num1.setText("")
        }

        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }
    }

    fun pressButtons(view: View) {
        var num2: String = tv_num2.text.toString()

        when (view.id) {
            R.id.btn0 -> tv_num2.setText(num2 + "0")
            R.id.btn1 -> tv_num2.setText(num2 + "1")
            R.id.btn2 -> tv_num2.setText(num2 + "2")
            R.id.btn3 -> tv_num2.setText(num2 + "3")
            R.id.btn4 -> tv_num2.setText(num2 + "4")
            R.id.btn5 -> tv_num2.setText(num2 + "5")
            R.id.btn6 -> tv_num2.setText(num2 + "6")
            R.id.btn7 -> tv_num2.setText(num2 + "7")
            R.id.btn8 -> tv_num2.setText(num2 + "8")
            R.id.btn9 -> tv_num2.setText(num2 + "9")
        }
    }

    fun clickOperation(view: View) {
        numero1 = tv_num2.text.toString().toDouble()
        var numero2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when (view.id) {
            R.id.Suma -> {

                tv_num1.setText(numero2_text + "+")
                oper = 1
            }

            R.id.Resta -> {
                tv_num1.setText(numero2_text + "-")
                oper = 2
            }

            R.id.Mult -> {
                tv_num1.setText(numero2_text + "*")
                oper = 3
            }

            R.id.Division -> {
                tv_num1.setText(numero2_text + "/")
                oper = 4
            }

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






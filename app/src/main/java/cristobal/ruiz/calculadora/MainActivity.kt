package cristobal.ruiz.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;




class MainActivity : AppCompatActivity() {
    //0-> Nada, 1->Suma, 2->Resta, 3->Multiplicacion, 4->Division

    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId: String
    private var isFlashOn = false


    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView
    var numero1: Double = 0.0
    var oper: Int = 0
    lateinit var btnigual: Button
    var especial: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Verificar si el dispositivo tiene cámara con flash
        val packageManager = packageManager
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // Tu dispositivo no tiene flash, realiza alguna acción apropiada
            // o muestra un mensaje de error.
        }

        // Inicializar el administrador de la cámara
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

        // Obtener el ID de la cámara trasera con flash
        try {
            cameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        val toggleButton = findViewById<Button>(R.id.toggleButton)
        toggleButton.setOnClickListener(View.OnClickListener {
            try {
                if (isFlashOn) {
                    // Apagar la linterna
                    cameraManager.setTorchMode(cameraId, false)
                    isFlashOn = false
                    toggleButton.text = "Encender Linterna"
                } else {
                    // Encender la linterna
                    cameraManager.setTorchMode(cameraId, true)
                    isFlashOn = true
                    toggleButton.text = "Apagar Linterna"
                }
            } catch (e: CameraAccessException) {
                e.printStackTrace()
            }
        })





    tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar: Button = findViewById(R.id.btnC)
        btnigual = findViewById(R.id.btnIgual)

        btnigual.setOnClickListener {
            val numero2Text = tv_num2.text.toString()
            val numero2 = numero2Text.toDoubleOrNull()

            if (numero2 != null) {
                var resp: Double = 0.0

                when (oper) {
                    1 -> resp = numero1 + numero2
                    2 -> resp = numero1 - numero2
                    3 -> resp = numero1 * numero2
                    4 -> {
                        if (numero2 != 0.0) {
                            resp = numero1 / numero2
                        } else {
                            resp = Double.NaN // Nan me permite mostrar un resultado no valido
                        }
                    }
                }

                val resultadoFormateado = mostrarNumero(resp)
                tv_num2.text = resultadoFormateado
                tv_num1.text = ""
            }
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
        val s = "+"
        val r = "-"
        val m = "*"
        val d = "/"
        if (tv_num1.text.contains(s) || tv_num1.text.contains(r) || tv_num1.text.contains(m) || tv_num1.text.contains(d)){
                val numero2Text = tv_num2.text.toString()
                val numero2 = numero2Text.toDoubleOrNull()

                if (numero2 != null) {
                    var resp: Double = 0.0

                    when (oper) {
                        1 -> resp = especial + numero2
                        2 -> resp = especial - numero2
                        3 -> resp = especial * numero2
                        4 -> {
                            if (numero2 != 0.0) {
                                resp = especial / numero2

                            } else {
                                resp = Double.NaN // Nan me permite mostrar un resultado no valido
                            }
                        }

                    }
                    especial = 0.0
                    val resultadoFormateado = mostrarNumero(resp)
                    tv_num2.text = resultadoFormateado
                    tv_num1.text = ""
                }

        }else{
            especial = tv_num2.text.toString().toDouble()
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

    fun mostrarNumero(numero: Double): String {
        if (numero.isNaN()) {
            return "Error"
        }
        return if (numero % 1 == 0.0) {
            numero.toInt().toString()
        } else {
            numero.toString()
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






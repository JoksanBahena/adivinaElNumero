package utez.edu.adivinarelnumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var intentos = 0
    var numero = (1..101).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtIntentos = findViewById<TextView>(R.id.txtIntentos)
        val txtResuelto = findViewById<TextView>(R.id.txtResuelto)
        val edtValor = findViewById<EditText>(R.id.edtValor)
        val btnAdivinar = findViewById<Button>(R.id.btnAdivinar)
        val btnRendirse = findViewById<Button>(R.id.btnRendirse)
        val btnInicar = findViewById<Button>(R.id.btnIniciar)

        btnAdivinar.isEnabled = false
        btnRendirse.isEnabled = false

        btnInicar.setOnClickListener {
            btnAdivinar.isEnabled = true
            btnRendirse.isEnabled = true
            numero = (1..101).random()
            intentos = 10
            txtResuelto.text = getString(R.string.str_AdivinaElNumero)
            txtIntentos.text = intentos.toString()
            edtValor.text = null

        }

        btnAdivinar.setOnClickListener {
            val verificar = edtValor.text.toString()

            if (verificar == "") {
                txtResuelto.text = getString(R.string.str_NoHayNada)

            }else {
                val valor = verificar.toInt()

                if (intentos == 0) {
                    txtResuelto.text = getString(R.string.str_seAcabaronLosIntentos)
                    txtIntentos.text = getString(R.string.str_ElNumeroEra) + numero
                    btnAdivinar.isEnabled = false
                    btnRendirse.isEnabled = false
                    edtValor.text = null

                } else if (valor == numero) {
                    txtResuelto.text = getString(R.string.str_FelicidadesAdivinasteElNumero)
                    txtIntentos.text = getString(R.string.str_PresioneParaJugar)
                    btnAdivinar.isEnabled = false
                    btnRendirse.isEnabled = false

                } else if (valor > numero) {
                    txtResuelto.text = getString(R.string.str_ElNumeroEsMenor)
                    intentos--
                    txtIntentos.text = intentos.toString()

                } else if (valor < numero) {
                    txtResuelto.text = getString(R.string.str_ElNumeroEsMayor)
                    intentos--
                    txtIntentos.text = intentos.toString()
                }
            }
            edtValor.text = null
        }

        btnRendirse.setOnClickListener {
            txtIntentos.text = getString(R.string.str_QueMal)
            txtResuelto.text = getString(R.string.str_ElNumeroEra) + numero
            btnAdivinar.isEnabled = false
            btnRendirse.isEnabled = false
            edtValor.text = null

        }

    }
}
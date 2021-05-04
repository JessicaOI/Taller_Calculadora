package com.example.tallercalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0 //me idica la operación, 0 = no hay

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //asignamos las funciones a cada numero para que lo concatene en pantalla
        unoB.setOnClickListener{numeroPresionado("1")}
        dosB.setOnClickListener{numeroPresionado("2")}
        tresB.setOnClickListener{numeroPresionado("3")}
        cuatroB.setOnClickListener{numeroPresionado("4")}
        cincoB.setOnClickListener{numeroPresionado("5")}
        seisB.setOnClickListener{numeroPresionado("6")}
        sieteB.setOnClickListener{numeroPresionado("7")}
        ochoB.setOnClickListener{numeroPresionado("8")}
        nueveB.setOnClickListener{numeroPresionado("9")}
        ceroB.setOnClickListener{numeroPresionado("0")}
    //asignamos la operación a cada boton correspondiente
        sumaB.setOnClickListener{(opPresionada(suma))}
        menosB.setOnClickListener{(opPresionada(resta))}
        multiplicarB.setOnClickListener{(opPresionada(multi))}
        divisionB.setOnClickListener{(opPresionada(division))}
        //resto de botones
        clearB.setOnClickListener()
        {
            num1 = 0.0
            num2 = 0.0
            pantalla.text = "0"
            operacion = noOperarcion;
        }

        igualB.setOnClickListener()
        {
            var resultado = when(operacion)
            {
                suma -> num1+num2
                resta -> num1-num2
                multi -> num1*num2
                division -> num1/num2
                else ->0

            }

            pantalla.text = resultado.toString();
        }
    }

    private fun numeroPresionado(digito:String)
    {
        pantalla.text = "${pantalla.text}$digito" //el texto concatenado con el otro texto
        //para guardar el primer y segundo numero
        if(operacion == noOperarcion)
        {
            num1 = pantalla.text.toString().toDouble()
        }
        else
        {
            num2 = pantalla.text.toString().toDouble()
        }

    }

    private fun opPresionada(operacion:Int)
    {
        //primero guardar la concatenación de todos los números en pantalla
        this.operacion = operacion

        //ya no se necesita porque ahora se valida más arriba y asi lograr guardar el segundo numero en otra variable
        //num1 = pantalla.text.toString().toDouble()

        pantalla.text = "0";
    }

    //declarar constantes
    companion object
    {
        const val suma = 1
        const val resta = 2
        const val multi = 3
        const val division = 4
        const val noOperarcion = 0
    }
}
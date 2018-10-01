package com.example.adri.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    var datos=""
    var operacion="+"
    var datos2=""
    var datos3=""
    var memoria=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1.setOnClickListener(){
            datos+="1"
            screen.setText(datos)
        }
        b2.setOnClickListener(){
            datos+="2"
            screen.setText(datos)
        }
        b3.setOnClickListener(){
            datos+="3"
            screen.setText(datos)
        }
        b4.setOnClickListener(){
            datos+="4"
            screen.setText(datos)
        }
        b5.setOnClickListener(){
            datos+="5"
            screen.setText(datos)
        }
        b5.setOnClickListener(){
            datos+="5"
            screen.setText(datos)
        }
        b6.setOnClickListener(){
            datos+="6"
            screen.setText(datos)
        }
        b7.setOnClickListener(){
            datos+="7"
            screen.setText(datos)
        }
        b8.setOnClickListener(){
            datos+="8"
            screen.setText(datos)
        }
        b9.setOnClickListener(){
            datos+="9"
            screen.setText(datos)
        }
        b0.setOnClickListener(){
            datos+=0;
            screen.setText(datos)
        }
        sum.setOnClickListener {
            datos2=datos
            datos=""
            screen.setText(datos2+"+")
            operacion="+"
        }
        res.setOnClickListener(){
            datos2=datos
            datos=""
            screen.setText(datos2+"-")
            operacion="-"
        }
        mul.setOnClickListener(){
            datos2=datos
            datos=""
            screen.setText(datos2+"x")
            operacion="x"
        }
        div.setOnClickListener(){
            datos2=datos
            datos=""
            screen.setText(datos2+"/")
            operacion="/"
        }
        mem.setOnClickListener(){
            if(memoria=="") {
                memoria = screen.text.toString();
            }else{
                screen.setText(memoria.toString());
            }
        }
        coma.setOnClickListener(){
            datos+="."
        }
        del.setOnClickListener(){
            if(screen.text.toString()==""){
                datos=""
                screen.setText(datos)
            }else {
                var datBorr = screen.text
                val ult = datBorr.length
                var newDat = datBorr.substring(0, ult - 1)
                datos = newDat
                screen.setText(datos)
            }
        }

        //comentario
        ce.setOnClickListener(){
            datos=""
            datos2=""
            screen.setText(datos.toString())
        }
        memPlus.setOnClickListener(){
            datos2=memoria
            screen.setText(datos2+"+")
            operacion="+"
        }
        exec.setOnClickListener(){
            if(datos2=="") datos2="0"
            when(operacion){
                "+" -> screen.setText((datos2.toDouble()+datos.toDouble()).toString());
                "-" -> screen.setText((datos2.toDouble()-datos.toDouble()).toString());
                "x" -> screen.setText((datos2.toDouble()*datos.toDouble()).toString());
                "/" -> screen.setText((datos2.toDouble()/datos.toDouble()).toString());
            }
            datos=screen.text.toString()
        }
    }

    fun execute(){
        if(datos2=="") datos2="0"
        when(operacion){
            "+" -> screen.setText((datos2.toDouble()+datos.toDouble()).toString());
            "-" -> screen.setText((datos2.toDouble()-datos.toDouble()).toString());
            "x" -> screen.setText((datos2.toDouble()*datos.toDouble()).toString());
            "/" -> screen.setText((datos2.toDouble()/datos.toDouble()).toString());
        }
        datos=screen.text.toString()
    }
}

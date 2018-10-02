package com.example.adri.calculadora

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Long.parseLong

class MainActivity : AppCompatActivity() {

    var datos=""
    var operacion=""
    var datos2=""
    var datos3: Long = 0
    var memoria=""
    var operacionHex=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val orientation=getResources().getConfiguration().orientation
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            calHex();
        }else{
            calDec();
        }
    }

    fun execHex(hex1: Long,hex2: Long){
        when(operacionHex){
            "+" -> datos3=(hex1+hex2)
            "-" -> datos3=(hex1-hex2)
            "x" -> datos3=(hex1*hex2)
            "/" -> datos3=(hex1/hex2)
        }
        var hexString=java.lang.Long.toHexString(datos3)
        resulText.text = hexString
    }

    fun hex2dec(hex: String): Long {
        return parseLong(hex,16)
    }


    @SuppressLint("SetTextI18n")
    fun calHex(){
        hexSum.setOnClickListener(){
            operacionHex="+"
            execHex(hex2dec(num1text.text.toString()), hex2dec(num2text.text.toString()))

        }
        hexRes.setOnClickListener(){
            operacionHex="-"
            execHex(hex2dec(num1text.text.toString()), hex2dec(num2text.text.toString()))

        }
        hexMul.setOnClickListener(){
            operacionHex="x"
            execHex(hex2dec(num1text.text.toString()), hex2dec(num2text.text.toString()))
        }
        hexDiv.setOnClickListener() {
            operacionHex="/"
            try {
                execHex(hex2dec(num1text.text.toString()), hex2dec(num2text.text.toString()))
            }catch(e: ArithmeticException){
                resulText.text="No se puede dividir por 0"
            }

        }
    }

    fun calDec(){
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
}

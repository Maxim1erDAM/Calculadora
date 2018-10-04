package com.example.adri.calculadora

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
    var memoriaHex=""
    var operacionHex=""
    var datosHex=""
    var datosHex2=""
    var hexDec1: Long=0
    var hexDec2: Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val orientation=resources.configuration.orientation
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            calHex()
        }else{
            calDec()
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
        datosHex= resulText.text.toString()
    }

    fun hex2dec(hex: String): Long {
        return parseLong(hex,16)
    }

    fun calHex(){
        b0Hex.setOnClickListener(){
            datosHex+="0"
            resulText.setText(datosHex)
        }
        b1Hex.setOnClickListener(){
            datosHex+="1"
            resulText.setText(datosHex)

        }
        b2Hex.setOnClickListener(){
            datosHex+="2"
            resulText.setText(datosHex)
        }
        b3Hex.setOnClickListener(){
            datosHex+="3"
            resulText.setText(datosHex)
        }
        b4Hex.setOnClickListener(){
            datosHex+="4"
            resulText.setText(datosHex)
        }
        b5Hex.setOnClickListener(){
            datosHex+="5"
            resulText.setText(datosHex)
        }
        b6Hex.setOnClickListener(){
            datosHex+="6"
            resulText.setText(datosHex)
        }
        b7Hex.setOnClickListener(){
            datosHex+="7"
            resulText.setText(datosHex)
        }
        b8Hex.setOnClickListener(){
            datosHex+="8"
            resulText.setText(datosHex)
        }
        b9Hex.setOnClickListener(){
            datosHex+="9"
            resulText.setText(datosHex)
        }
        bA.setOnClickListener {
            datosHex+="A"
            resulText.setText(datosHex)
        }
        bB.setOnClickListener {
            datosHex+="B"
            resulText.setText(datosHex)
        }
        bC.setOnClickListener {
            datosHex+="C"
            resulText.setText(datosHex)
        }
        bD.setOnClickListener {
            datosHex+="D"
            resulText.setText(datosHex)
        }
        bE.setOnClickListener {
            datosHex+="E"
            resulText.setText(datosHex)
        }
        bF.setOnClickListener {
            datosHex+="F"
            resulText.setText(datosHex)
        }
        sumHex.setOnClickListener(){
            operacionHex="+"
            datosHex2=datosHex
            datosHex=""
            resulText.text=datosHex2+"+"
        }
        resHex.setOnClickListener(){
            operacionHex="-"
            datosHex2=datosHex
            datosHex=""
            resulText.text=datosHex2+"-"
        }
        mulHex.setOnClickListener(){
            operacionHex="x"
            datosHex2=datosHex
            datosHex=""
            resulText.text=datosHex2+"x"
        }
        divHex.setOnClickListener() {
            operacionHex="/"
            datosHex2=datosHex
            datosHex=""
            resulText.text=datosHex2+"/"
        }
        memHex.setOnClickListener(){
            if(memoriaHex=="") {
                memoriaHex = resulText.text.toString()
            }else{
                resulText.text = memoriaHex
            }
        }
        memPlusHex.setOnClickListener(){
            datosHex2=memoriaHex
            resulText.text = datosHex2+"+"
            operacionHex="+"
        }
        delHex.setOnClickListener(){
            if(resulText.text.toString()==""){
                datosHex=""
                resulText.setText(datosHex)
            }else {
                var datBorrHex = resulText.text
                val ultHex = datBorrHex.length
                var newDatHex = datBorrHex.substring(0, ultHex - 1)
                datosHex = newDatHex
                resulText.setText(datosHex)
            }
        }
        ceHex.setOnClickListener(){
            datosHex=""
            datosHex2=""
            resulText.setText(datosHex)
        }
        execHex.setOnClickListener(){
            if(datosHex2=="") datosHex2="0"
            try {
                execHex(hex2dec(datosHex2),hex2dec(datosHex))
            }catch (e: ArithmeticException){
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

package mx.edu.ittepic.ladm_u2_t2

import android.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class HiloControl (p:MainActivity) : Thread(){
    private var iniciado = false
    private var puntero = p
    var pausa = false
    private var minutos=0
    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){

            if(!pausa){
                sleep(1000)
                puntero.runOnUiThread {
                    puntero.tiempo.text = ""+minutos+":"+puntero.contador
                    puntero.contador++
                    if(puntero.contador==60){
                        puntero.contador=0
                        minutos++
                    }
                }
            }
        }

    }

    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }
}
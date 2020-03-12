package mx.edu.ittepic.ladm_u2_t2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var contador=0
    var hilo: HiloControl? = null
    private var mediaPlayer:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mediaPlayer = MediaPlayer.create(this,R.raw.blink)
        hilo= HiloControl(this)
        button2.setOnClickListener {
            hilo!!.start()
        }
        button3.setOnClickListener {
            if(!hilo!!.estaIniciado()){
                AlertDialog.Builder(this).setMessage("No se está reproduciendo canción").show()
                return@setOnClickListener
            }
            if(hilo!!.estaIniciado()){
                if(hilo!!.pausa){
                    hilo!!.despausar()
                    return@setOnClickListener
                }
                if(!hilo!!.pausa){
                    hilo!!.pausar()
                    return@setOnClickListener
                }
            }
        }
        button4.setOnClickListener {
            if(!hilo!!.estaIniciado()){
                AlertDialog.Builder(this).setMessage("No hay canción que detener").show()
                return@setOnClickListener
            }
            hilo!!.detener()
        }
    }
}

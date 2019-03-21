package com.example.logonrmlocal.maps

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mapa_via_intent.*

class MapaViaIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_via_intent)

        btExbirLocal.setOnClickListener {
            val latitudeLongitude = "-23.5565804, -46.662113"
            val zoom= 15
            val geo = "geo:$latitudeLongitude?z=$zoom"

            exibirNoMapa(geo)





        }
                btExibirRota.setOnClickListener {

                    val endereco = "Rua João Cabral de Melo Neto,  186 São Paulo, São Paulo, Brasil"
                    val localizacao = Uri.encode(endereco)
                    val modo = "w"
                    val zoom= 21
                    val geo = "google.navigation:q=$localizacao&mode=$modo&z=$zoom"
                    exibirNoMapa(geo)
                }


        btExbirLocal.setOnClickListener {
            val latitudeLongitude = "-23.5565804, -46.662113"
            val zoom= 15
            val geo = "geo:$latitudeLongitude?z=$zoom"

            exibirNoMapa(geo)





        }


    }

    fun exibirNoMapa(geo: String) {

        val geoURI = Uri.parse(geo)
        val intent = Intent(Intent.ACTION_VIEW, geoURI)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)

    }
}

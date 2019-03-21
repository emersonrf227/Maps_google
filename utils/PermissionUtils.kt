package com.example.logonrmlocal.maps.utils

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.example.logonrmlocal.maps.MapsActivity

object PermissionUtils {

    fun validarPermissoes(permissioes: List<String>, activity: Activity, requestCode: Int) : Boolean{


        val listaPermissoes = ArrayList<String>()

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){


            for(permissao in permissioes ){

                val temPermissao = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED
                if(!temPermissao) listaPermissoes.add(permissao)


            }



            if(listaPermissoes.isEmpty()) return true
            else {

                ActivityCompat.requestPermissions(activity,
                        listaPermissoes.toTypedArray(), requestCode)


            }

        }

        return  true


    }


}
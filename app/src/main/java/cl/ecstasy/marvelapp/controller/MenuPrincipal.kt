package cl.ecstasy.marvelapp.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.ecstasy.marvelapp.R
import kotlinx.android.synthetic.main.menu_principal.*

class MenuPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_principal)

        bt_informacion.setOnClickListener({

            Toast.makeText(this, "holiiii chanchete", Toast.LENGTH_SHORT).show()

        })
    }
}

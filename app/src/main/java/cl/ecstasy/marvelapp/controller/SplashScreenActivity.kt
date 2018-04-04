package cl.ecstasy.marvelapp.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import cl.ecstasy.marvelapp.R

class SplashScreenActivity : AppCompatActivity() {
    private val Splash_Screen = 2000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Ventana Inicial o Splash Screen
        Handler().postDelayed({
            startActivity(Intent(this, MenuPrincipal::class.java))
            finish()
        }, Splash_Screen.toLong())
    }

}

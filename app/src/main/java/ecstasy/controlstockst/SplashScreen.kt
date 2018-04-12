package ecstasy.controlstockst

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private var Splash_Screen = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Ventana Inicial o Splash Screen
        Handler().postDelayed({
            startActivity(Intent(this, Login::class.java))
            finish()
        }, Splash_Screen.toLong())
    }
}

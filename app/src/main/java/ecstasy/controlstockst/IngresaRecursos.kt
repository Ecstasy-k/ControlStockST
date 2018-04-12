package ecstasy.controlstockst

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ingresa_recursos.*

class IngresaRecursos : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nv_ingresaRecursos -> {
                message.setText(R.string.title_activity_ingresa_recursos)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nv_registraUso -> {
                message.setText(R.string.title_activity_registra_uso)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nv_consultaRecursos -> {
                message.setText(R.string.title_consulta_recursos)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nv_consultaHistorial -> {
                message.setText(R.string.title_consulta_historial)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nv_cerrarSesion -> {
                message.setText(R.string.title_cerrar_sesion)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresa_recursos)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}

package ecstasy.controlstockst

import android.app.LoaderManager
import android.content.Loader
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresa_recursos.*
import kotlinx.android.synthetic.main.activity_menu_principal.*
import org.ksoap2.serialization.SoapObject

class MenuPrincipal : AppCompatActivity() /*, LoaderManager.LoaderCallbacks<List<String>> */{

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

    private var tu = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val intentt = intent
        val extrax = Bundle(intentt.extras)
        tu = extrax.getInt("Sesion_val")
        tv_user.setText(extrax.getString("usuarioNombre") + extrax.getString("usuarioRut"))
        Toast.makeText(this, "El tipo de usuario es de número: $tu", Toast.LENGTH_SHORT).show()


    }

   /* override fun onCreateLoader(id: Int, args: Bundle?): Loader<List<String>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadFinished(loader: Loader<List<String>>?, data: List<String>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoaderReset(loader: Loader<List<String>>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    } */



}

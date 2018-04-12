package ecstasy.controlstockst

import android.app.LoaderManager
import android.content.Loader
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu_principal.*
import org.ksoap2.serialization.SoapObject

class MenuPrincipal : AppCompatActivity(), LoaderManager.LoaderCallbacks<List<String>> {


    private var tu = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        val intentt = intent
        val extrax = Bundle(intentt.extras)
        tu = extrax.getInt("Sesion_val")
        tv_user.setText(extrax.getString("usuarioNombre") + extrax.getString("usuarioRut"))
        Toast.makeText(this, "El tipo de usuario es de número: $tu", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<List<String>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadFinished(loader: Loader<List<String>>?, data: List<String>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoaderReset(loader: Loader<List<String>>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}

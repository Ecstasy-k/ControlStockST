package ecstasy.controlstockst

import android.app.LoaderManager
import android.content.Loader
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.ksoap2.serialization.SoapObject

class MenuPrincipal : AppCompatActivity(), LoaderManager.LoaderCallbacks<List<String>> {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

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

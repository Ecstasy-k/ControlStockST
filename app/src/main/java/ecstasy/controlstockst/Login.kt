package ecstasy.controlstockst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE
import java.io.PrintWriter
import java.io.StringWriter
import android.os.StrictMode



class Login : AppCompatActivity() {

    private val NAMESPACE = "http://tempuri.org/"
    private val METHOD_NAME = "LoginWM"

    private val SOAP_ACTION = "http://tempuri.org/LoginWM"

    private val URL = "http://190.121.13.170/WSStock/Service.asmx?WSDL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       //POliticas de seguridad, pruebas
        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }


        bt_login.setOnClickListener({
            login(et_usuario.text.toString(), et_passwd.text.toString())

        })
    }

     private fun login(user: String, pass: String)
    {
        Toast.makeText(this, "Variables $user , $pass", Toast.LENGTH_SHORT).show()
        val request = SoapObject(NAMESPACE, METHOD_NAME)
        request.addProperty("userWM", user)
        request.addProperty("passwordWM", pass)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request)

        val transporte = HttpTransportSE(URL)

        try
        {
            transporte.call(SOAP_ACTION, envelope)
            val resultado_xml = envelope.response
            val siOno = resultado_xml.toString()
            txt_resultado.text = "Proceso con éxito, el valor obtenido es: $siOno"
        }
        catch (e:Exception)
        {
            val sw = StringWriter()
            e.printStackTrace(PrintWriter(sw))
            val exceptionasstring = sw.toString()

            txt_resultado.text = "ERROR!" + exceptionasstring
        }
    }
}

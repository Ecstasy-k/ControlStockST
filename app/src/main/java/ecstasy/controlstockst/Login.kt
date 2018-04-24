package ecstasy.controlstockst

import android.content.Intent
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
    private val METHOD_NAME = "UserFullWM"

    private val SOAP_ACTION = "http://tempuri.org/UserFullWM"

    private val URL = "http://190.121.13.170/WSStock/Service.asmx?WSDL"

    var tipoUser : Int = 0
    var nombreUser : String = ""
    var rutUser : String = ""

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
     //   Toast.makeText(this, "Variables $user , $pass", Toast.LENGTH_SHORT).show()
        val request = SoapObject(NAMESPACE, METHOD_NAME)
        request.addProperty("userWM", user)
        request.addProperty("passWM", pass)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request)

        val transporte = HttpTransportSE(URL)

        try
        {
            transporte.call(SOAP_ACTION, envelope)
            val resultado_xml = envelope.response
            val datosUser = resultado_xml.toString()
            if (datosUser.compareTo("error") != 0) {

                val datillos = datosUser.split(",")

                nombreUser = datillos.get(0)
                tipoUser = datillos.get(1).trim().toInt()
                rutUser = datillos.get(2).trim()
            }
            if (tipoUser > 0)
            {
                Toast.makeText(this, "BIENVENIDO $nombreUser!!", Toast.LENGTH_SHORT).show()
                txt_resultado.text = ""
                val intent = Intent(this, MenuPrincipal::class.java)
                intent.putExtra("Sesion_val", tipoUser)
                intent.putExtra("usuarioNombre", nombreUser)
                intent.putExtra("usuarioRut", rutUser)
                startActivity(intent)
            }
            else
            {
                txt_resultado.text = "Usuario y contraseña NO VÁLIDOS"
                et_usuario.setText("")
                et_passwd.setText("")

            }
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

package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.insertar_gasto_fragment.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsertar.setOnClickListener() {
            var fecha = edtFecha.text
            var id_casa = edtCasa.text
            var motivo = edtMotivo.text
            var producto = edtProducto.text
            var cantidad = edtCantidad.text
            var unidad_medida = edtUM.text
            var costo = edtCosto.text
            var estatus = edtEstatus.text
            var pago = edtPago.text

            val queue = Volley.newRequestQueue(this)
            val url = "https://bienesraicesguzman.com/l/insertar_gasto.php?fecha='$fecha'&id_casa=$id_casa&motivo='$motivo'&producto='$producto'&cantidad=$cantidad&unidad_medida='$unidad_medida'&costo=$costo&estatus='$estatus'&pago='$pago'"

            val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
                Toast.makeText(applicationContext,"Gasto registrado correctamente",Toast.LENGTH_LONG).show()
            },Response.ErrorListener { error ->})
            queue.add(stringRequest)
        }
    }
}

/**BUSCAR TABLAS COMPLETAS
 * btnInsertar.setOnClickListener() {
    val queue = Volley.newRequestQueue(this)
    val url = "https://bienesraicesguzman.com/l/buscar_gasto.php"

    val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
        val jsonArray = JSONArray(response)
        val jsonObject = jsonArray
        var text = jsonObject
        Toast.makeText(applicationContext,text.toString(),Toast.LENGTH_LONG).show()
    },Response.ErrorListener { error ->})
    queue.add(stringRequest)
}**/

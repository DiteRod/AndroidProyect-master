package cl.uach.inf.bachimovil;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ForumFormulario extends AppCompatActivity {
    TextView result;
    EditText titulo, descripcion, taqs;
    Button insert, two;
    JSONArray arr = new JSONArray();
    RequestQueue requestQueue;
    String insertUrl = "http://192.168.0.2/cursoPHP/insertStudent.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_formulario);
        titulo = (EditText) findViewById(R.id.title_a);
        descripcion =(EditText) findViewById(R.id.descripcion_a);
        taqs =(EditText) findViewById(R.id.taqs_a);
        insert = (Button) findViewById(R.id.insertar_a);
        requestQueue = Volley.newRequestQueue(getApplicationContext());



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("titulo",titulo.getText().toString());
                        parameters.put("descripcion",descripcion.getText().toString());
                        parameters.put("taqs",taqs.getText().toString());

                        return parameters;
                    }
                };
                requestQueue.add(request);
                Intent detail = new Intent(ForumFormulario.this, Main.class);
                startActivity(detail);

            }

        });

    }
    /*public void Foro(View view){
        Intent detail = new Intent(ForumFormulario.this, Main.class);
        startActivity(detail);
        finish();
    }*/
}

    /*public void InsertarDatos(View view) {
        String num = "1";
        String tituloa = titulo.getText().toString();
        String descripa = descripcion.getText().toString();
        String taq = taqs.getText().toString();
        try {
            JSONObject obj = new JSONObject();
            obj.put("id_post","1");
            obj.put("titulo", tituloa);
            obj.put("descripcion", descripa);
            obj.put("taqs",taq);
            arr.put(obj);

        } catch (JSONException e) {}
        result.setText(arr.toString());
        try {
            FileOutputStream fos = view.getContext().openFileOutput("Post.json", Context.MODE_PRIVATE);
            fos.write(arr.toString().getBytes(), 0, arr.toString().length());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/




    /*public void foro(View view) {
        Toast.makeText(getApplicationContext(), "TOOOASt", Toast.LENGTH_SHORT).show();
    }*/








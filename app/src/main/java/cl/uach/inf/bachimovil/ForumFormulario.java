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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;

public class ForumFormulario extends AppCompatActivity {
    TextView result;
    EditText titulo, descripcion, taqs;
    Button insert, two;
    JSONArray arr = new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_formulario);
        titulo = (EditText) findViewById(R.id.title_a);
        descripcion =(EditText) findViewById(R.id.descripcion_a);
        taqs =(EditText) findViewById(R.id.taqs_a);
        result =(TextView) findViewById(R.id.texto);
    }

    public void InsertarDatos(View view) {
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
    }

    public void foro(View view) {
        Toast.makeText(getApplicationContext(), "TOOOASt", Toast.LENGTH_SHORT).show();
    }
    public void Foro(View view){
        startActivity(new Intent(view.getContext(),CursosActivity.class));
    }

}





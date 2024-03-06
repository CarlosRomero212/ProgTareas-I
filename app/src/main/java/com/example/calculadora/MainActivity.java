package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("Gestion").setIndicator("Gestion", null).setContent(R.id.Gestion));
        tbh.addTab(tbh.newTabSpec("lista").setIndicator("lista", null).setContent(R.id.Lista));
        tbh.addTab(tbh.newTabSpec("Buscar").setIndicator("Buscar", null).setContent(R.id.Buscar));

        public class DB extends SQLiteOpenHelper {
            private static final String dbname = "amigos";
            private static final int v =1;
            private static final String SQLdb = "CREATE TABLE amigos(idAmigo integer primary key autoincrement, nombre text, direccion text, telefono text, email text, dui text)";
            public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
                super(context, dbname, factory, v);
            }
            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                sqLiteDatabase.execSQL(SQLdb);
            }
            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                //cambiar estructura de la BD
            }
            public String administrar_amigos(String accion, String[] datos){
                try {
                    SQLiteDatabase db = getWritableDatabase();
                    String sql = "";
                    if( accion=="nuevo" ){
                        sql = "INSERT INTO amigos(nombre,direccion,telefono,email,dui) VALUES('"+ datos[1] +"', '"+ datos[2] +"', '"+ datos[3] +"', " +
                                "'"+ datos[4] +"','"+ datos[5] +"')";
                    } else if (accion=="modificar") {
                        sql = "UPDATE amigos SET nombre='"+ datos[1] +"', direccion='"+ datos[2] +"', telefono='"+ datos[3] +"', email=" +
                                "'"+ datos[4] +"', dui='"+ datos[5] +"' WHERE idAmigo='"+ datos[0] +"'";
                    } else if (accion=="eliminar") {
                        sql = "DELETE FROM amigos WHERE idAmigo="+ datos[0] +"'";
                    }
                    db.execSQL(sql);
                    return "ok";
                }catch (Exception e){
                    return e.getMessage();
                }
            }
            public Cursor obtener_amigos(){
                Cursor cursor;
                SQLiteDatabase db = getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM amigos ORDER BY nombre", null);
                return cursor;


                public class MainActivity extends AppCompatActivity {
                    Button btn;
                    FloatingActionButton fab;
                    TextView tempVal;
                    String accion = "nuevo";
                    String id="";
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);

                        fab = findViewById(R.id.fabListarAmigos);
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                abrirActividad();
                            }
                        });
                        btn = findViewById(R.id.btnGuardarAgendaAmigos);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                try {
                                    tempVal = findViewById(R.id.txtnombre);
                                    String nombre = tempVal.getText().toString();

                                    tempVal = findViewById(R.id.txtdireccion);
                                    String direccion = tempVal.getText().toString();

                                    tempVal = findViewById(R.id.txtTelefono);
                                    String tel = tempVal.getText().toString();

                                    tempVal = findViewById(R.id.txtemail);
                                    String email = tempVal.getText().toString();

                                    tempVal = findViewById(R.id.txtdui);
                                    String dui = tempVal.getText().toString();

                                    DB db = new DB(getApplicationContext(), "",null, 1);
                                    String[] datos = new String[]{id,nombre,direccion,tel,email,dui};
                                    String respuesta = db.administrar_amigos(accion, datos);
                                    if(respuesta.equals("ok")){
                                        Toast.makeText(getApplicationContext(), "Amigo guardado con exito", Toast.LENGTH_LONG).show();
                                        abrirActividad();
                                    }else{
                                        Toast.makeText(getApplicationContext(), "Error al intentar guardar el amigo: "+ respuesta, Toast.LENGTH_LONG).show();
                                    }
                                }catch (Exception e){
                                    Toast.makeText(getApplicationContext(), "Error: "+ e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    private void abrirActividad(){
                        Intent abrirActividad = new Intent(getApplicationContext(), lista_amigos.class);
                        startActivity(abrirActividad);
                    }
                }
                public class adaptadorImagenes extends BaseAdapter {
                    Context context;
                    ArrayList<amigos> datosAmigosArrayList;
                    amigos datosAmigos;
                    LayoutInflater layoutInflater;
                    public adaptadorImagenes(Context context, ArrayList<amigos> datosAmigosArrayList) {
                        this.context = context;
                        this.datosAmigosArrayList = datosAmigosArrayList;
                    }
                    @Override
                    public int getCount() {
                        return datosAmigosArrayList.size();
                    }
                    @Override
                    public Object getItem(int i) {
                        return datosAmigosArrayList.get(i);
                    }
                    @Override
                    public long getItemId(int i) {
                        return Long.parseLong(datosAmigosArrayList.get(i).getIdAmigo());
                    }
                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                        View itemView = layoutInflater.inflate(R.layout.listview_imagenes, viewGroup, false);
                        try{
                            datosAmigos = datosAmigosArrayList.get(i);

                            TextView tempVal = itemView.findViewById(R.id.lblnombre);
                            tempVal.setText(datosAmigos.getNombre());

                            tempVal = itemView.findViewById(R.id.lbltelefono);
                            tempVal.setText(datosAmigos.getTelefono());

                            tempVal = itemView.findViewById(R.id.lblemail);
                            tempVal.setText(datosAmigos.getEmail());
                        }catch (Exception e){
                            Toast.makeText(context, "Error al mostrar los datos: "+ e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        return itemView;
                    }
                }


                public class amigos {
                    String idAmigo;
                    String nombre;
                    String direccion;
                    String telefono;
                    String email;
                    String dui;

                    public amigos(String idAmigo, String nombre, String direccion, String telefono, String email, String dui) {
                        this.idAmigo = idAmigo;
                        this.nombre = nombre;
                        this.direccion = direccion;
                        this.telefono = telefono;
                        this.email = email;
                        this.dui = dui;
                    }

                    public String getIdAmigo() {
                        return idAmigo;
                    }

                    public void setIdAmigo(String idAmigo) {
                        this.idAmigo = idAmigo;
                    }

                    public String getNombre() {
                        return nombre;
                    }

                    public void setNombre(String nombre) {
                        this.nombre = nombre;
                    }

                    public String getDireccion() {
                        return direccion;
                    }

                    public void setDireccion(String direccion) {
                        this.direccion = direccion;
                    }

                    public String getTelefono() {
                        return telefono;
                    }

                    public void setTelefono(String telefono) {
                        this.telefono = telefono;
                    }

                    public String getEmail() {
                        return email;
                    }

                    public void setEmail(String email) {
                        this.email = email;
                    }

                    public String getDui() {
                        return dui;
                    }

                    public void setDui(String dui) {
                        this.dui = dui;
                    }
                }


            }
        }
        public class lista_amigos extends AppCompatActivity {
            DB db;
            ListView lts;
            Cursor cAmigos;
            final ArrayList<amigos> alAmigos = new ArrayList<amigos>();
            final ArrayList<amigos> alAmigosCopy = new ArrayList<amigos>();
            amigos datosAmigos;
            FloatingActionButton btn;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.lista_amigos);
                btn = findViewById(R.id.fabAgregarAmigos);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        abrirActividad();
                    }
                });
                obtenerAmigos();
            }
            private void abrirActividad(){
                Intent abrirActividad = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(abrirActividad);
            }
            private void obtenerAmigos(){
                try{
                    alAmigos.clear();
                    alAmigosCopy.clear();

                    db = new DB(getApplicationContext(),"", null, 1);
                    cAmigos = db.obtener_amigos();
                    if( cAmigos.moveToFirst() ){
                        lts = findViewById(R.id.ltsAmigos);
                        do{
                            datosAmigos = new amigos(
                                    cAmigos.getString(0),//idAmigo
                                    cAmigos.getString(1),//nombre
                                    cAmigos.getString(2),//direccion
                                    cAmigos.getString(3),//telefono
                                    cAmigos.getString(4),//email
                                    cAmigos.getString(5)//dui
                            );
                            alAmigos.add(datosAmigos);
                        }while (cAmigos.moveToNext());
                        alAmigosCopy.addAll(alAmigos);

                        adaptadorImagenes adImagenes = new adaptadorImagenes(getApplicationContext(), alAmigos);
                        lts.setAdapter(adImagenes);

                        //registerForContextMenu(lts);
                    }else {
                        abrirActividad();
                        mostrarMsg("No hay Datos de amigos.");
                    }
                }catch (Exception e){
                    mostrarMsg("Error al obtener los amigos: "+ e.getMessage());
                }
            }
            private void mostrarMsg(String msg){
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }










    }
}
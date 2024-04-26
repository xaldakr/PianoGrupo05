package sv.edu.catolica.pianogrupo05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class pianorquesta extends AppCompatActivity {

    private MediaPlayer elsonido;
    private Toast tostadas;
    private ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pianorquesta);
        ib1 = (ImageButton) findViewById(R.id.Ivo1);
        ib2 = (ImageButton) findViewById(R.id.Ivo2);
        ib3 = (ImageButton) findViewById(R.id.Ivo3);
        ib4 = (ImageButton) findViewById(R.id.Ivo4);
        ib5 = (ImageButton) findViewById(R.id.Ivo5);
        ib6 = (ImageButton) findViewById(R.id.Ivo6);
        ib7 = (ImageButton) findViewById(R.id.Ivo7);
        ib8 = (ImageButton) findViewById(R.id.Ivo8);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(1);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(2);
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(3);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(4);
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(5);
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(6);
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(7);
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TheSonido(8);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString().trim()){
            case "Cambiar Piano":
                final String[] pianos={"Piano Clásico", "Piano de la Jungla", "Piano de Orquesta"};
                AlertDialog.Builder builderselect = new AlertDialog.Builder( this);
                builderselect.setTitle("Elija el Piano");
                builderselect.setItems(pianos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){
                            case 0:
                                Intent intento1 = new Intent(pianorquesta.this, pianosimple.class);
                                startActivity(intento1);
                                break;
                            case 1:
                                Intent intento2 = new Intent(pianorquesta.this, pianojunglal.class);
                                startActivity(intento2);
                                break;
                            case 2:
                                Toast.makeText(getApplicationContext(), "Ya estás en ese piano!!!",Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                builderselect.create();
                builderselect.show();
                return true;
            case "Acerca de":
                Intent intentoabout = new Intent(pianorquesta.this, aboutus.class);
                startActivity(intentoabout);
                return true;
            case "Salir":
                if (elsonido != null) {
                    if (elsonido.isPlaying()) {
                        elsonido.stop();
                        elsonido.release();
                        elsonido = null;
                    }
                }
                finishAffinity();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "Un error ha ocurrido",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
    private void TheSonido (int id){
        String datoast = "";
        if (elsonido != null) {
            if (elsonido.isPlaying()) {
                elsonido.stop();
                elsonido.release();
            }
        }
        if (tostadas != null) {
            tostadas.cancel();
            tostadas = null;
        }
        elsonido = null;
        if (id == 1){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.guitarrado);
            datoast = "Nota Do | C";
        } else if (id == 2){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.timbalre);
            datoast = "Nota Re | D";
        } else if (id == 3){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.tubami);
            datoast = "Nota Mi | E";
        } else if (id == 4){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.bajofa);
            datoast = "Nota Fa | F";
        } else if (id == 5){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.violinsol);
            datoast = "Nota Sol | G";
        } else if (id == 6){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.ocarinala);
            datoast = "Nota La | A";
        } else if (id == 7){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.xilofonosi);
            datoast = "Nota Si | B";
        } else if (id == 8){
            elsonido = MediaPlayer.create(pianorquesta.this,R.raw.saxofondo8);
            datoast = "Nota Do Octava | C Octava";
        } else {
            datoast = "Ha ocurrido un error";
        }

        try {
            if (elsonido !=null) {
                elsonido.start();
            }
            tostadas = Toast.makeText(getApplicationContext(), datoast, Toast.LENGTH_SHORT);
            tostadas.show();
        }catch (IllegalStateException e){
            tostadas = Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT);
            tostadas.show();
        }
    }
}
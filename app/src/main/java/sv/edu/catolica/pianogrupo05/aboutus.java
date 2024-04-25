package sv.edu.catolica.pianogrupo05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
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
                                Intent intento1 = new Intent(aboutus.this, pianosimple.class);
                                startActivity(intento1);
                                break;
                            case 1:
                                Intent intento2 = new Intent(aboutus.this, pianojunglal.class);
                                startActivity(intento2);
                                break;
                            case 2:
                                Intent intento3 = new Intent(aboutus.this, pianorquesta.class);
                                startActivity(intento3);
                                break;
                        }
                    }
                });
                builderselect.create();
                builderselect.show();
                return true;
            case "Acerca de":
                Toast.makeText(getApplicationContext(), "Ya estás en el Acerca de...",Toast.LENGTH_SHORT).show();
                return true;
            case "Salir":
                finishAffinity();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "Un error ha ocurrido",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
}
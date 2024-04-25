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

public class pianojunglal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pianojunglal);
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
                                Intent intento1 = new Intent(pianojunglal.this, pianosimple.class);
                                startActivity(intento1);
                                break;
                            case 1:
                                Toast.makeText(getApplicationContext(), "Ya estás en ese piano!!!",Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Intent intento2 = new Intent(pianojunglal.this, pianorquesta.class);
                                startActivity(intento2);
                                break;
                        }
                    }
                });
                builderselect.create();
                builderselect.show();
                return true;
            case "Acerca de":
                Intent intentoabout = new Intent(pianojunglal.this, aboutus.class);
                startActivity(intentoabout);
                return true;
            case "Salir":
                System.exit(0);
                return true;
            default:
                Toast.makeText(getApplicationContext(), "Un error ha ocurrido",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
}
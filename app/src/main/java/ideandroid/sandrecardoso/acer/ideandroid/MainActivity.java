package ideandroid.sandrecardoso.acer.ideandroid;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.support.v7.widget.ShareActionProvider;
import android.database.sqlite.SQLiteDatabase;
import android.support.compat.*;
import android.widget.VideoView;

import java.io.File;
import java.util.Objects;
import android.widget.DatePicker;

import ideandroid.sandrecardoso.acer.ideandroid.R.id;
import ideandroid.sandrecardoso.acer.ideandroid.R.layout;
import ideandroid.sandrecardoso.acer.ideandroid.R.mipmap;

public class MainActivity extends AppCompatActivity {
    private EditText texto;
    private Button ok;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);
        this.texto = this.findViewById(id.texto);
        this.ok = this.findViewById(id.ok);
        this.ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick( View v ) {
                if (MainActivity.this.texto.getText().toString().equals("alert")){
                Builder alert=new Builder(MainActivity.this);
                alert.setTitle("Aviso");
                alert.setMessage("você deseja fechar!!!");
                alert.setIcon(mipmap.ic_launcher_foreground);
                alert.setCancelable(false);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        finish();
                    }
                });
                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        Toast.makeText(MainActivity.this,"Cancelado",Toast.LENGTH_SHORT).show();
                    }
                });
                    alert.show();
                }else if(texto.getText().toString().equals("exit")){
                    finish();
                }else if (texto.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"tape your text",Toast.LENGTH_SHORT).show();
                }else if (texto.getText().toString().equals("screen")){
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }else if (texto.getText().toString().equals(";")){
                    Toast.makeText(MainActivity.this,"ponto e vírgula",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}

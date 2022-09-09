package cl.tomato.myway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonStart = (Button) findViewById(R.id.startBtn);
        botonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openpaginaPrincipal();
            }
        });

    }
    public void openpaginaPrincipal(){
        Intent i2 = new Intent(this,paginaPrincipal.class);
        startActivity(i2);
    }
    public void openSignUpPage(View view){
        Intent i = new Intent(this, SignUpPage.class);
        startActivity(i);
    }
}
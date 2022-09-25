package cl.tomato.myway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        Button botonStartSU = (Button) findViewById(R.id.button);
        botonStartSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openpaginaPrincipalSU();
            }
        });
    }
    public void openpaginaPrincipalSU(){
        Intent i2 = new Intent(this,pagina_principal.class);
        startActivity(i2);
    }
}
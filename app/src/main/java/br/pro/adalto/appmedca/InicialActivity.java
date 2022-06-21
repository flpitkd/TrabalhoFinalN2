package br.pro.adalto.appmedca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class InicialActivity extends AppCompatActivity {

    private Button btnloc;
    private Button btncad;
    private Button btnlist;

    FirebaseDatabase database;
    DatabaseReference reference;

    ChildEventListener childEventListener;
    Query query;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        //Firebase
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();


        btnloc = findViewById(R.id.btnloc);
        btncad = findViewById(R.id.btncad);
        btnlist = findViewById(R.id.btnlist);

        btnloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, CadastroActivity.class);
                intent.putExtra("acao", "inserir");
                startActivity( intent );
            }
        });

        btncad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, CadastroActivity.class);
                intent.putExtra("acao", "inserir");
                startActivity( intent );
            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, CadastroActivity.class);
                intent.putExtra("acao", "inserir");
                startActivity( intent );
            }
        });

    }



}
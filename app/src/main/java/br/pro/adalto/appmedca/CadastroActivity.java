package br.pro.adalto.appmedca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    private Spinner spGeneros;
    private EditText etTitulo, etAutor;
    private Button btnSalvar;
    private String acao;
    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        spGeneros = findViewById(R.id.spGenero);

        etTitulo = findViewById(R.id.etTitulo);
        etAutor = findViewById(R.id.etAutor);
        btnSalvar = findViewById(R.id.btnSalvar);
        //      btnSalvar.setEnabled(false);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        carregarGeneros();

        acao = getIntent().getExtras().getString("acao");
        if (acao.equals("editar")){
            livro = new Livro();
            livro.setId(getIntent().getExtras().getString("idLivro"));
            etTitulo.setText(getIntent().getExtras().getString("titulo"));
            etAutor.setText(getIntent().getExtras().getString("autor"));
        }

    }

    private void salvar(){
        if (acao.equals("inserir")) {
            livro = new Livro();
        }

        String titulo = etTitulo.getText().toString();

        if( !titulo.isEmpty() && spGeneros.getSelectedItemPosition() > 0){
            livro.setTitulo( titulo );
            livro.setGenero( (Genero) spGeneros.getSelectedItem() );
            livro.setAutor( etAutor.getText().toString() );

//            LivroDAO.inserir( this, livro );

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference();


            if (acao.equals("inserir")){
                reference.child("livros").push().setValue( livro );
            }else{
                reference.child("livros").child(livro.getId()).setValue(livro);
            }


            finish();
        }


    }

    private void carregarGeneros(){
        Genero inicial = new Genero(0, "Selecione a especilidade...");
        Genero geral = new Genero(1, "Clínico Geral");
        Genero dermatologia = new Genero(2, "Dermatologia");
        Genero estetica = new Genero(3, "Estética");
        Genero ginecologia = new Genero(4, "Ginecologia");
        Genero oncologia = new Genero(5, "Oncologia");
        Genero ortopedia = new Genero(6, "Ortopedia");
        Genero radiologia = new Genero(7, "Radiologia");
        Genero traumatologia = new Genero(8, "Traumatologia");
        List<Genero> lista = new ArrayList<>(); // GeneroDAO.getGeneros(  this );
        lista.add(inicial);
        lista.add(geral);
        lista.add(dermatologia);
        lista.add(estetica);
        lista.add(ginecologia);
        lista.add(oncologia);
        lista.add(ortopedia);
        lista.add(radiologia);
        lista.add(traumatologia);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista );
        spGeneros.setAdapter( adapter );

    }




}
package pmcg.imti.cursoimti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Eder Lima on 03/08/15.
 */
public class MainActivity extends AppCompatActivity {
    /*
    Primeira função executada ao iniciar a classe/app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //salva o estado da aplicação
        super.onCreate(savedInstanceState);
        /**
         * Chama a primeira janela, a classe R traz constantes que usam a string que nomeia a janela
         * para retornar a ID criada internamente para a activity(view), neste caso a main_activity,
         * logo setContentView(activity criada) mostra a activity
         */
        setContentView(R.layout.main_activity);
        //é preciso definir como final as propriedades criadas no activity.xml para que sejam acessadas no escopo de funções anônimas
        //pois o view.onclicklistener não é apenas uma função anônima, é uma classe e função novas class.obj
        final EditText edNome = (EditText) findViewById(R.id.ed_nome);
        final EditText viewNome = (EditText) findViewById(R.id.view_nome);
        Button btnOk = (Button) findViewById(R.id.btn_ok);
        //criando um handler anônimo para o evento click do botão
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edNome.getText().toString();
                //Toast.makeText(MainActivity.this, nome, Toast.LENGTH_SHORT).show();
                viewNome.setText(nome);

            }


        });
    }
}

package pmcg.imti.cursoimti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 04/08/15.
 */
public class Activity02 extends AppCompatActivity {
    //usando butterkinife
    //não funciona com objeto local (dentro de funções)
    /*@Bind(R.id.btn_01)
        Button btn1;*/
    //clicando com o butterknife (observar que não é preciso declarar mais o objeto antes
    @OnClick(R.id.btn_01)
    public void onClick01() {
        Toast.makeText(Activity02.this, "Clique no botão 1", Toast.LENGTH_SHORT).show();
    }
    @Bind(R.id.btn_02)
        Button btn2;
    @Bind(R.id.btn_03)
        Button btn3;
    @Bind(R.id.btn_04)
        Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceActivity) {
        super.onCreate(savedInstanceActivity);
        setContentView(R.layout.activity_02);
        ButterKnife.bind(this);




        //Button btn1 = (Button) findViewById(R.id.btn_01);
        /*btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity02.this, "Botão 1", Toast.LENGTH_SHORT).show();
            }
        });*/

        //Button btn2 = (Button) findViewById(R.id.btn_02);
        /*btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity02.this, "Botão 2", Toast.LENGTH_SHORT).show();
            }
        });*/

        //Button btn3 = (Button) findViewById(R.id.btn_03);
        /*btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity02.this, "Botão 3", Toast.LENGTH_SHORT).show();
            }
        });*/

        //Button btn4 = (Button) findViewById(R.id.btn_04);
        //btn4.setOnClickListener(new Listener("Botão 4"));
    }
    /*
    //criando uma classe que permite reaproveitar o listener
    class Listener implements View.OnClickListener{

        //criando uma string pública
        String s;
        //recebendo a string do construtor na string s pública
        public  Listener(String s){
            this.s=s;
        }
        //sobrescrevendo a função onclick e exibindo a string s
        @Override
        public void onClick(View v) {
            Toast.makeText(Activity02.this, s, Toast.LENGTH_SHORT).show();
        }
    }
    */



}

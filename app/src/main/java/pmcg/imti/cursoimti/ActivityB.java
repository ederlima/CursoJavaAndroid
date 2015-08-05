package pmcg.imti.cursoimti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 05/08/15.
 */
public class ActivityB extends AppCompatActivity {

    @OnClick(R.id.btnb)
    public void closeActivity() {
        /*Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);*/
        //Bundle de retorno

        finish();
    }
    @OnClick(R.id.btnr)
    public void sendResult() {
        Bundle bundleResult = new Bundle();
        bundleResult.putString("resultText", "Este é o texto retornado.");
        Intent intent = new Intent();
        intent.putExtras(bundleResult);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_b);
        //Bundle de entrada
        //String msg = (String) getIntent().getExtras().get("msg");
        if(getIntent().getExtras()!=null) {
            Bundle bundle = getIntent().getExtras();
            String msg = bundle.getString("msg");
            Client cli = (Client) bundle.getSerializable("cli");
            Toast.makeText(ActivityB.this, "Olá " + cli.getNome() + " (" + cli.getEmail() + "), sua mensagem: " + msg, Toast.LENGTH_SHORT).show();
        }

        ButterKnife.bind(this);


    }
    @Override
    protected void onPause() {
        super.onPause();

    }
}

package pmcg.imti.cursoimti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 05/08/15.
 */
public class ActivityA extends AppCompatActivity {

    @Bind(R.id.textmsg)
    EditText textmsg;

    @OnClick(R.id.btna)
    public void OpenActivity() {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);

        //intent.putExtra("msg", String.valueOf( textmsg.getText() ) ); //método simples, apenas um extra
        //método com vários objetos
        Bundle bundle = new Bundle();
        //inserindo objetos implementando Serializable
        Client cli = new Client();
        cli.setNome("Jão");
        cli.setEmail("jao@ta.bao");

        bundle.putSerializable("cli", cli);
        bundle.putString("msg", String.valueOf(textmsg.getText()));

        intent.putExtras(bundle);

        startActivity(intent);
    }
    @OnClick(R.id.btnr)
    public void callResult() {
        Intent resultIntent = new Intent(ActivityA.this, ActivityB.class);
        startActivityForResult(resultIntent, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);

    }
    @Override
    protected void onPause() {
        super.onPause();
        //finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            Bundle bundle = data.getExtras();
            String msg = bundle.getString("resultText");
            Toast.makeText(ActivityA.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}

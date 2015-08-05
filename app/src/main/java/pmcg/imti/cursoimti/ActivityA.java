package pmcg.imti.cursoimti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

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
        bundle.putString("msg", String.valueOf(textmsg.getText()) );
        intent.putExtras(bundle);
        startActivity(intent);
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
}

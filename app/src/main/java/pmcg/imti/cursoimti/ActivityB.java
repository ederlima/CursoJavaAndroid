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
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_b);

        //String msg = (String) getIntent().getExtras().get("msg");
        Bundle bundle = getIntent().getExtras();
        String msg = bundle.getString("msg");
        Toast.makeText(ActivityB.this, msg, Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this);

    }
    @Override
    protected void onPause() {
        super.onPause();

    }
}

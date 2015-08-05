package pmcg.imti.cursoimti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 05/08/15.
 */
public class ActivityA extends AppCompatActivity {

    @OnClick(R.id.btna)
    public void onClick() {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
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

package pmcg.imti.cursoimti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 04/08/15.
 */
public class ActivityCalculator extends AppCompatActivity {


    @Bind(R.id.valor1)
            EditText val1;
    @Bind(R.id.valor2)
            EditText val2;

    String v1s;
    String v2s;

    @OnClick(R.id.btn_sum)
    public void mysum() {
        v1s = val1.getText().toString();
        v2s = val2.getText().toString();

        int sumResult = (Integer.parseInt(v1s)) + (Integer.parseInt(v2s));
        String rtext = String.valueOf(sumResult);
        Toast.makeText( ActivityCalculator.this, rtext ,Toast.LENGTH_SHORT  ).show();
    }
    @OnClick(R.id.btn_sub)
    public void mysub() {
        v1s = val1.getText().toString();
        v2s = val2.getText().toString();

        int subResult = (Integer.parseInt(v1s)) - (Integer.parseInt(v2s));
        String rtext = String.valueOf(subResult);
        Toast.makeText( ActivityCalculator.this, rtext ,Toast.LENGTH_SHORT  ).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceActivity) {
        super.onCreate(savedInstanceActivity);

        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);
    }


}

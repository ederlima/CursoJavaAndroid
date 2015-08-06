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
public class ActivityInsert extends AppCompatActivity {

    @Bind(R.id.newname)
    EditText newname;

    @OnClick(R.id.btnn)
    public void addName() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("newname", (String) newname.getText().toString());
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        //startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.list_insert);
        ButterKnife.bind(this);
    }
}

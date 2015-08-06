package pmcg.imti.cursoimti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 05/08/15.
 */
public class ActivityList extends AppCompatActivity {

    @Bind(R.id.my_list)
    ListView list;

    @OnClick(R.id.btni)
    public void insertName() {
        Intent intent = new Intent(ActivityList.this, ActivityInsert.class);
        startActivityForResult(intent, 1000);

    }

    static final ArrayList<String> NAMES = new ArrayList<String>();


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            Bundle bundle = data.getExtras();
            NAMES.add(data.getExtras().getString("newname"));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, NAMES);
            list.setAdapter(adapter);

            Toast.makeText(ActivityList.this, "Pessoa adicionada!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, NAMES);
        list.setAdapter(adapter);


    }
}

package pmcg.imti.cursoimti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by aluno on 05/08/15.
 */
public class ActivityList extends AppCompatActivity {

    @Bind(R.id.my_list)
    ListView list;

    static final String[] NAMES = {
            "Jão",
    };

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, NAMES);
        list.setAdapter(adapter);

    }
}

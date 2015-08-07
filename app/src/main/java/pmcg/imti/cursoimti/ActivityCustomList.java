package pmcg.imti.cursoimti;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import pmcg.imti.cursoimti.R;
import pmcg.imti.cursoimti.adapters.UserListAdapter;
import pmcg.imti.cursoimti.models.ListUser;
import pmcg.imti.cursoimti.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Virmerson on 24/07/15.
 */
public class ActivityCustomList extends AppCompatActivity {

    @Bind(R.id.lista)
    ListView lista;

    List<ListUser> userList = new ArrayList<ListUser>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_users);
        ButterKnife.bind(this);
        createUsers();
        //Carregando os dados no adapter
        UserListAdapter adapter = new UserListAdapter(this, userList);


        //Carregando o adapter no ListView
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityCustomList.this, userList.get(position).name, Toast.LENGTH_SHORT ).show();
            }
        });

    }
    public void createUsers(){
        userList = Arrays.asList(new ListUser(1, "Jao",R.drawable.sample_1 ),
                new ListUser(2, "Maria", R.drawable.sample_2),
                new ListUser(3,"Zé", R.drawable.sample_3));
    }



}
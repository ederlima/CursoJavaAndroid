package pmcg.imti.cursoimti.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import pmcg.imti.cursoimti.R;
import pmcg.imti.cursoimti.adapters.UserListAdapter;
import pmcg.imti.cursoimti.models.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import se.emilsjolander.sprinkles.Query;

/**
 * Created by Virmerson on 31/07/15.
 */
public class DBMainActivity extends AppCompatActivity {

    @Bind(R.id.user_list_view)
    ListView userListView;

    UserListAdapter adapter;

    // @Bind(R.id.btn_new_user)
    //Button btnNewUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_users_db);
        ButterKnife.bind(this);

        //Definindo um Long Click
        userListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog alert =  new AlertDialog.Builder(DBMainActivity.this)
                        .setTitle("Excluir Usuário")
                        .setMessage("Deseja Excluir Realmente este usuário?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Acessando e Excluindo do banco
                                adapter.getItem(position).delete();
                                //Excluindo da lista do adapter
                                adapter.users.remove(position);
                                //Ei Adpter, mudamos a lista!
                                adapter.notifyDataSetChanged(); //Tá bom, vou recarregar!


                            }
                        }).show();


                return true;
            }
        });

        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent irParaRegister = new Intent(DBMainActivity.this, RegisterUserActivity.class);
                irParaRegister.putExtra(RegisterUserActivity.USER_KEY, adapter.getItem(position) );
                startActivity(irParaRegister);

            }
        });
    }

    @OnClick(R.id.btn_new_user)
    public void registerUser(){
        Intent irParaRegisterUser =  new Intent(this, RegisterUserActivity.class);
        startActivity(irParaRegisterUser);
    }

    /** Buscando no banco **/
    public List<User> queryUsers(){
        return Query.all(User.class).get().asList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Carregando a lista ao Iniciar a Tela
        adapter = new UserListAdapter(this, queryUsers());
        userListView.setAdapter(adapter);
    }
}
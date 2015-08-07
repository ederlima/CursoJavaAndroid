package pmcg.imti.cursoimti.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pmcg.imti.cursoimti.R;
import pmcg.imti.cursoimti.models.ListUser;

//import com.htcursos.intensivolistapp.models.User;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Virmerson on 29/07/15.
 */
/**
 *  criando a classe adapter personalizada extendendo a ArrayAdapter e já informando qual o tipo de objeto
 *  dessa forma a parte de iteração do adapter vai ser herdada (e outras)
 */


public class UserListAdapter extends ArrayAdapter<ListUser> {

    public UserListAdapter(Context context, List<ListUser> userList) {
        //rodando o construtor da superclasse informando como layout de cada item nosso item personalizado (item_list_user (view))
        super(context, R.layout.item_list_user, userList);
    }

    /**
     * Toda vez que
     *
     * @param position
     * @param convertView Item
     * @param parent      Lista
     * @return
     * Iterando com cada item
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflando o Layout
        //o holder é um objeto que vai referenciar os itens dentro da view
        final ViewHolder holder;

        if (convertView == null) {

            //Carregando o layout na view
            convertView = View.inflate(getContext(), R.layout.item_list_user, null);

            holder = new ViewHolder();

            //Vincula o Holder com o Layout, Aqui acontece o Bind das Views
            ButterKnife.bind(holder, convertView);

            //Setando o holder para poder recupera-lo quando o convertView não for nulo
            convertView.setTag(holder);
        } else {
            //Acessando o Holder quando já existe o item
            holder = (ViewHolder) convertView.getTag();
        }
        //Pegando usuario Posicao da Lista  para setar no layout
        final ListUser user =  getItem(position);
        //Setando dados do usuario na View
        if(user!=null){
            holder.userName.setText(user.name);
            holder.userImage.setImageResource(user.imagem);
        }
        return convertView;
    }

    //Guardando as views da List View
    public class ViewHolder {
        @Bind(R.id.userName)
        TextView userName;

        @Bind(R.id.userImage)
        ImageView userImage;
    }
}
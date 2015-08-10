package pmcg.imti.cursoimti;

import android.app.Application;

import pmcg.imti.cursoimti.migrations.CreateUserMigration;
import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by aluno on 07/08/15.
 */
public class DBAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //iniciando o sprinkles
        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());
        //criando as tabelas
        sprinkles.addMigration(new CreateUserMigration());


    }
    private void runMigrations(Sprinkles sprinkles) {
        sprinkles.addMigration(new CreateUserMigration());
    }
}

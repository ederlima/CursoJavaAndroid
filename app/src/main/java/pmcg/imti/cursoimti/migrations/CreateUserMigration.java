package pmcg.imti.cursoimti.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

/**
 * Created by aluno on 07/08/15.
 */
public class CreateUserMigration extends Migration {

    @Override
    protected void doMigration(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CRETATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT)");
    }
}

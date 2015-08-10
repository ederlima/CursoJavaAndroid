package pmcg.imti.cursoimti.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

/**
 * Created by Virmerson on 31/07/15.
 */
public class CreateUserMigration extends Migration {


    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT)");
    }
}
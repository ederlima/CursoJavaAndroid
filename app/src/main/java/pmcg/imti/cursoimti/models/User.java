package pmcg.imti.cursoimti.models;

import java.io.Serializable;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

/**
 * Created by aluno on 07/08/15.
 */
@Table("Users")
public class User extends Model implements Serializable {

    @Key
    @AutoIncrement
    @Column("id")
    public long id;

    @Column("name")
    public String name;

    @Column("email")
    public String email;

    /* getters and setters */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}

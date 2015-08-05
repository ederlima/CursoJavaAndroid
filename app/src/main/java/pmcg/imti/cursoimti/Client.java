package pmcg.imti.cursoimti;

import java.io.Serializable;

/**
 * Created by aluno on 05/08/15.
 */
public class Client implements Serializable {
    private String nome;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String email;



}

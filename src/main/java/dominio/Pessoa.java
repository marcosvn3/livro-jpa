package dominio;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pessoas_db")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String nome;
    private String emai;

    @Embedded
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String emai, Endereco endereco) {
        this.nome = nome;
        this.emai = emai;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", emai='" + emai + '\'' +
                '}';
    }
}

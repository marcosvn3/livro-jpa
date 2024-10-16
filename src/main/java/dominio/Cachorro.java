package dominio;

import javax.persistence.*;

@Entity
public class Cachorro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String raca;

    @ManyToOne()
    private Usuario usuario;


    public Cachorro(){}

    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario pessoa) {
        this.usuario = pessoa;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", pessoa=" + usuario +
                '}';
    }
}

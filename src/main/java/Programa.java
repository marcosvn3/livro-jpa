import dominio.Cachorro;
import dominio.Endereco;
import dominio.Pessoa;

import dominio.Usuario;
import jpa.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        EntityManager em = JPAutil.getEntityManager();
        Endereco endereco = new Endereco("Rua J", "Bairro J", 062);

        // Cria três objetos Cachorro com nomes e raças diferentes
        Cachorro cachorro = new Cachorro("kill","Pitbull");
        Cachorro cachorro2 = new Cachorro("Denzel","Cherry");
        Cachorro cachorro3 = new Cachorro("Post","Buldog");

        //Cria uma lista para armazenar os objetos Cachorro criados
        List<Cachorro> cachorros = new ArrayList<>();

        //Adiciona os objetos Cachorro à lista
        cachorros.add(cachorro);
        cachorros.add(cachorro2);
        cachorros.add(cachorro3);

        //Adicionar pessoas com JPA
        Usuario p1 = new Usuario("laura fiel",cachorros);


        //modo correto de usar o EntityManager
//        try {
//            em.getTransaction().begin();
//            em.persist(p1);
//            em.getTransaction().commit();
//        }catch (Exception e) {
//            if(em.isOpen()){
//                em.getTransaction().rollback();
//            }
//        }finally {
//            if(em.isOpen()) {
//                em.close();
//            }
//        }


         //remove-> Pra remover tem que procurar e remover
//        try{
//            em.getTransaction().begin();
//            Pessoa p  = em.find(Pessoa.class, 3);
//            em.remove(p);
//            em.getTransaction().commit();
//        }catch (Exception e) {
//            if (em.isOpen()) {
//                em.getTransaction().rollback();
//            }
//        }finally {
//            if(em.isOpen()) {
//                em.close();
//            }
//        }


        //TODO: Cria um objeto Pessoa2 e associa a lista de Cachorros a ela
        //Pessoa2 p1 = new Pessoa2("Lucena santos",cachorros);

        //TODO: Define uma consulta JPQL para buscar Cachorros pelo ID
        //String consulta = "SELECT c FROM Cachorro c WHERE c.id = :id";

        //TODO: Define uma consulta JPQL para buscar e ordenar Cachorros pelo nome
        //String consulta = "SELECT c FROM Cachorro c ORDER BY c.nome";

        //TODO: Define uma consulta JPQL para buscar os cachorros associados a um Id de pessoa.
        String consulta = "SELECT c FROM Cachorro c JOIN c.usuario p where p.id = 3";



        // Bloco de código comentado para persistir a Pessoa2 e seus Cachorros no banco de dados
        try {
            em.getTransaction().begin();
            // Persiste a Pessoa2 e seus Cachorros no banco de dados
            em.persist(p1);
            em.getTransaction().commit();
        }catch (Exception e) {
            // Se houver uma exceção, verifica se a EntityManager está aberta e faz rollback na transação
            if(em.isOpen()){ em.getTransaction().rollback(); }
        }finally {
            // Fecha a EntityManager se ela estiver aberta
            if(em.isOpen()) {
                em.close();
            }
        }

        // Bloco de código para extrair dados do banco de dados usando JPQL
//        try {
//            em.getTransaction().begin();
//            // Cria uma consulta tipada para buscar Cachorros
//            TypedQuery<Cachorro> query = em.createQuery(consulta, Cachorro.class);
//
//            // Define o parâmetro 'id' para a consulta
////            query.setParameter("id",3);
//
//            // Executa a consulta e obtém a lista de resultados
//            List<Cachorro> novaListCachorro = query.getResultList();
//
//            // Itera sobre a lista de Cachorros e imprime cada um
//            for(Cachorro c : novaListCachorro){
//                System.out.println(c.toString());
//            }
//            em.getTransaction().commit();
//        }catch (Exception e) {
//            // Se houver uma exceção, verifica se a EntityManager está aberta e faz rollback na transação
//            if(em.isOpen()){em.getTransaction().rollback();}
//        }finally {
//            // Fecha a EntityManager se ela estiver aberta
//            if(em.isOpen()) {
//                em.close();
//            }
//        }



        System.out.println("Deu certo");

    }
}

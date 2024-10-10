import dominio.Pessoa;

import jpa.JPAutil;

import javax.persistence.EntityManager;

public class Programa {
    public static void main(String[] args) {
        EntityManager em = JPAutil.getEntityManager();


        //Adicionar pessoas com JPA
        Pessoa p1 = new Pessoa("laura fiel","laura_fiel@gmail.com");


        //modo correto de usar o EntityManager
        try {
            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();
        }catch (Exception e) {
            if(em.isOpen()){
                em.getTransaction().rollback();
            }
        }finally {
            if(em.isOpen()) {
                em.close();
            }
        }


         //remove-> Pra remover tem que procurar e remover
        try{
            em.getTransaction().begin();
            Pessoa p  = em.find(Pessoa.class, 3);
            em.remove(p);
            em.getTransaction().commit();
        }catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
        }finally {
            if(em.isOpen()) {
                em.close();
            }
        }



        System.out.println("Deu certo");

    }
}

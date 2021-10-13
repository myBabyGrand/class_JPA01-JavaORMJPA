package jpabook.jpashoop;

import hellojpa.Member;
import hellojpa.RoleType;
import jpabook.jpashoop.domain.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaShopMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Movie movie = new Movie();
            movie.setName("Parasite");
            movie.setDirector("Bong");
            movie.setActor("Song");
            em.persist(movie);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

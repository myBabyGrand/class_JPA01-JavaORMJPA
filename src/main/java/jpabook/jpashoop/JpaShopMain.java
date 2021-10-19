package jpabook.jpashoop;

import hellojpa.RoleType;
import jpabook.jpashoop.domain.Address;
import jpabook.jpashoop.domain.Member;
import jpabook.jpashoop.domain.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaShopMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setName("PARK");
            member.setAddress(new Address("SEOUL", "SAMSUNG STREET", "111111"));
            member.setCreatedBy("TEST");
            member.setCreatedDate(LocalDateTime.now());
            member.setLastModifiedBy("TEST");
            member.setLastModifiedDate(LocalDateTime.now());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}


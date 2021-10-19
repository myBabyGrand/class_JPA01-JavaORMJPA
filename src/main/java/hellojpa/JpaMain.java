package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("Song");
            member.setHomeAddress(new Address("Yong-in", "YeonWon Street", "11111"));

            member.getAddressHistory().add(new AddressEntity("Yong-in", "YeonWon Street2", "11111"));
            member.getAddressHistory().add(new AddressEntity("Yong-in", "YeonWon Street3", "11111"));
            member.getFavoriteFoods().add("Sushi");
            member.getFavoriteFoods().add("Salad");
            member.getFavoriteFoods().add("Spaghetti");

            em.persist(member);
            Long memberId = member.getId();

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, memberId);
            //값타입 수정 - embedded
            findMember.setHomeAddress(new Address(findMember.getHomeAddress().getCity(), "YeonWon Street5", findMember.getHomeAddress().getZipcode()));
            //값타입 수정 - Collection
            findMember.getFavoriteFoods().remove("Spaghetti");
            findMember.getFavoriteFoods().add("Carbonara");
            //값타입 수정 - Collection2
            findMember.getAddressHistory().remove(new AddressEntity("Yong-in", "YeonWon Street2", "11111"));
            findMember.getAddressHistory().add(new AddressEntity("Yong-in", "YeonWon Street7", "11111"));

            em.persist(findMember);

            tx.commit();
        }catch (Exception e){
           tx.rollback();
           e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}


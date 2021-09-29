package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("user1");
//
//            em.persist(member);

            Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.toString());
            findMember.setName("jpaUser1");

            tx.commit();

            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
            for (Member member : result) {
                System.out.println(member.toString());
            }
        }catch (Exception e){
           tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}

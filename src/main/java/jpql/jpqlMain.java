package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;


public class jpqlMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            JpqlTeam team = new JpqlTeam();
            team.setName("C Team");
            em.persist(team);

            JpqlMember member = new JpqlMember();
            member.setUsername("Tom");
            member.setTeam(team);
            member.setBirth(LocalDateTime.of(1986,3,15,6,30));
            em.persist(member);

            em.flush();
            em.clear();

            List<JpqlMemberDTO> resultList = em.createQuery("select new jpql.JpqlMemberDTO(m.username, m.birth) from JpqlMember m", JpqlMemberDTO.class).getResultList();

            for (JpqlMemberDTO memberDTO : resultList) {
                System.out.println(memberDTO.toString());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

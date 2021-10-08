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
            Team team = new Team();
            team.setName("A");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("B");
            em.persist(team2);

            Member member = new Member();
            member.setUsername("user1");
            member.setRoleType(RoleType.USER);
            member.setTeam(team);

            Member member2 = new Member();
            member2.setUsername("user2");
            member2.setRoleType(RoleType.USER);
            member2.setTeam(team);

            em.persist(member);
            em.persist(member2);
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class,  member2.getId());
//            System.out.println(findMember.toString());
//            System.out.println(findMember.getTeam().toString());

            System.out.println(findMember.getTeam()+"'s MemberList");
            for(Member m : findMember.getTeam().getMembers()){
                System.out.println(m.toString());
            }

            //수정  A->B팀
            findMember.setTeam(team2);

            tx.commit();
        }catch (Exception e){
           tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}

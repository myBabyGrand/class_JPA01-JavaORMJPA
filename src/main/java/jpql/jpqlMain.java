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
//            JpqlTeam team = new JpqlTeam();
//            team.setName("Bulk Team");
//            em.persist(team);
//            for (int i =0; i<36; i++) {
//                JpqlMember member = new JpqlMember();
//                member.setUsername("Tom");
//                member.setTeam(team);
//                int yyyy = 1986+i;
//                member.setBirth(LocalDateTime.of(yyyy,3,15,6,30));
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();

//            String query = "select m from JpqlMember m inner JOIN m.team t where t.name = :teamname order by m.birth desc";
//            List<JpqlMember> members = em.createQuery(query,JpqlMember.class)
//                    .setParameter("teamname", "Bulk Team")
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (JpqlMember member : members) {
//                System.out.println(member.toString());
//            }

            //type 일괄 갱신 & admin 계정 추가
//            List<JpqlMember> AllMembers = em.createQuery("select m from JpqlMember m", JpqlMember.class).getResultList();
//            for (JpqlMember allMember : AllMembers) {
//                allMember.setMemberType(MemberType.USER);
//                em.persist(allMember);
//            }
//            JpqlMember adminMember = new JpqlMember();
//            adminMember.setUsername("ADMIN");
//            adminMember.setMemberType(MemberType.ADMIN);
//            em.persist(adminMember);

//            String query2 = "select 'HeLLO', m.username, true, m.memberType from JpqlMember m where m.memberType = jpql.MemberType.ADMIN";
//            String query3 = "select 'HeLLO', m.username, true, m.memberType from JpqlMember m where m.memberType = :type";
//            List<Object[]> result = em.createQuery(query2)
////                    .setParameter("type", MemberType.ADMIN)
//                    .getResultList();
//            for (Object[] objects : result) {
//                System.out.println(objects[0]);
//                System.out.println(objects[1]);
//                System.out.println(objects[2]);
//                System.out.println(objects[3]);
//            }

            String query4 = "select SIZE(t.members) from JpqlTeam t";
            Object singleResult = em.createQuery(query4).getSingleResult();
            System.out.println("select SIZE(t.members) from JpqlTeam t : "+singleResult);

//            String query5 = "select function('group_concat', m.memberType) from JpqlMember m";
            String query5 = "select group_concat(m.memberType) from JpqlMember m";

            Object singleResult2 = em.createQuery(query5).getSingleResult();
            System.out.println("select function('group_concat', m.memberType) from JpqlMember m : "+singleResult2);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}


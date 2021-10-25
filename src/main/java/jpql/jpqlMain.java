package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Collection;
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

//            em.flush();
//            em.clear();
            /*
            String query = "select m from JpqlMember m inner JOIN m.team t where t.name = :teamname order by m.birth desc";
            List<JpqlMember> members = em.createQuery(query,JpqlMember.class)
                    .setParameter("teamname", "Bulk Team")
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();
            for (JpqlMember member : members) {
                System.out.println(member.toString());
            }

            // 여러가지 JPQL 타입
            String query2 = "select 'HeLLO', m.username, true, m.memberType from JpqlMember m where m.memberType = jpql.MemberType.ADMIN";
            String query3 = "select 'HeLLO', m.username, true, m.memberType from JpqlMember m where m.memberType = :type";
            List<Object[]> result = em.createQuery(query2)
//                    .setParameter("type", MemberType.ADMIN)
                    .getResultList();
            for (Object[] objects : result) {
                System.out.println(objects[0]);
                System.out.println(objects[1]);
                System.out.println(objects[2]);
                System.out.println(objects[3]);
            }

              // JPQL 함수
            String query4 = "select SIZE(t.members) from JpqlTeam t";
            Object singleResult = em.createQuery(query4).getSingleResult();
            System.out.println("select SIZE(t.members) from JpqlTeam t : "+singleResult);

//            //사용자 지정 함수
//            String query5 = "select function('group_concat', m.memberType) from JpqlMember m";
            String query5 = "select group_concat(m.memberType) from JpqlMember m";
            Object singleResult2 = em.createQuery(query5).getSingleResult();
            System.out.println("select function('group_concat', m.memberType) from JpqlMember m : "+singleResult2);

            //컬렉션
            String query6 = "select t.members from JpqlTeam t";
            List<Collection> result6 = em.createQuery(query6, Collection.class).getResultList();

            // 명시적 join
            String query7 = "select m.username from JpqlTeam t join t.members m";
            List<Object[]> result7 = em.createQuery(query7).getResultList();

            //fetch join
            String query8 = "select m  from JpqlMember m join fetch m.team";
            List<JpqlMember> result8 = em.createQuery(query8,  JpqlMember.class).getResultList();
            System.out.println(result8.size());
            for (JpqlMember member : result8) {
                System.out.println("["+member.getTeam().getName()+"] "+member.toString());
            }
*/

            //collection fetch join
//            String query9 = "select m  from JpqlTeam m join fetch m.members";
//            List<JpqlTeam> result9 = em.createQuery(query9,  JpqlTeam.class).getResultList();
//            System.out.println(result9.size());
//            int i= 0;
//            for (JpqlTeam team : result9) {
//                for(JpqlMember member : team.getMembers()){//team의 등록된 member 수만큼 즁복된다. bulk team의 회원수 36 * 36 (=1296)
//                    i++;
//                    System.out.println( i + " ["+team.getName()+"] "+ member.toString());
//                }
//            }

            //collection fetch join - distinct
//            String query10 = "select distinct t  from JpqlTeam t join fetch t.members";
//            List<JpqlTeam> result10 = em.createQuery(query10,  JpqlTeam.class).getResultList();
//            System.out.println(result10.size());
//            for (JpqlTeam team : result10) {
//                for(JpqlMember member : team.getMembers()){
//                    System.out.println("["+team.getName()+"] "+ member.toString());
//                }
//            }

            //collection batch-size 100 -> in절
//            String query11 = "select t  from JpqlTeam t";
//            List<JpqlTeam> result11 = em.createQuery(query11,  JpqlTeam.class).setFirstResult(0).setMaxResults(2).getResultList();
//            System.out.println(result11.size());
//            for (JpqlTeam team : result11) {
//                for(JpqlMember member : team.getMembers()){
//                    System.out.println("["+team.getName()+"] "+ member.toString());
//                }
//            }

            List<JpqlMember> result12 = em.createNamedQuery("JpqlMember.findByUserName", JpqlMember.class).setParameter("username", "PARK").getResultList();
            System.out.println(result12.size());
            for (JpqlMember member : result12) {
                System.out.println(member.toString());
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


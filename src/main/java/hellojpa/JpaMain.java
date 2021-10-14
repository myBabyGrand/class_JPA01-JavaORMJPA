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

//            Member findMember = em.find(Member.class,  member2.getId());
//            System.out.println(findMember.toString());
//            System.out.println(findMember.getTeam().toString());

//            System.out.println(findMember.getTeam()+"'s MemberList");
//            for(Member m : findMember.getTeam().getMembers()){
//                System.out.println(m.toString());
//            }

            //수정  A->B팀
//            findMember.enrollOrChangeTeam(team2);


//            Locker locker = new Locker();
//            locker.setName("A Locker");
//            locker.setMember(member2);
//            em.persist(locker);
            //Case0. proxy only
            Member refMember = em.getReference(Member.class,  3L);
            System.out.println("refMember.getClass() : "+ refMember.getClass());
            System.out.println("isLoaded : "+ emf.getPersistenceUnitUtil().isLoaded(refMember));//초기화 확인
//            refMember.getUsername();//강제 초기화
            Hibernate.initialize(refMember);//강제 초기화
            System.out.println("isLoaded : "+ emf.getPersistenceUnitUtil().isLoaded(refMember));//초기화 확인
            System.out.println("======");

            //Case1. proxy & real
            Member referenceMember = em.getReference(Member.class,  member.getId());
            System.out.println("referenceMember.getClass() : "+referenceMember.getClass());
            Member findMember = em.find(Member.class,  member.getId());// 프록시를 통해 실제에 접근함(어째뜬  프록시임)
            System.out.println("findMember.getClass()) : "+findMember.getClass());
            System.out.println(referenceMember.getClass() == findMember.getClass());
            System.out.println("======");

            //Case2. real & proxy
            Member findMember2 = em.find(Member.class,  member2.getId());//실제에 접근함
            System.out.println("findMember2.getClass() : "+findMember2.getClass());
            Member referenceMember2 = em.getReference(Member.class,  member2.getId());//실제에 이미 가져왔기에(영속성 컨텍스트에 있으므로) 굳이 proxy를 안씀
            System.out.println("referenceMember2.getClass() : "+referenceMember2.getClass());
            System.out.println(referenceMember2.getClass() == findMember2.getClass());

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


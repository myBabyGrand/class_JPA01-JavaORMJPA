package hellojpa;

import jpabook.jpashoop.domain.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member_OLD")
public class Member{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name", insertable = true, updatable = true)
    private String username;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;



    @Embedded
    private Period workPeriod;
    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city", column=@Column(name = "WORK_CITY"))
                        ,@AttributeOverride(name = "street", column=@Column(name = "WORK_STREET"))
                        ,@AttributeOverride(name = "zipcode", column=@Column(name = "WORK_ZIPCODE"))})
    private Address workAddress;


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")//일대다, 연관관계주인
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false) //다대일 양방향맵핑, 반대편이 주인임을 야매로 표기하기
    private Team team;

    //    @OneToOne
//    @JoinColumn(name = "LOCKER_ID") //일대일 주인
    @OneToOne(mappedBy = "member") //일대일 주인의 반대
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();


    public void enrollOrChangeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
}




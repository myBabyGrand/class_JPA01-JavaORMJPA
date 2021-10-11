package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", members='"+members + //stackoverflow by 양방향 맵핑
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @OneToMany(mappedBy = "team")//일대다 양방향맵핑, 주인의 반대, Read Only
//    @OneToMany //다대일, Team이 주인이다.
//    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package jpql;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "JPQL_MEMBER")
public class JpqlMember {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private LocalDateTime birth;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private JpqlTeam team;

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

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public JpqlTeam getTeam() {
        return team;
    }

    public void setTeam(JpqlTeam team) {
        this.team = team;
    }
}

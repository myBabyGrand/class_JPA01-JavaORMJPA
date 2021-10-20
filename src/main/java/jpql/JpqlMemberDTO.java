package jpql;

import java.time.LocalDateTime;

public class JpqlMemberDTO {
    private String username;
    private LocalDateTime birth;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "username='" + username + '\'' +
                ", birth=" + birth +
                '}';
    }

    public JpqlMemberDTO(String username, LocalDateTime birth) {
        this.username = username;
        this.birth = birth;
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
}

package JPA.TEST.Project.demo.DTO;

import JPA.TEST.Project.demo.entity.MemberEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDTO {

    private Long id;
    private String username;
    private String password;
    private String email;

    @Builder
    public MemberDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}

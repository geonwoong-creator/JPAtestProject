package JPA.TEST.Project.demo.entity;

import com.mysql.cj.protocol.x.Notice;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Data
public class MemberEntity extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menmber_id")
    private Long id;

  //  @NotBlank(message = "아이디를 입력해주세요.")
  //  @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "아이디를 3~12자로 입력해주세요. [특수문자X]")
    private String username;

 //   @NotBlank(message = "비밀번호를 입력해주세요.")
 //  @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$", message = "아이디를 3~12자로 입력해주세요.")
    private String password;
    private String email;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<NoticeEntity> notice = new ArrayList<>();

    @Builder
    public MemberEntity(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    protected MemberEntity() {}
}

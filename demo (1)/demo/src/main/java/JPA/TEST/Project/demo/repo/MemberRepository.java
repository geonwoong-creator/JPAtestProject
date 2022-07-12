package JPA.TEST.Project.demo.repo;

import JPA.TEST.Project.demo.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByUsername(String username);
    List<MemberEntity> findAll();
}

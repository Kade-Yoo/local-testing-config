package yoo.example.localtestingconfig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoo.example.localtestingconfig.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}

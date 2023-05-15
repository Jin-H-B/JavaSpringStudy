package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member memeber);
    Optional<Member> findById(Long id); // Optional은 null 처리
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

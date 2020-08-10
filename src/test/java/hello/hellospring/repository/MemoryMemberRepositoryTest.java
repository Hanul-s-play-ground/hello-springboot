package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MemoryMemberRepositoryTest {
    MemoryMemberRepository  repository = new MemoryMemberRepository();

    //note 테스터는 서로 의존관계 없이 작성되어야함.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("hanul");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("hanul1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("hanul2");
        repository.save(member2);

        Member result = repository.findByName("hanul2").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
     public void findAll() {
        Member member = new Member();
        member.setName("hanul1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("hanul2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}

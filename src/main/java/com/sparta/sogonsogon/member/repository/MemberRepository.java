package com.sparta.sogonsogon.member.repository;

import com.sparta.sogonsogon.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    //    Optional<Member> findMemberByMembernameContaining(String membername);
    Optional<Member> findByEmail(String email);

    @Query(
            value = "SELECT u FROM member u WHERE u.nickname LIKE %:nickname%"
    )
    List<Member> searchAllByNicknameLike(@Param(value = "nickname") String nickname);

    Optional<Member> findByMembername(String membername);

    List<Member> findAllByMembernameContaining(String membername);

    Optional<Member> findByKakaoId(Long kakaoId);

    int countByNickname(String nickname);


//    Optional<Member> findByNickname(String nickname);

    Optional<Member> findByNaverId(String naverId);

    Optional<Member> findMemberByMembername(String membername);
}
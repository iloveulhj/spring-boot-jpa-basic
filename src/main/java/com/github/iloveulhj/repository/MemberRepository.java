package com.github.iloveulhj.repository;

import com.github.iloveulhj.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
    Member findMemberByEmail(String email);

    Member findMemberByName(String name);
}

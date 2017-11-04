package com.github.iloveulhj.api.repository;

import com.github.iloveulhj.api.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
	Iterable<Member> findMembersByName(String name);
}

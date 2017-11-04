package com.github.iloveulhj;

import com.github.iloveulhj.api.entity.Member;
import com.github.iloveulhj.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitializeBean {
	@Autowired
	private MemberRepository memberRepository;

	@PostConstruct
	private void initData() {
		for (int index = 0; index < 10; index++) {
			Member member = new Member();
			member.setEmail("email#" + index + "@gmail.com");
			member.setName("name#" + index);
			member.setPassword("#"+index);
			memberRepository.save(member);
		}
	}
}

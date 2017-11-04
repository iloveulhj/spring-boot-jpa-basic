package com.github.iloveulhj;

import com.github.iloveulhj.api.entity.Member;
import com.github.iloveulhj.api.repository.MemberRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class InitializeBean {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private ResourceUrlProvider resourceUrlProvider;

	@PostConstruct
	private void initData() {
		for (int index = 0; index < 10; index++) {
			Member member = new Member();
			member.setEmail("email#" + index + "@gmail.com");
			member.setName("name#" + index);
			member.setPassword("#"+index);
			memberRepository.save(member);
		}

		log.info(resourceUrlProvider.getForLookupPath("/js/ajax.js"));
	}
}

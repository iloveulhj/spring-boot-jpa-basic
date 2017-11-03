package com.github.iloveulhj.controller.api;

import com.github.iloveulhj.entity.Member;
import com.github.iloveulhj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/members")
public class MembersApiController {
	@Autowired
	private MemberRepository memberRepository;

	@GetMapping
	public Iterable<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	@GetMapping(params = "email")
	public Member getMemberByEmail(@RequestParam String email) {
		return memberRepository.findMemberByEmail(email);
	}

	@GetMapping(params = "name")
	public Member getMemberByName(@RequestParam String name) {
		return memberRepository.findMemberByName(name);
	}

	@GetMapping("/{id}")
	public Member getMemberById(@PathVariable Integer id) {
		return memberRepository.findOne(id);
	}

	@PostMapping
	public String addMember(Member member) {
		memberRepository.save(member);
		return "register";
	}

	@PutMapping(path = "/{id}", params = {"name", "email"})
	public String editMember(Member member) {
		if (memberRepository.exists(member.getId())) {
			memberRepository.save(member);
			return "edit";
		}
		return "not exist";
	}

	@DeleteMapping(path = "/{id}")
	public String deleteMember(@PathVariable Integer id) {
		if (memberRepository.exists(id)) {
			memberRepository.delete(id);
			return "delete";
		}
		return "not exist";
	}
}
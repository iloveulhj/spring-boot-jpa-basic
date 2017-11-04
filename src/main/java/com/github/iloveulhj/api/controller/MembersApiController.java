package com.github.iloveulhj.api.controller;

import com.github.iloveulhj.api.entity.Member;
import com.github.iloveulhj.api.model.ApiResponse;
import com.github.iloveulhj.api.repository.MemberRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/members")
public class MembersApiController {
    @Autowired
    private MemberRepository memberRepository;

    @ApiOperation(value = "Get members", notes = "description...")
    @ApiParam(name = "name", type = "String")
    @GetMapping
    public ApiResponse getAllMembers() {
        Iterable<Member> members = memberRepository.findAll();

        ApiResponse apiResponse = ApiResponse.getSuccessResponse();
        apiResponse.getBody().put("members", members);
        return apiResponse;
    }

    @ApiOperation(value = "Get members by name", notes = "description...")
    @ApiIgnore
    @GetMapping(params = "name")
    public ApiResponse getMembersByName(@ApiParam(name = "name", required = true) @RequestParam String name) {
        Iterable<Member> members = memberRepository.findMembersByName(name);

        ApiResponse apiResponse = ApiResponse.getSuccessResponse();
        apiResponse.getBody().put("members", members);
        return apiResponse;
    }

    @ApiOperation(value = "Get member by email", notes = "description...")
    @GetMapping("/{email}")
    public ApiResponse getMemberByEmail(@PathParam("email") String email) {
        Member member = memberRepository.findOne(email);

        ApiResponse apiResponse = ApiResponse.getSuccessResponse();
        apiResponse.getBody().put("member", member);
        return apiResponse;
    }

    @ApiOperation(value = "Add member", notes = "description...")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse addMember(Member member) {
        memberRepository.save(member);
        return ApiResponse.getSuccessResponse();
    }

    @ApiOperation(value = "Edit member", notes = "description...")
    @PutMapping(path = "/{email}", params = {"name"})
    public ApiResponse editMember(Member member) {
        if (memberRepository.exists(member.getEmail())) {
            memberRepository.save(member);
            return ApiResponse.getSuccessResponse();
        }
        return ApiResponse.getFailResponse();
    }

    @ApiOperation(value = "Delete member", notes = "description...")
    @DeleteMapping(path = "/{email}")
    public ApiResponse deleteMember(@PathVariable String email) {
        if (memberRepository.exists(email)) {
            memberRepository.delete(email);
            return ApiResponse.getSuccessResponse();
        }
        return ApiResponse.getFailResponse();
    }
}
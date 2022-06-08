package com.springboot.serverbox.controller;

import com.springboot.serverbox.dto.MemberDto;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 예제 12.1
@RestController
@RequestMapping("/api/v1/crud-api")
public class CrudController {

    @GetMapping
    public String getName() {
        return "Flature";
    }

    @GetMapping(value = "/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }

    @GetMapping("/param")
    public String getNameWithParam(@RequestParam String name) {
        return "Hello. " + name + "!";
    }

    @PostMapping
    public ResponseEntity<MemberDto> getMember(
        @RequestBody MemberDto request,
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organization
    ) {
        System.out.println(request.getName());
        System.out.println(request.getEmail());
        System.out.println(request.getOrganization());

        MemberDto memberDto = new MemberDto();
        memberDto.setName(name);
        memberDto.setEmail(email);
        memberDto.setOrganization(organization);

        return ResponseEntity.status(HttpStatus.OK).body(memberDto);
    }

    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDto> addHeader(@RequestHeader("my-header") String header,
        @RequestBody MemberDto memberDTO) {

        System.out.println(header);

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }
}

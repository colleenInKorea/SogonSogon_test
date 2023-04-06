package com.sparta.sogonsogon.web.controller;

import com.sparta.sogonsogon.audioclip.service.AudioClipService;
import com.sparta.sogonsogon.member.dto.MemberOneResponseDto;
import com.sparta.sogonsogon.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private final MemberService memberService;

    @GetMapping("/profile")
    public List<MemberOneResponseDto> getProfile(){
        return memberService.getAll();
    }
}

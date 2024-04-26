package com.ict.edu2.members.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ict.edu2.members.service.MembersService;
import com.ict.edu2.members.vo.MembersVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MembersAPIController {

    @Autowired
    private MembersService membersService;
    
    @PostMapping("login.do")
    @ResponseBody
    public String postLogin(MembersVO mvo) {
        return membersService.postLogin(mvo);
    }
    
    @PostMapping("login2.do")
    @ResponseBody
    public MembersVO postLogin2(MembersVO mvo) {
        return membersService.postLogin2(mvo);
    }

    @PostMapping("join.do")
    @ResponseBody
    public String postJoin(MembersVO mvo) {
        System.out.println(mvo);
        return membersService.postJoin(mvo);
    }
    
}

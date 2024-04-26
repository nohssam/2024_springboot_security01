package com.ict.edu2.members.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ict.edu2.members.repository.MembersRepository;
import com.ict.edu2.members.vo.MembersVO;

@Service
public class MembersService {

    @Autowired
    private MembersRepository membersRepository;

    public String postLogin(MembersVO mvo){
        MembersVO m_vo = membersRepository.postLogin(mvo); 
        if(m_vo == null){
            return "0";
        }else{
            return "1";
        }
    }
    public MembersVO postLogin2(MembersVO mvo){
        MembersVO m_vo = membersRepository.postLogin(mvo); 
        if(m_vo != null){
            return m_vo;
        }
        return null;
    }

    public String postJoin(MembersVO mvo) {
        int result = membersRepository.postJoin(mvo);
        return String.valueOf(result);
    }
}

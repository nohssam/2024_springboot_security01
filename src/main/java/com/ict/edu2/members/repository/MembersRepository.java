package com.ict.edu2.members.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ict.edu2.members.vo.MembersVO;

@Mapper
public interface MembersRepository {
    @Select("select * from members order by m_idx")
    List<MembersVO> getMembersList();

    MembersVO postLogin(MembersVO mvo);

    int postJoin(MembersVO mvo) ;

}


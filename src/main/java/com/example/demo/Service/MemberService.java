package com.example.demo.Service;

import com.example.demo.Model.Member;
import com.example.demo.Repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MemberService {
    private final MemberRepository memberRepository=new MemberRepository();

    public List<Member> getallMember() {
        return memberRepository.getallmember();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.getmemberByid(id);
    }

    public Member addMember(Member member) {
        return memberRepository.addmember(member);
    }

    public Member updateMember(Member member) {
        if (member.getId() == null) {
            return null;
        }
        return memberRepository.updatemember(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deletemember(id);
    }
}

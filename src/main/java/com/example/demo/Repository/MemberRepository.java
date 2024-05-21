package com.example.demo.Repository;

import com.example.demo.Model.Member;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemberRepository {
    private Map<Long, Member> members;
    private long current_id;

    public MemberRepository() {
        this.members = new HashMap<Long, Member>();
    }

    public List<Member> getallmember() {
        return new ArrayList<Member>(members.values());
    }

    public Optional<Member> getmemberByid(Long id) {
        return Optional.ofNullable(members.get(id));
    }

    public Member addmember(Member member) {
        member.setId(++current_id);
        return members.put(member.getId(), member);
    }

    public Member updatemember(Member member) {
        if (members.containsKey(member.getId())) {
            return members.put(member.getId(), member);
        }
        return null;
    }

    public void deletemember(Long id) {
        members.remove(id);
    }
}
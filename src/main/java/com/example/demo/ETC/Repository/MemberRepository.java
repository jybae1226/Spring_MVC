package com.example.demo.ETC.Repository;

import com.example.demo.ETC.Model.Member;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemberRepository {
    private Map<Long, Member> members;
    private long current_id=1;

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
        member.setId(current_id++);
        return members.put(member.getId(), member);
    }

    public Member updatemember(Long id, Member member) {
        if (members.containsKey(id)) {
            return members.put(id, member);
        }
        return null;
    }

    public void deletemember(Long id) {
        members.remove(id);
    }
}

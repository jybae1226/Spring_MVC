package com.example.demo.Controller;

import com.example.demo.Model.Article;
import com.example.demo.Model.Member;
import com.example.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private final Map<Long, Member> members = new HashMap<>();

    @GetMapping
    public ResponseEntity<Map<Long,Member>> getAllMembers() {
        List<Member> members=memberService.getallMember();
        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Map<Long, Member> map = new HashMap<>();
            for (Member member : members) {
                map.put(member.getId(), member);
            }
            return ResponseEntity.ok().body(map);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = members.get(id);
        if (member != null) {
            return ResponseEntity.ok().body(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Member> createtMember(@RequestBody Member member) {
        Member created= memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        if(!members.containsKey(id)) {
            member.setId(id);
            Member updated = memberService.updateMember(id, member);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        if(members.containsKey(id)) {
            memberService.deleteMember(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
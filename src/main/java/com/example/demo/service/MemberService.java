package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Member;

public interface MemberService {
    String greet(int i);
    List<Member> getAll();
}

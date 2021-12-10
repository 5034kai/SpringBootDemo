package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Member;

public class MemberServiceImpl implements MemberService{
    private static MemberServiceImpl singleton = new MemberServiceImpl();
    private MemberServiceImpl(){};
    public static MemberServiceImpl getInstance(){
        return singleton;
    }

    @Override
    public String greet(int i){
        String[] greetings = {"Mornig", "Hello", "evening"};
        return greetings[i];
    }

    @Override
    public List<Member> getAll(){
        List<Member> list = new ArrayList<>();
        Member mem = new Member(1, "linda", "lindapgmail.com");
        Member mem2 = new Member(2, "nda", "dapgmail.com");
        list.add(mem);
        list.add(mem2);

        return list;
    }
}

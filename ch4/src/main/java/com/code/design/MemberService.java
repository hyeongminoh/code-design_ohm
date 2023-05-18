package com.code.design;

import java.io.IOException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    //예외처리를 잘하자
    //objectMapper
    //checked exception: 반드시 예외 처리 해야 함, rollback x, IOException, SQLException
    //unchecked exception: 예외 처리 하지 않아도 됨, Rollback O, NullPointerException IllegalArgumentException
    private final MemberRepository memberRepository;

    public Member createUncheckedException() {
        final Member member = memberRepository.save(new Member("yun"));
        if (true) {
            throw new RuntimeException();
        }
        return member;
    }

    public Member createCheckedException() throws IOException {
        final Member member = memberRepository.save(new Member("wan"));
        if (true) {
            throw new IOException();
        }
        return member;
    }

    public Member findById(long id) {
        return memberRepository.findById(id).get();
    }

}

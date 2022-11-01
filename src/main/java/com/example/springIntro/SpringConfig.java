package com.example.springIntro;

import com.example.springIntro.repository.JdbcMemberRepository;
import com.example.springIntro.repository.JdbcTemplateMemberRepository;
import com.example.springIntro.repository.JpaMemberRepository;
import com.example.springIntro.repository.MemberRepository;
import com.example.springIntro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
    //@Autowired
    //public SpringConfig (DataSource dataSource) {
    //    this.dataSource = dataSource;
    //}

    private EntityManager entityManager;

    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(entityManager);
    }
}
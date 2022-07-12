package JPA.TEST.Project.demo.service;


import JPA.TEST.Project.demo.DTO.MemberDTO;
import JPA.TEST.Project.demo.entity.MemberEntity;
import JPA.TEST.Project.demo.entity.Role;
import JPA.TEST.Project.demo.repo.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;


    public List<MemberEntity> findAll(){
        return memberRepository.findAll();
    }


    @Transactional
    public Long joinUser(MemberDTO memberDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        return memberRepository.save(memberDTO.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> findName = memberRepository.findByUsername(username);
        MemberEntity member = findName.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin").equals(username)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }
        return new User(member.getUsername(), member.getPassword(), authorities);
    }



}

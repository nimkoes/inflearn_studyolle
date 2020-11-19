package me.nimkoes.studyolle.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {
    
    @Id @GeneratedValue
    private Long id;
    
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String nickname;
    
    private String password;
    
    private boolean emailVerified;
    
    private String emailCheckToken;
    
    private LocalDateTime joindAt;
    
    private String bio;
    
    private String url;
    
    private String occupation;
    
    private String location;
    
    /*
     * String type 은 기본적은 VARCHAR(255) 로 생성
     * profile image 는 그것보다 더 길 수 있기 때문에 Lob 사용
     */
    @Lob @Basic(fetch = FetchType.EAGER)
    private String profileImage;
    
    private boolean studyCreatedByEmail;
   
    private boolean studyCreatedByWeb;
    
    private boolean studyEnrollmentResultByEmail;
    
    private boolean studyEnrollmentResultByWeb;
    
    private boolean studyUpdatedByEmail;
    
    private boolean studyUpdatedResultByWeb;
    
}

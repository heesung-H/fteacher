package com.enola.fteacher.entity;

import com.enola.fteacher.common.CommonBuilder;
import com.enola.fteacher.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="USERS")
public class Users {
    @Id
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="USERS_SEQ_GN"
    )
    private Long idx;
    private String nm;
    private String gender;

    @Column(name="phone_number")
    private String phoneNumber;

    /* Users 생성자 빌더패턴 적용  */
    private Users(UsersBuilder builder) {
        this.idx = builder.idx;
        this.nm = builder.nm;
        this.gender = builder.gender;
        this.phoneNumber = builder.phoneNumber;
    }

    /* 기본생성자 */
    public Users() {}

    /**
     * Users 클래스의 빌더 클래스
     */
    public static class UsersBuilder implements CommonBuilder<Users> {
        private final Long idx;
        private final String nm;
        private final String gender;
        private final String phoneNumber;

        /* 생성자 */
        public UsersBuilder(UserDTO userDTO) {
            this.idx = userDTO.getIdx();
            this.nm = userDTO.getNm();
            this.gender = userDTO.getGender();
            this.phoneNumber = userDTO.getPhoneNumber();
        }

        /* build 메소드 호출로 Users 객체 리턴 */
        @Override
        public Users build(){
            return new Users(this);
        }
    }
}
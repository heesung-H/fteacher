package com.enola.fteacher.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserDTO {

    private Long idx;
    private String nm;
    private String gender;
    private String phoneNumber;

}

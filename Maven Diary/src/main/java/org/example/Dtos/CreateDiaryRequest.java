package org.example.Dtos;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CreateDiaryRequest {
    private String username;
    private String password;
    private boolean isLogin;


}

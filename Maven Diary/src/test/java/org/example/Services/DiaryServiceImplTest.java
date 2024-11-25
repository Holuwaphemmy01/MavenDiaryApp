package org.example.Services;

import org.example.Dtos.CreateDiaryRequest;
import org.example.Repository.DiaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
public class DiaryServiceImplTest {

    @Autowired
    private CreateDiaryRequest createDiaryRequest1;
    @Autowired
    private DiaryServiceImpl diaryService;
    @Autowired
    private DiaryRepository diaryRepository;

    @BeforeEach
    public void  setUp() {
        diaryRepository.deleteAll();
    }


    @Test
    public void testToRegisterUserXAndItIsSuccessfully(){
        createDiaryRequest1.setUsername("username");
        createDiaryRequest1.setPassword("password");
        assertEquals("Account created successfully", diaryService.registerDiary(createDiaryRequest1));
    }

    @Test
    void testThatUserNameCannotBeRegisteredTwice(){
        createDiaryRequest1.setUsername("username");
        createDiaryRequest1.setPassword("password");
        diaryService.registerDiary(createDiaryRequest1);
        CreateDiaryRequest createDiaryRequest2 = new CreateDiaryRequest();
        createDiaryRequest2.setUsername("username");
        createDiaryRequest2.setPassword("password");
        assertThrows(IllegalArgumentException.class, ()-> diaryService.registerDiary(createDiaryRequest2));
    }

    @Test
    void testThatPasswordCannotBeNull(){
        createDiaryRequest1.setUsername("username");
        createDiaryRequest1.setPassword("");
        assertThrows(IllegalArgumentException.class, ()-> diaryService.registerDiary(createDiaryRequest1));
    }

    @Test
    void testThatUserNameCannotBeEmpty(){
        createDiaryRequest1.setUsername("");
        createDiaryRequest1.setPassword("");
        assertThrows(IllegalArgumentException.class, ()-> diaryService.registerDiary(createDiaryRequest1));
    }

    @Test
    void testToRegisterUserAndLoginUserWithCorrectUserNameAndPassword(){
        createDiaryRequest1.setUsername("username");
        createDiaryRequest1.setPassword("password");
        assertEquals("Account created successfully", diaryService.registerDiary(createDiaryRequest1));
        diaryService.login(createDiaryRequest1);
        System.out.println(createDiaryRequest1.isLogin());
        assertFalse(createDiaryRequest1.isLogin());
    }

    @Test
    void testToRegisterUserAndNotToLoginUserWithWrongUserName(){
        createDiaryRequest1.setUsername("username");
        createDiaryRequest1.setPassword("password");
        assertEquals("Account created successfully", diaryService.registerDiary(createDiaryRequest1));
        createDiaryRequest1.setUsername("wrongUsername");
        assertThrows(IllegalArgumentException.class, ()-> diaryService.login(createDiaryRequest1));
    }

    @Test
    void testToRegisterUserAndNotToLoginUserWithWrongPassword(){
        createDiaryRequest1.setUsername("username");
        createDiaryRequest1.setPassword("password");
        assertEquals("Account created successfully", diaryService.registerDiary(createDiaryRequest1));
        createDiaryRequest1.setPassword("wrongPassword");
        assertThrows(IllegalArgumentException.class, ()-> diaryService.login(createDiaryRequest1));
    }



}
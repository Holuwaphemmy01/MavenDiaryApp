package org.example.Services;

import org.example.Dtos.CreateDiaryRequest;
import org.example.Repository.DiaryRepository;
import org.example.model.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiaryServiceImpl implements DiaryService{

    @Autowired
    private DiaryRepository diaryRepository;

    public String registerDiary(CreateDiaryRequest createDiaryRequest) {
        Diary diary = new Diary();
        diary.setUsername(createDiaryRequest.getUsername());
        diary.setPassword(createDiaryRequest.getPassword());
        if(diary.getUsername().isEmpty()) throw new IllegalArgumentException("Username cannot be empty");
        if(diary.getPassword()==null || diary.getPassword().isEmpty()) throw new IllegalArgumentException("Password is empty");
        if(diaryRepository.existsById(diary.getUsername())) throw new IllegalArgumentException("Username already exists");
        diaryRepository.save(diary);
        return  "Account created successfully";
    }

    @Override
    public void login(CreateDiaryRequest createDiaryRequest1) {
        Diary diary = new Diary();
        diary.setUsername(createDiaryRequest1.getUsername());
        diary.setPassword(createDiaryRequest1.getPassword());
        Optional<Diary> result =  diaryRepository.findById(diary.getUsername());
        if(result.isPresent()) {
            if(result.get().getPassword().equals(diary.getPassword())){
                diary.setLogin(true);
            }
            else throw new IllegalArgumentException("Username and password do not match");
        }
        else throw new IllegalArgumentException("Username and password do not match");
    }


}

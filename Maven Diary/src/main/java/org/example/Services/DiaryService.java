package org.example.Services;

import org.example.Dtos.CreateDiaryRequest;



public interface DiaryService {
    String registerDiary(CreateDiaryRequest createDiaryRequest);
    void login(CreateDiaryRequest createDiaryRequest1);
}

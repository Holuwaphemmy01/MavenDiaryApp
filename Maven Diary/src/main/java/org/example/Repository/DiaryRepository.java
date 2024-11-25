package org.example.Repository;

import org.example.model.Diary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DiaryRepository extends MongoRepository<Diary, String> {


}

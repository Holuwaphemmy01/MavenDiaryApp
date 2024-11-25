package org.example.Repository;

import org.example.model.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface EntryRepository extends MongoRepository<Entry, String> {


}

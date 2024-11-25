package org.example.Services;

import org.example.Dtos.CreateEntryRequest;
import org.example.Repository.EntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EntryServiceImplTest {

    @Autowired
    private EntryService entryService;

    @Autowired
    private EntryRepository entryRepository;

    @BeforeEach
    void setUp() {
        entryRepository.deleteAll();
    }


    @Test
    public void testToCreateEntryAndEntryIdIs1(){
        CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setUsername("username");
        createEntryRequest.setContent("content");
        createEntryRequest.setTitle("title");
        assertEquals(1, entryService.addEntry(createEntryRequest));
    }

    @Test
    public void testToCreateTwoEntryAndEntryIdIsNotTheSame(){
        CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setUsername("username");
        createEntryRequest.setContent("content");
        createEntryRequest.setTitle("title");
        long firstId = entryService.addEntry(createEntryRequest);
        CreateEntryRequest createEntryRequest2 = new CreateEntryRequest();
        createEntryRequest2.setUsername("username");
        createEntryRequest2.setContent("content2");
        createEntryRequest2.setTitle("title2");
        long secondId = entryService.addEntry(createEntryRequest2);
        assertNotEquals(firstId, secondId);
    }

    @Test
    public void testToCreateEntriesForUserAAndOneEntry(){ }
}
package org.example.Services;

import org.example.Dtos.CreateEntryRequest;
import org.example.Repository.EntryRepository;
import org.example.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public long addEntry(CreateEntryRequest createEntryRequest) {
        Entry entry = new Entry();
        createEntryRequest.setId(entryRepository.count()+1);
        entry.setTitle(createEntryRequest.getTitle());
        entry.setContent(createEntryRequest.getContent());
        entry.setUsername(createEntryRequest.getUsername());
        entry.setId((int) createEntryRequest.getId());
        return entryRepository.save(entry).getId();
    }

    @Override
    public long countTotalEntries(String username) {
        return 0;
    }

    @Override
    public List<Entry> getAllEntries(String username) {
        return List.of();
    }
}

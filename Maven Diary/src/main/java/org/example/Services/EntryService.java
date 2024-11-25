package org.example.Services;

import org.example.Dtos.CreateEntryRequest;
import org.example.model.Entry;

import java.util.List;

public interface EntryService {
    long addEntry(CreateEntryRequest createEntryRequest);
    long countTotalEntries(String username);
    List<Entry> getAllEntries(String username);
   // EntryResponse findByEntryId(String username, long id);
}

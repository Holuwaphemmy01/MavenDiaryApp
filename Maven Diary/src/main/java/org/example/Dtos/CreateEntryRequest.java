package org.example.Dtos;

import lombok.Data;

@Data
public class CreateEntryRequest {
    private String username;
    private String title;
    private String content;
    private long id;


}

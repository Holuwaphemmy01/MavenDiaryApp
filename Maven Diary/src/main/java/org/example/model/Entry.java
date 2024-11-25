package org.example.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@Document
public class Entry {
    private String username;
    @Id
    private int id;
    private String title;
    private String content;




}

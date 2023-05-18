package com.example.demo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="bookss")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BOOK {
    @Id
    private ObjectId _id;
    @NotNull(message = "id cannot be null")
    private int id;
    @NotNull(message = "title cannot be null")
    private  String title;
    private  String isbn;
    @NotNull
    private  int pageCount;
    private String publishedDate;
    private  String thumbanilUrl;
    private  String shortDescription;
    private  String longDescription;
    private  String status;
    private List<String> authors;
    private List<String> categories;

    public BOOK(String longDescription) {
        this.longDescription = longDescription;
    }
}


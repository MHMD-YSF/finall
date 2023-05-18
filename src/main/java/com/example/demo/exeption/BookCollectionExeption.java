package com.example.demo.exeption;

import org.bson.types.ObjectId;

public class BookCollectionExeption extends Exception {
    public BookCollectionExeption(String message){
        super(message);
    }

    public static  String NotFoundException(String id){
        return "Book with "+id+"not found";
    }
    public static String BookAlreadyExists(){
        return  "book with given title already exists";
    }
    public static  String NotFoundException(ObjectId id){
        return "Book with "+id+"not found";
    }
}

package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<BOOK,ObjectId> {
    @Query("{'title': ?0}")
 Optional<BOOK> findByTitle(String title);
 List<BOOK> findBytitle( String title);

    List<BOOK> findByCategoriesContaining(String categories);
}

package com.example.demo;

import com.example.demo.exeption.BookCollectionExeption;
import jakarta.validation.ConstraintViolationException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BOOK> allBooks() {
        return bookRepository.findAll();

    }
    public Optional<BOOK> singleBook(ObjectId id) {
        return bookRepository.findById(id);
    }
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<BOOK> getAllBooksSortedById() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return bookRepository.findAll(sort);
    }

    public List<BOOK> getAllBooksSortedByPageCount() {
        Sort sort = Sort.by(Sort.Direction.ASC, "pageCount");
        return bookRepository.findAll(sort);
    }

    public List<BOOK> getAllBooksSortedByTitle() {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        return bookRepository.findAll(sort);
    }


public void createBook(BOOK book) throws ConstraintViolationException, BookCollectionExeption
{
    Optional<BOOK>  bookOptional=bookRepository.findByTitle(book.getTitle()) ;
    if (bookOptional.isPresent()){
        throw new BookCollectionExeption(BookCollectionExeption.BookAlreadyExists());
    }else{

        bookRepository.save(book);
    }
}
public List<BOOK>getAllBook(){
    List<BOOK> bookss=  bookRepository.findAll();
    if (bookss.size()>0){
        return bookss;
    }else {
        return  new ArrayList<BOOK>();
    }
 }
public BOOK getSinglebook(ObjectId id) throws  BookCollectionExeption{
    Optional<BOOK> optionalBOOK=  bookRepository.findById(id);
    if(!optionalBOOK.isPresent()) {
        throw new BookCollectionExeption(BookCollectionExeption.NotFoundException(id));
    }else {return optionalBOOK.get();
    }
    }
List<BOOK>getBookByTitle( String title){
    return bookRepository.findBytitle(title);

}
    public List<BOOK> getBooksByCategory(String category) {
        return bookRepository.findByCategoriesContaining(category);
    }

}

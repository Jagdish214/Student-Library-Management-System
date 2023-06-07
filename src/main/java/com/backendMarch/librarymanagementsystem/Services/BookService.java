package com.backendMarch.librarymanagementsystem.Services;



import com.backendMarch.librarymanagementsystem.DTOs.BookRequestDto;
import com.backendMarch.librarymanagementsystem.Entity.Author;
import com.backendMarch.librarymanagementsystem.Entity.Book;
import com.backendMarch.librarymanagementsystem.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;


    public String addBook(BookRequestDto bookRequestDto){

        //I want to get the AuthorEntity ???
        int authorId  = bookRequestDto.getAuthorId();

        //Now I will be fetching the authorEntity

        Author author = authorRepository.findById(authorId).get();


        //Convertor
        //We have created this Entity so that we can save it into the DB.
        Book book = new Book();

        //Basic attributes are being from Dto to the Entity Layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());


        book.setAuthor(author);



        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);


        authorRepository.save(author);

        return "Book Added successfully";

    }
}

package com.jq.spbAction.controller;

import com.jq.spbAction.dao.ReadingListRepository;
import com.jq.spbAction.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private ReadingListRepository readingListRepository;


    @GetMapping("/{reader}")
    public String readerList(@PathVariable String reader, Model model) {
        List<Book> byReader = readingListRepository.findByReader(reader);
        model.addAttribute("bookList", byReader);
        model.addAttribute("reader", reader);
        return "bookList";
    }

    @PostMapping("/{reader}")
    public String addToList(Book book, @PathVariable String reader) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/book/"+reader;
    }
}

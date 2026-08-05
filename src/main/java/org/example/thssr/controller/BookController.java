package org.example.thssr.controller;

import lombok.RequiredArgsConstructor;
import org.example.thssr.dto.BookFormDTO;
import org.example.thssr.model.entity.BookEntity;
import org.example.thssr.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public String page(Model model, @RequestParam(required = false) String keyword) {
        model.addAttribute("keyword", keyword);
        if (keyword != null) {
            model.addAttribute("books", bookService.search(keyword));
        } else {
            model.addAttribute("books", bookService.findAll());
        }
        return "index";
    }

    @ModelAttribute("categories")
    public List<String> categories() {
        return List.of("소설", "비문학", "문제집");
    }

    @GetMapping("/new")
    // import org.springframework.ui.Model;
    public String newBook(Model model) {
        model.addAttribute("bookForm", BookFormDTO.builder().build());
        model.addAttribute("editMode", false);
        model.addAttribute("formAction", "/books");
        return "form";
    }
    @PostMapping
    public String createBook(
            @ModelAttribute("bookForm") BookFormDTO bookFormDTO) {
        bookService.createBook(bookFormDTO.toEntity());
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable long id, Model model) {
        model.addAttribute("bookForm", BookFormDTO.fromEntity(bookService.findById(id)));
        model.addAttribute("editMode", true);
        model.addAttribute("formAction", "/books/" + id);
        return "form";
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable long id, @ModelAttribute("bookForm") BookFormDTO bookFormDTO) {
        bookService.updateBook(id, bookFormDTO);
        return "redirect:/books/{id}";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable long id, Model model) {
        model.addAttribute("bookData", bookService.findById(id));
        return "detail";
    }
}

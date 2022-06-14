package pl.coderslab.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/book-form")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {

        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", bookRepository.findById(id).get());
        return "book/edit";
    }

    @PostMapping("/edit")
    public String update(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherDao.findAll());
            return "book/edit";
        }
        bookRepository.save(book);

        return "redirect:/book-form/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Book book = new Book();
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", book);
        return "book/add";
    }

    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherDao.findAll());
            return "book/add";
        }
        bookRepository.save(book);

        return "redirect:/book-form/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.getList());
        return "book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookRepository.deleteById(id);
        return "redirect:/book-form/list";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(Model model) {
        bookRepository.findByTitle("dsa as da s")
                .stream()
                .map(b->b.getId())
                .collect(Collectors.toList())
                .forEach(id->log.debug("id : {}", id));
        return "test";
    }

}

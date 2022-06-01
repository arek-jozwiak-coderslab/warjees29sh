package pl.coderslab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.Book;
import pl.coderslab.student.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@Slf4j
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validate")
    public String testValidate(Model model) {
       Book book = new Book();

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        model.addAttribute("constraintViolations", constraintViolations);

        return "validate";
    }

}

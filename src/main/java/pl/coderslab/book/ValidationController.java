package pl.coderslab.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public String testValidate() {
       Book book = new Book();

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

        if (constraintViolations.isEmpty()) {

        } else {
            for (ConstraintViolation<Book> constraintViolation : constraintViolations) {
                log.debug("path {}", constraintViolation.getPropertyPath());
                log.debug("getMessage {}", constraintViolation.getMessage());
            }

        }

        return "ok";
    }

}

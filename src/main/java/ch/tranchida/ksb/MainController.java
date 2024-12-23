package ch.tranchida.ksb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @Value("${environment}")
    private String environment = "not set";


    @GetMapping("/")
    public String index() {
        return "Hello World from " + environment + " !";
    }


}

package API;


import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class GreetingController {

//    @PreAuthorize()
    @RequestMapping(value = "/greetings", method = GET)
    public String greetings(@RequestParam(value = "name", required = false) String name) {
        if(name == null) {
            return "Who are you?";
        } else {
            System.out.println("Hello, there " + name);
            return "Hi, how are you " + name + ".";
        }
    }

    @RequestMapping(value = "/greetings/{personId}", method = GET)
    public String mingleWithPerson(@PathVariable Integer personId) {
        switch (personId){
            case 1: return "Bardur";
            case 2: return "Bogi";
            case 3: return "Søren";
            default: return "Anders";
        }
    }


    @RequestMapping(value = "/getBody", method = POST)
    public String showBody(@RequestBody String body) {
        System.out.println(body);
        return "You said: " + body;
    }



}
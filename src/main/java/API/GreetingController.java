package API;


import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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


    @RequestMapping(value = "/getJSONPerson", method = GET)
    public JSONPerson getJSONPerson() {
        JSONPerson jsonPerson = new JSONPerson("Anders Latif", 28, "mentiroso");
        return jsonPerson;
    }



    static class JSONPerson {

        String name;
        int age;
        String catchPhrase;

        JSONPerson(String name, int age, String catchPhrase) {
            this.name = name;
            this.age = age;
            this.catchPhrase = catchPhrase;
        }
    }

}
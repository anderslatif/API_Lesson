package API;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
    public class GreetingControllerII {




    // url parameter
    @RequestMapping(value = "/greetings", method = GET)
    public String greeting(@RequestParam(value = "name", required = true) String name) {

        System.out.println("Hello " + name + " from the console ");

        return "How do you do, " + name + ".";
    }


// show @PreAuthorize()
// @Transactional(rollbackFor = Throwable.class)


    // path variable
    @RequestMapping(value = "/greetings/{personId}", method = GET)
    public String getPersonById(@PathVariable Integer personId) {

        switch (personId) {
            case 1: return "Hello person 1";
            case 2: return "Hello person 2";
            case 3: return "Hello person 3";
            default: return "Hello Anders";
        }
    }



    @RequestMapping(value = "/getJSON", method = GET)
    public JSONPerson getJSON() {
        JSONPerson showJSON = new JSONPerson(28, "Anders", "Latif");
        return showJSON;
    }

    private static class JSONPerson {

        private int age;
        private String firstName;
        private String lastName;

        JSONPerson(int age, String firstName, String lastName) {
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
        }

    }


    @RequestMapping(value = "/sendingBodyToAPI", method = POST)
    public String showPost(@RequestBody String sendingBodyToAPI) {
        System.out.println(sendingBodyToAPI);
        return sendingBodyToAPI;
    }



}

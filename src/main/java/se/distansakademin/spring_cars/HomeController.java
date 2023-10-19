package se.distansakademin.spring_cars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/") // This function shows the start page
    public String getHome(Model model){

        // Connect to the db
        Database db = new Database();

        // Get all cars from database
        List<Car> cars = db.getCars();

        // Send cars to template
        model.addAttribute("cars", cars);

        // Show home template
        return "home";
    }

    @PostMapping("/")
    public String postHome(String make, String model, int year){
        // Create new car from parameters
        Car car = new Car(make, model, year);

        // Connect to the db
        Database db = new Database();

        // Save new car to the db
        db.saveCar(car);

        // Point back to start page
        return "redirect:/";
    }
}

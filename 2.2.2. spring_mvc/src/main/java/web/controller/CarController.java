package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarService;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String CarList(Model model, HttpServletRequest request) {
        List<Car> cars2 = carService.CarList();
        String counter = request.getParameter("count");
        switch(counter) {
            case("1"):
                cars2 = cars2.subList(0, 1);
                break;
            case("2"):
                cars2 = cars2.subList(0, 2);
                break;
            case("3"):
                cars2 = cars2.subList(0, 3);
                break;
            case("4"):
                cars2 = cars2.subList(0, 4);
                break;
        }
        model.addAttribute("cars", cars2);
        return "second";
    }
}
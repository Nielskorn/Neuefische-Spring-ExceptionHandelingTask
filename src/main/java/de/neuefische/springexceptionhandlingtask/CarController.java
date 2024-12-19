package de.neuefische.springexceptionhandlingtask;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping("/{brand}")
    String getCarBrand(@PathVariable String brand) {
        if (!brand.equals("porsche")) {
            throw new IllegalArgumentException("Only 'porsche' allowed");
        }
        return brand;
    }

    @GetMapping
    String getAllCars() {
        throw new NoSuchElementException("No Cars found");
    }

//    @ExceptionHandler(Exception.class)
//    public String exceptionHandler(Exception ex)
//    {
//    return ex.getMessage();
//    }
@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
public String handleIllegalArgumentException(IllegalArgumentException e)
{
    return e.getMessage();
}

}

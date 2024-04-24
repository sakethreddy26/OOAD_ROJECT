package com.yourcompany.vehiclerentalsystem.controller;

import com.yourcompany.vehiclerentalsystem.model.Booking;
import com.yourcompany.vehiclerentalsystem.repository.BookingRepository;
import com.yourcompany.vehiclerentalsystem.repository.CarRepository;
import com.yourcompany.vehiclerentalsystem.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaveBookingController {

    @Autowired
    private BookingRepository bookingRepository;

    

    @PostMapping("/saveBooking")
    public ModelAndView saveBooking(@RequestParam("carMake") String carMake,
                                    @RequestParam("carModel") String carModel,
                                    @RequestParam("carYear") String carYear,
                                    @RequestParam("carImageLink") String carImageLink,
                                    @RequestParam("driverName") String driverName,
                                    @RequestParam("driverLicenseNumber") String driverLicenseNumber,
                                    @RequestParam("username") String username,
                                    @RequestParam("from") String from,
                                    @RequestParam("to") String to) {


        // Create a new Booking entity and populate it with the received data
        Booking booking = new Booking();
        booking.setCarMake(carMake);
        booking.setCarModel(carModel);
        booking.setCarYear(carYear);
        booking.setCarImageLink(carImageLink);
        booking.setDriverName(driverName);
        booking.setDriverLicenseNumber(driverLicenseNumber);
        booking.setUsername(username);
        booking.setFrom(from);
        booking.setTo(to);

        // Save the booking entity to the Booking repository
        bookingRepository.save(booking);

        // Redirect to confirmation page after saving
        return new ModelAndView("redirect:/confirmation");
    }
}

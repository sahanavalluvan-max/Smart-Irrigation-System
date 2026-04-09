
package com.smartagri.controller;

import com.smartagri.model.SensorData;
import com.smartagri.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensor")
@CrossOrigin
public class SensorController {

    @Autowired
    private SensorService service;

    @PostMapping
    public SensorData receiveData(
            @RequestParam double moisture,
            @RequestParam double temp,
            @RequestParam double humidity) {

        return service.processData(moisture, temp, humidity);
    }
}

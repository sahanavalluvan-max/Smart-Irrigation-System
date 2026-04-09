
package com.smartagri.service;

import com.smartagri.model.SensorData;
import com.smartagri.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SensorService {

    @Autowired
    private SensorRepository repository;

    public SensorData processData(double moisture, double temp, double humidity) {

        String motorStatus = (moisture < 30) ? "ON" : "OFF";

        SensorData data = new SensorData();
        data.setMoisture(moisture);
        data.setTemperature(temp);
        data.setHumidity(humidity);
        data.setMotorStatus(motorStatus);
        data.setTimestamp(LocalDateTime.now());

        return repository.save(data);
    }
}

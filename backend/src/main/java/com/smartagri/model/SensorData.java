
package com.smartagri.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double moisture;
    private double temperature;
    private double humidity;
    private String motorStatus;
    private LocalDateTime timestamp;

    public Long getId() { return id; }
    public double getMoisture() { return moisture; }
    public void setMoisture(double moisture) { this.moisture = moisture; }
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }
    public String getMotorStatus() { return motorStatus; }
    public void setMotorStatus(String motorStatus) { this.motorStatus = motorStatus; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}

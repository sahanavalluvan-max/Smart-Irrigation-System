
package com.smartagri.repository;

import com.smartagri.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<SensorData, Long> {
}

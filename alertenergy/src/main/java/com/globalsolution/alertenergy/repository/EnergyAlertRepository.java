package com.globalsolution.alertenergy.repository;

import com.globalsolution.alertenergy.model.EnergyAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyAlertRepository extends JpaRepository<EnergyAlert, Long> {
}

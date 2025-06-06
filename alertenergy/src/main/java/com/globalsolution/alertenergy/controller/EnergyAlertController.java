package com.globalsolution.alertenergy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalsolution.alertenergy.model.EnergyAlert;
import com.globalsolution.alertenergy.service.EnergyAlertService;
@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/alerts")
public class EnergyAlertController {

    @Autowired
    private EnergyAlertService service;

    @PostMapping
    public EnergyAlert createAlert(@RequestBody EnergyAlert alert) {
        return service.saveAlert(alert);
    }

    @GetMapping
    public List<EnergyAlert> getAllAlerts() {
        return service.getAllAlerts();
    }

    @GetMapping("/{id}")
    public Optional<EnergyAlert> getAlertById(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    @PutMapping("/{id}")
    public EnergyAlert updateAlert(@PathVariable Long id, @RequestBody EnergyAlert alert) {
        return service.updateAlert(id, alert);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable Long id) {
        service.deleteAlert(id);
    }
}

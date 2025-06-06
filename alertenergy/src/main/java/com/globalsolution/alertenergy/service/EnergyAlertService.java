package com.globalsolution.alertenergy.service;

import com.globalsolution.alertenergy.model.EnergyAlert;
import com.globalsolution.alertenergy.repository.EnergyAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyAlertService {

    @Autowired
    private EnergyAlertRepository repository;

    public EnergyAlert saveAlert(EnergyAlert alert) {
        if (alert.isComEnergia()) {
            alert.setMensagem("Você tem energia.");
        } else {
            alert.setMensagem("Você está sem energia.");
        }
        return repository.save(alert);
    }

    public List<EnergyAlert> getAllAlerts() {
        return repository.findAll();
    }

    public Optional<EnergyAlert> getAlertById(Long id) {
        return repository.findById(id);
    }

    public void deleteAlert(Long id) {
        repository.deleteById(id);
    }

    public EnergyAlert updateAlert(Long id, EnergyAlert updatedAlert) {
        return repository.findById(id).map(alert -> {
            alert.setNome(updatedAlert.getNome());
            alert.setBairro(updatedAlert.getBairro());
            alert.setCidade(updatedAlert.getCidade());
            alert.setComEnergia(updatedAlert.isComEnergia());
            if (updatedAlert.isComEnergia()) {
                alert.setMensagem("Você tem energia.");
            } else {
                alert.setMensagem("Você está sem energia.");
            }
            return repository.save(alert);
        }).orElseGet(() -> {
            updatedAlert.setId(id);
            if (updatedAlert.isComEnergia()) {
                updatedAlert.setMensagem("Você tem energia.");
            } else {
                updatedAlert.setMensagem("Você está sem energia.");
            }
            return repository.save(updatedAlert);
        });
    }
}

package com.medcycle.demo.controller;

import com.medcycle.demo.entity.*;
import com.medcycle.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/checkins")
public class CheckinController {

    @Autowired
    private CheckinRepository checkinRepository;

    @PostMapping
    public Checkin criar(@RequestBody Checkin checkin) {
        return checkinRepository.save(checkin);
    }

    @GetMapping
    public List<Checkin> listar() {
        return checkinRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checkin> buscarPorId(@PathVariable Long id) {
        return checkinRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checkin> atualizar(@PathVariable Long id, @RequestBody Checkin atualizado) {
        return checkinRepository.findById(id)
                .map(checkin -> {
                    checkin.setAluno(atualizado.getAluno());
                    checkin.setRodizio(atualizado.getRodizio());
                    checkin.setDataHoraCheckin(atualizado.getDataHoraCheckin());
                    checkin.setDataHoraCheckout(atualizado.getDataHoraCheckout());
                    checkin.setPresente(atualizado.getPresente());
                    checkin.setValido(atualizado.getValido());
                    Checkin salvo = checkinRepository.save(checkin);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return checkinRepository.findById(id)
                .map(checkin -> {
                    checkinRepository.delete(checkin);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

package com.medcycle.demo.controller;

import com.medcycle.demo.entity.SemestreLetivo;
import com.medcycle.demo.repository.SemestreLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/semestre-letivo")
public class SemestreLetivoController {

    @Autowired
    private SemestreLetivoRepository semestreLetivoRepository;

    @PostMapping
    public SemestreLetivo criar(@RequestBody SemestreLetivo semestreLetivo) {
        return semestreLetivoRepository.save(semestreLetivo);
    }

    @GetMapping
    public List<SemestreLetivo> listar() {
        return semestreLetivoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemestreLetivo> buscarPorId(@PathVariable Long id) {
        return semestreLetivoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SemestreLetivo> atualizar(@PathVariable Long id, @RequestBody SemestreLetivo atualizado) {
        return semestreLetivoRepository.findById(id)
                .map(semestre -> {
                    semestre.setDescricao(atualizado.getDescricao());
                    semestre.setDataInicio(atualizado.getDataInicio());
                    semestre.setDataFim(atualizado.getDataFim());
                    semestre.setRotulo(atualizado.getRotulo());
                    semestre.setEncerrado(atualizado.isEncerrado());
                    SemestreLetivo salvo = semestreLetivoRepository.save(semestre);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return semestreLetivoRepository.findById(id)
                .map(semestre -> {
                    semestreLetivoRepository.delete(semestre);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

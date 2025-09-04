package com.medcycle.demo.controller;

import com.medcycle.demo.entity.*;
import com.medcycle.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rodizio-alunos")
public class RodizioAlunoController {

    @Autowired
    private RodizioAlunoRepository rodizioAlunoRepository;

    @PostMapping
    public RodizioAluno criar(@RequestBody RodizioAluno rodizioAluno) {
        return rodizioAlunoRepository.save(rodizioAluno);
    }

    @GetMapping
    public List<RodizioAluno> listar() {
        return rodizioAlunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RodizioAluno> buscarPorId(@PathVariable Long id) {
        return rodizioAlunoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RodizioAluno> atualizar(@PathVariable Long id, @RequestBody RodizioAluno atualizado) {
        return rodizioAlunoRepository.findById(id)
                .map(rodizioAluno -> {
                    rodizioAluno.setRodizio(atualizado.getRodizio());
                    rodizioAluno.setAluno(atualizado.getAluno());
                    rodizioAluno.setStatus(atualizado.getStatus());
                    RodizioAluno salvo = rodizioAlunoRepository.save(rodizioAluno);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return rodizioAlunoRepository.findById(id)
                .map(rodizioAluno -> {
                    rodizioAlunoRepository.delete(rodizioAluno);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

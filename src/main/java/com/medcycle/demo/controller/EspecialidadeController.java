package com.medcycle.demo.controller;

import com.medcycle.demo.entity.*;
import com.medcycle.demo.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @PostMapping
    public Especialidade criar(@RequestBody Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    @GetMapping
    public List<Especialidade> listar() {
        return especialidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> buscarPorId(@PathVariable Long id) {
        return especialidadeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidade> atualizar(@PathVariable Long id, @RequestBody Especialidade atualizado) {
        return especialidadeRepository.findById(id)
                .map(especialidade -> {
                    especialidade.setNome(atualizado.getNome());
                    Especialidade salvo = especialidadeRepository.save(especialidade);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return especialidadeRepository.findById(id)
                .map(especialidade -> {
                    especialidadeRepository.delete(especialidade);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


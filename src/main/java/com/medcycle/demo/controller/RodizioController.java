package com.medcycle.demo.controller;

import com.medcycle.demo.entity.Rodizio;
import com.medcycle.demo.repository.RodizioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rodizios")
public class RodizioController {

    @Autowired
    private RodizioRepository rodizioRepository;

    @PostMapping
    public ResponseEntity<Rodizio> criar(@RequestBody Rodizio rodizio) {
        Rodizio salvo = rodizioRepository.save(rodizio);
        // buscar com join fetch para ter os dados completos
        return rodizioRepository.findByIdComRelacoes(salvo.getId())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.CREATED).body(salvo));
    }


    @GetMapping
    public List<Rodizio> listar() {
        return rodizioRepository.findAllComRelacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rodizio> buscarPorId(@PathVariable Long id) {
        return rodizioRepository.findByIdComRelacoes(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rodizio> atualizar(@PathVariable Long id, @RequestBody Rodizio atualizado) {
        return rodizioRepository.findById(id)
                .map(rodizio -> {
                    rodizio.setLocalParceiro(atualizado.getLocalParceiro());
                    rodizio.setEspecialidade(atualizado.getEspecialidade());
                    rodizio.setPreceptor(atualizado.getPreceptor());
                    rodizio.setDataInicio(atualizado.getDataInicio());
                    rodizio.setDataFim(atualizado.getDataFim());
                    rodizio.setTurno(atualizado.getTurno());
                    rodizio.setVagas(atualizado.getVagas());
                    rodizioRepository.save(rodizio);
                    // BUSCA COMPLETA do objeto atualizado para resposta JSON
                    return rodizioRepository.findByIdComRelacoes(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
                })
                .orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return rodizioRepository.findById(id)
                .map(rodizio -> {
                    rodizioRepository.delete(rodizio);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

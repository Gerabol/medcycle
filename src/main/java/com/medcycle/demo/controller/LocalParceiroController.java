package com.medcycle.demo.controller;

import com.medcycle.demo.entity.*;
import com.medcycle.demo.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/locais")
public class LocalParceiroController {

    @Autowired
    private LocalParceiroRepository localParceiroRepository;

    @PostMapping
    public LocalParceiro criar(@RequestBody LocalParceiro localParceiro) {
        return localParceiroRepository.save(localParceiro);
    }

    @GetMapping
    public List<LocalParceiro> listar() {
        return localParceiroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalParceiro> buscarPorId(@PathVariable Long id) {
        return localParceiroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalParceiro> atualizar(@PathVariable Long id, @RequestBody LocalParceiro atualizado) {
        return localParceiroRepository.findById(id)
                .map(local -> {
                    local.setNome(atualizado.getNome());
                    local.setSigla(atualizado.getSigla());
                    local.setEnderecoCompleto(atualizado.getEnderecoCompleto());
                    local.setCidade(atualizado.getCidade());
                    local.setCep(atualizado.getCep());
                    local.setLatitude(atualizado.getLatitude());
                    local.setLongitude(atualizado.getLongitude());
                    LocalParceiro salvo = localParceiroRepository.save(local);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return localParceiroRepository.findById(id)
                .map(local -> {
                    localParceiroRepository.delete(local);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

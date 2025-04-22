package com.curriculo.curriculoapi.controller;

import com.curriculo.curriculoapi.model.Pessoa;
import com.curriculo.curriculoapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*") // permite requisições de qualquer origem (como o Postman ou seu frontend)
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // GET - Listar todas as pessoas
    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    // GET - Buscar pessoa por ID
    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    // POST - Criar nova pessoa (com formacoes, experiencias e habilidades)
    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // PUT - Atualizar uma pessoa existente
    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setNome(novaPessoa.getNome());
            pessoa.setEmail(novaPessoa.getEmail());
            pessoa.setTelefone(novaPessoa.getTelefone());
            pessoa.setLinkedin(novaPessoa.getLinkedin());
            pessoa.setResumo(novaPessoa.getResumo());
            pessoa.setFormacoes(novaPessoa.getFormacoes());
            pessoa.setExperiencias(novaPessoa.getExperiencias());
            pessoa.setHabilidades(novaPessoa.getHabilidades());
            return pessoaRepository.save(pessoa);
        }).orElse(null);
    }

    // DELETE - Deletar pessoa por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}

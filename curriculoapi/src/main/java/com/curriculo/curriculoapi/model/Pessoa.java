package com.curriculo.curriculoapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String linkedin;
    private String resumo;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Formacao> formacoes;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Habilidade> habilidades;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }
    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }
    public List<Formacao> getFormacoes() { return formacoes; }
    public void setFormacoes(List<Formacao> formacoes) { this.formacoes = formacoes; }
    public List<Experiencia> getExperiencias() { return experiencias; }
    public void setExperiencias(List<Experiencia> experiencias) { this.experiencias = experiencias; }
    public List<Habilidade> getHabilidades() { return habilidades; }
    public void setHabilidades(List<Habilidade> habilidades) { this.habilidades = habilidades; }
}

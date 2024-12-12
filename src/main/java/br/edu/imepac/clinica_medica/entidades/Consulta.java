package br.edu.imepac.clinica_medica.entidades;

import java.time.LocalDateTime;

public class Consulta {

    private Long id;
    private LocalDateTime dataHorario;
    private String sintomas;
    private boolean eRetorno;
    private boolean estaAtiva;

    private Long convenioId;
    private Convenio convenio;

    private Long prontuarioId;
    private Prontuario prontuario;

    private Funcionario atendenteId;
    private Funcionario atendente;

    private Funcionario medicoId;
    private Funcionario medico;

    public Consulta() {
    }

    public Consulta(LocalDateTime dataHorario, String sintomas, boolean eRetorno, boolean estaAtiva, Long convenioId, Convenio convenio, Long prontuarioId, Funcionario atendenteId, Funcionario medicoId) {
        this.dataHorario = dataHorario;
        this.sintomas = sintomas;
        this.eRetorno = eRetorno;
        this.estaAtiva = estaAtiva;
        this.convenioId = convenioId;
        this.convenio = convenio;
        this.prontuarioId = prontuarioId;
        this.atendenteId = atendenteId;
        this.medicoId = medicoId;
    }

    public Consulta(Long id, LocalDateTime dataHorario, String sintomas, boolean eRetorno, boolean estaAtiva, Long convenioId, Convenio convenio, Long prontuarioId, Prontuario prontuario, Funcionario atendenteId, Funcionario atendente, Funcionario medicoId, Funcionario medico) {
        this.id = id;
        this.dataHorario = dataHorario;
        this.sintomas = sintomas;
        this.eRetorno = eRetorno;
        this.estaAtiva = estaAtiva;
        this.convenioId = convenioId;
        this.convenio = convenio;
        this.prontuarioId = prontuarioId;
        this.prontuario = prontuario;
        this.atendenteId = atendenteId;
        this.atendente = atendente;
        this.medicoId = medicoId;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public boolean eRetorno() {
        return eRetorno;
    }

    public void seteRetorno(boolean eRetorno) {
        this.eRetorno = eRetorno;
    }

    public boolean estaAtiva() {
        return estaAtiva;
    }

    public void setEstaAtiva(boolean estaAtiva) {
        this.estaAtiva = estaAtiva;
    }

    public Long getConvenioId() {
        return convenioId;
    }

    public void setConvenioId(Long convenioId) {
        this.convenioId = convenioId;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public Funcionario getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(Funcionario atendenteId) {
        this.atendenteId = atendenteId;
    }

    public Funcionario getAtendente() {
        return atendente;
    }

    public void setAtendente(Funcionario atendente) {
        this.atendente = atendente;
    }

    public Funcionario getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Funcionario medicoId) {
        this.medicoId = medicoId;
    }

    public Funcionario getMedico() {
        return medico;
    }

    public void setMedico(Funcionario medico) {
        this.medico = medico;
    }

}

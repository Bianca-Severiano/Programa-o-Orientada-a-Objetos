package model;

import java.sql.Date;
import java.time.LocalDate;

public class Aluguel {
    
    private Aluno aluno;
    private Exemplar exemplar;
    private Date dataRetirada;
    private Date dataDevolucao;
    
    public Aluguel() {
        super();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevoluacao) {
        this.dataDevolucao = dataDevoluacao;
    }

    @Override
    public String toString() {
        return "ALUNO - Nome: " + aluno.getNome() + " RA: " + aluno.getRA() + " E-mail: " 
        + aluno.getEmail() + "\n EXEMPLAR - Nome: " + exemplar.getNome() + " Código: " + exemplar.getCodigo() +
        "\n DATA DE RETIRADA: " + dataRetirada + "\n DATA DE DEVOLUÇÃO: " + dataDevolucao;
    }

}

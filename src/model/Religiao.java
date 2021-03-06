package model;

import dao.ReligiaoDao;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Religiao {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty definicao = new SimpleStringProperty();
    private List<Religiao> religioes = new ArrayList<>();
    private ReligiaoDao religiaoDao;

    public Religiao() throws Exception {
        religiaoDao = new ReligiaoDao();
    }

    public Religiao(int id, String definicao) {
        setId(id);
        setDefinicao(definicao);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty getPropriedadeId() {
        return id;
    }

    public void setPropriedadeId(IntegerProperty id) {
        this.id = id;
    }

    public String getDefinicao() {
        return definicao.get();
    }

    public void setDefinicao(String definicao) {
        this.definicao.set(definicao);
    }

    public StringProperty getPropriedadeDefinicao() {
        return definicao;
    }

    public void setProprieadeDefinicao(StringProperty definicao) {
        this.definicao = definicao;
    }

    public List<Religiao> getReligioes() {
        return religioes;
    }

    public void setReligioes(List<Religiao> religioes) {
        this.religioes = religioes;
    }

    public void cadastrarReligiao() throws Exception {
        religiaoDao.inserirReligiao(this);
    }

    public void atualizarReligiao() throws Exception {
        religiaoDao.alterarReligao(this);
    }

    public void apagarReligiao() throws Exception {
        religiaoDao.deletarReligiao(this.getId());
    }

    public Object pesquisarPorId() throws Exception {
        return religiaoDao.pesquisarId(this.getId());
    }

    public Object pesquisarPorDefinicao() throws Exception {
        return religiaoDao.pesquisarDefinicao(this.getDefinicao());
    }

    public List<Religiao> pesquisarPorReligioes() throws Exception {
        return religiaoDao.pesquisarTodos();
    }

    public int mostrarTotal() throws Exception {
        return religiaoDao.contarQuantidadeReligioes();
    }

    public List<String> listaReligioes() {
        List<String> listaPaises = new ArrayList<>();
        for(Religiao r : religioes) {
            listaPaises.add(r.getDefinicao());
        }
        return listaPaises;
    }

}

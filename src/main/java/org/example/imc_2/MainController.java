package org.example.imc_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.util.List;

public class MainController {

    @FXML private TextField txtNome;
    @FXML private TextField txtAltura;
    @FXML private TextField txtPeso;
    @FXML private Label lblValorImc;
    @FXML private Label lblClassificacao;

    @FXML private TableView<Pessoa> tabela;
    @FXML private TableColumn<Pessoa, Integer> colId;
    @FXML private TableColumn<Pessoa, String> colNome;
    @FXML private TableColumn<Pessoa, Double> colAltura;
    @FXML private TableColumn<Pessoa, Double> colImc;

    private ObservableList<Pessoa> listaPessoas = FXCollections.observableArrayList();
    private int proximoId = 1;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory< >("id"));
        colNome.setCellValueFactory(new PropertyValueFactory< >("nome"));
        colAltura.setCellValueFactory(new PropertyValueFactory< >("altura"));
        colImc.setCellValueFactory(new PropertyValueFactory< >("imc"));
        tabela.setItems(listaPessoas);
    }

    @FXML
    protected void onCalcularClick() {
        try {
            String nome = txtNome.getText();
            double altura = Double.parseDouble(txtAltura.getText().replace(",", "."));
            double peso = Double.parseDouble(txtPeso.getText().replace(",", "."));

            Pessoa p = new Pessoa(proximoId++, nome, altura, peso);
            listaPessoas.add(p);

            double imc = p.getImc();
            lblValorImc.setText(String.format("%.2f", imc));
            lblClassificacao.setText(obterClassificacao(imc));

            txtNome.clear(); txtAltura.clear(); txtPeso.clear();
        } catch (NumberFormatException ex) {
            mostrarAlerta("Erro", "Insira valores numéricos válidos.");
        }
    }

    @FXML
    protected void onSalvarClick() {
        try {
            ArquivoUtil.salvar(listaPessoas);
            mostrarAlerta("Sucesso", "Dados guardados com sucesso!");
        } catch (IOException ex) {
            mostrarAlerta("Erro", "Erro ao guardar o ficheiro.");
        }
    }

    @FXML
    protected void onCarregarClick() {
        try {
            List<Pessoa> dadosCarregados = ArquivoUtil.carregar();
            listaPessoas.setAll(dadosCarregados);
            proximoId = dadosCarregados.stream().mapToInt(Pessoa::getId).max().orElse(0) + 1;
        } catch (IOException ex) {
            mostrarAlerta("Erro", "Erro ao carregar o ficheiro.");
        }
    }

    private String obterClassificacao(double imc) {
        if (imc < 18.5) return "Abaixo do Peso";
        if (imc < 24.9) return "Peso Normal";
        if (imc < 29.9) return "Sobrepeso";
        if (imc < 34.9) return "Obesidade Grau 1";
        if (imc < 39.9) return "Obesidade Grau 2";
        return "Obesidade Grau 3";
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
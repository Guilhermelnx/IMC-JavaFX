package org.example.imc_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {
    private static final String NOME_ARQUIVO = "dados_pessoas.txt";

    public static void salvar(List pessoas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Object obj : pessoas) {
                Pessoa p = (Pessoa) obj;
                writer.write(p.getId() + "," + p.getNome() + "," + p.getAltura() + "," + p.getPeso() + "," + p.getImc());
                writer.newLine();
            }
        }
    }

    public static List carregar() throws IOException {
        List pessoas = new ArrayList();
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) return pessoas;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    Pessoa p = new Pessoa(Integer.parseInt(dados[0]), dados[1],
                            Double.parseDouble(dados[2]), Double.parseDouble(dados[3]));
                    p.setImc(Double.parseDouble(dados[4]));
                    pessoas.add(p);
                }
            }
        }
        return pessoas;
    }
}
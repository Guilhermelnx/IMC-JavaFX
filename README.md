# 📊 Laboratório 01: Cálculo de IMC com JavaFX e Manipulação de Ficheiros

Aplicação gráfica desenvolvida em **JavaFX**, utilizando arquitetura **FXML** e **Maven**, para o cadastro, cálculo, classificação e persistência de dados do Índice de Massa Corporal (IMC).

## 🎯 Objetivo da Aplicação

Desenvolver uma aplicação gráfica em JavaFX que permita ao utilizador:

* Cadastrar informações pessoais;
* Informar nome, altura e peso;
* Calcular o Índice de Massa Corporal (IMC);
* Classificar o IMC de acordo com os critérios definidos;
* Exibir os dados cadastrados em uma tabela (`TableView`);
* Salvar os dados em um ficheiro;
* Carregar os dados previamente salvos.

## 🚀 Requisitos do Sistema

### 1. Interface Gráfica (JavaFX)

A aplicação possui uma interface gráfica desenvolvida com JavaFX, contendo:

* Formulário para entrada dos dados:

  * **Nome:** `String`
  * **Altura:** `double`, em metros
  * **Peso:** `double`, em quilogramas
* Botão **"Calcular IMC"** para realizar e exibir o cálculo;
* Botão **"Salvar"** para armazenar os dados no ficheiro;
* Botão **"Carregar Dados"** para recuperar os registos salvos;
* `TableView` para listar as pessoas cadastradas e seus respectivos dados.

### 2. Cálculo e Classificação do IMC

O IMC é calculado através da seguinte fórmula:

$$
\text{IMC} = \frac{\text{peso}}{\text{altura}^2}
$$

A classificação utilizada pela aplicação segue os seguintes critérios:

| IMC               | Classificação    |
| ----------------- | ---------------- |
| IMC < 18.5        | Abaixo do Peso   |
| 18.5 ≤ IMC < 24.9 | Peso Normal      |
| 25 ≤ IMC < 29.9   | Sobrepeso        |
| 30 ≤ IMC < 34.9   | Obesidade Grau 1 |
| 35 ≤ IMC < 39.9   | Obesidade Grau 2 |
| IMC ≥ 40          | Obesidade Grau 3 |

### 3. Manipulação de Ficheiros

A aplicação permite realizar a persistência dos dados através de um ficheiro de texto.

* **Ficheiro:** `dados_pessoas.txt`
* **Formato:** CSV (valores separados por vírgula)
* Permite salvar os dados das pessoas cadastradas;
* Permite carregar os dados salvos;
* Os dados carregados são exibidos automaticamente na `TableView`.

## 🛠️ Estrutura do Código

O projeto está organizado em classes modulares, buscando manter uma separação adequada entre os dados, a manipulação de ficheiros e a interface gráfica.

### `Pessoa.java`

Classe responsável por representar uma pessoa cadastrada.

Contém os seguintes atributos:

* `nome`
* `altura`
* `peso`
* `imc`

Também é responsável pelos dados relacionados ao cálculo do IMC.

### `ArquivoUtil.java`

Classe utilitária responsável pela manipulação do ficheiro de dados.

Utiliza recursos como:

* `FileWriter`
* `BufferedReader`

Suas principais responsabilidades são:

* Salvar os dados das pessoas;
* Ler os dados armazenados;
* Converter os registos do ficheiro para objetos utilizados pela aplicação.

### `MainApplication.java`

Classe principal responsável por iniciar a aplicação JavaFX e carregar a interface definida em FXML.

### `MainController.java`

Classe responsável pelo controlo da interface gráfica e pela interação entre os elementos da tela e a lógica da aplicação.

Entre suas responsabilidades estão:

* Receber os dados do formulário;
* Realizar o cálculo do IMC;
* Atualizar a tabela;
* Salvar os dados;
* Carregar os dados do ficheiro.

## 📁 Estrutura do Projeto

Uma possível estrutura do projeto é:

```text
src/
├── main/
│   ├── java/
│   │   └── ...
│   │       ├── Pessoa.java
│   │       ├── ArquivoUtil.java
│   │       ├── MainApplication.java
│   │       └── MainController.java
│   │
│   └── resources/
│       └── ...
│           └── main-view.fxml
│
├── dados_pessoas.txt
└── pom.xml
```

## ▶️ Como Executar

### Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

* **Java JDK** instalado;
* **IntelliJ IDEA** ou outra IDE compatível;
* **Maven**;
* Dependências do **JavaFX** configuradas no projeto.

### Executando o projeto

1. Clone ou descarregue este repositório para o seu computador.

2. Abra o projeto utilizando o **IntelliJ IDEA**.

3. Aguarde o **Maven** sincronizar o projeto e realizar o download das dependências necessárias.

4. Localize a classe:

```text
MainApplication.java
```

5. Execute a classe para iniciar a aplicação gráfica.

6. Utilize o formulário para cadastrar uma pessoa, calcular o IMC e salvar ou carregar os dados.

## 💾 Persistência dos Dados

Os dados cadastrados são armazenados no ficheiro:

```text
dados_pessoas.txt
```

Os registos são armazenados no formato CSV, permitindo que posteriormente sejam lidos pela aplicação e apresentados novamente na tabela.

## 📚 Tecnologias Utilizadas

* **Java**
* **JavaFX**
* **FXML**
* **Maven**
* **FileWriter**
* **BufferedReader**
* **TableView**
* **CSV**

## 👨‍💻 Autor

Guilherme Conceição Campos

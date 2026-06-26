# 🏋️ Compiladores - T6 (TreinoLang)

![Java](https://img.shields.io/badge/Java-11+-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-orange)
![ANTLR](https://img.shields.io/badge/ANTLR-4-red)

---

# 📌 Descrição

O **Trabalho 6 (T6)** da disciplina de Construção de Compiladores consiste no desenvolvimento de um compilador completo para uma **DSL (Domain Specific Language)**.

Neste projeto foi desenvolvida a **TreinoLang**, uma linguagem voltada para a descrição de treinos físicos de musculação.

A linguagem permite descrever treinos de forma estruturada, contendo:

* nome do treino;
* grupo muscular;
* objetivo do treino;
* exercícios;
* número de séries;
* número de repetições;
* carga utilizada.

Após a análise léxica, sintática e semântica, o compilador gera automaticamente uma página HTML contendo a ficha do treino.

---

# 🎯 Objetivo da Linguagem

A TreinoLang foi criada para facilitar a criação e documentação de treinos físicos.

Com ela é possível:

* definir um treino;
* organizar exercícios;
* informar séries;
* informar repetições;
* informar carga;
* gerar automaticamente uma ficha de treino em HTML.

---

# 📝 Estrutura da Linguagem

Todo programa escrito em TreinoLang segue a estrutura abaixo:

```text
treino NomeTreino

grupo GrupoMuscular

objetivo Objetivo

exercicio NomeExercicio {
    series INT
    repeticoes INT
    carga INT
}

exercicio OutroExercicio {
    series INT
    repeticoes INT
    carga INT
}
```

---

# ✅ Exemplo de Programa

```text
treino PushDay

grupo Peito

objetivo Hipertrofia

exercicio Supino {
    series 4
    repeticoes 10
    carga 80
}

exercicio Desenvolvimento {
    series 3
    repeticoes 12
    carga 30
}
```

---

# 🔍 Verificações Semânticas

Além das verificações léxicas e sintáticas realizadas pela gramática, o compilador implementa verificações semânticas adicionais, como:

* detecção de exercícios duplicados no mesmo treino;
* verificação de séries maiores que zero;
* verificação de repetições maiores que zero;
* verificação de carga não negativa;
* limite máximo de séries por exercício;
* limite máximo de repetições por exercício;
* limite máximo de carga permitida;
* quantidade máxima de exercícios por treino.

---

# ⚙️ Funcionalidades do Compilador

O compilador implementa:

* ✅ Análise léxica;
* ✅ Análise sintática;
* ✅ Análise semântica;
* ✅ Geração automática de HTML;
* ✅ Geração de mensagens de erro.

---

# 📄 Geração de HTML

Quando o programa não apresenta erros, é gerada automaticamente uma página HTML contendo:

* nome do treino;
* grupo muscular;
* objetivo;
* tabela com todos os exercícios;
* número de séries;
* número de repetições;
* carga utilizada.

---

# 📁 Estrutura do Projeto

```text
T6/
├── src/
│   ├── main/
│   │   ├── antlr4/
│   │   └── java/
│   └── test/
├── casos-de-teste/
│   ├── lexico/
│   ├── sintatico/
│   ├── semantico/
│   ├── geracao-html/
│   └── completos/
├── pom.xml
└── README.md
```

---

# 📥 Clonando o Repositório

```bash
git clone https://github.com/layssonsantos/T6-Compilador.git
```

Entre na pasta do projeto:

```bash
cd T6-Compilador
```

---

# ▶️ Compilação

Na raiz do projeto execute:

```bash
mvn clean package
```

O Maven irá:

* gerar automaticamente os arquivos do ANTLR;
* compilar todo o projeto;
* gerar um arquivo `.jar` na pasta `target/`.

---

# ▶️ Execução

Execute o compilador utilizando:

```bash
java -jar target/t6-1.0-SNAPSHOT-jar-with-dependencies.jar <arquivo_entrada> <arquivo_saida>
```

### Exemplo

```bash
java -jar target/t6-1.0-SNAPSHOT-jar-with-dependencies.jar treino.tlang resultado.txt
```

Quando não forem encontrados erros durante a compilação, também será gerado um arquivo HTML contendo a ficha de treino correspondente.

---

# 🧪 Casos de Teste

O projeto possui casos de teste organizados nas seguintes categorias:

* Análise Léxica
* Análise Sintática
* Análise Semântica
* Geração de HTML
* Casos completos

Cada categoria contém arquivos de entrada e suas respectivas saídas esperadas.

---

# 🛠 Tecnologias Utilizadas

* Java 11
* Maven
* ANTLR4

---

# 👨‍💻 Autor

**Laysson Santos da Silva**

---

# 📚 Disciplina

**Construção de Compiladores**

Departamento de Computação — UFSCar

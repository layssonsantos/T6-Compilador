# 🏋️ Compiladores - T6 (TreinoLang)

![Java](https://img.shields.io/badge/Java-17+-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-orange)
![ANTLR](https://img.shields.io/badge/ANTLR-4-red)

---

## 📌 Descrição

O Trabalho 6 (T6) da disciplina consiste no desenvolvimento de um compilador completo para uma linguagem específica de domínio (DSL).

Neste projeto foi desenvolvida a **TreinoLang**, uma linguagem voltada para a descrição de treinos físicos de musculação.

A linguagem permite definir exercícios, séries, repetições, carga e tempo de descanso de forma simples e estruturada.

Após a análise léxica, sintática e semântica, o compilador gera uma página HTML contendo o treino formatado para visualização.

---

## 🎯 Objetivo da Linguagem

A TreinoLang foi criada para facilitar a organização e documentação de treinos físicos.

Com ela é possível:

* Definir o nome do treino
* Especificar exercícios
* Informar séries
* Informar repetições
* Informar carga utilizada
* Informar tempo de descanso
* Gerar automaticamente uma ficha de treino em HTML

---

## 📝 Exemplo de Programa

```text
treino peito

exercicio supino
series 4
repeticoes 10
carga 40
descanso 90

exercicio crucifixo
series 3
repeticoes 12
carga 12
descanso 60

fim_treino
```

---

## 🔍 Verificações Semânticas

O compilador realiza verificações adicionais além da gramática.

Exemplos:

* Exercícios duplicados no mesmo treino
* Número de séries inválido
* Número de repetições inválido
* Carga negativa
* Tempo de descanso inválido
* Treino sem exercícios

---

## ⚙️ Funcionalidades do Compilador

* Análise léxica
* Análise sintática
* Análise semântica
* Geração automática de HTML
* Relatório de erros encontrados

---

## 📄 Saída Gerada

Ao processar um treino válido, o compilador produz um arquivo HTML contendo:

* Nome do treino
* Lista de exercícios
* Séries
* Repetições
* Carga
* Descanso

Formatados para visualização em navegador.

---

## 🛠 Tecnologias Utilizadas

* Java
* Maven
* ANTLR4

---

## 👨‍💻 Autor

Laysson Santos da Silva

---

## 📚 Disciplina

Construção de Compiladores

Departamento de Computação - UFSCar

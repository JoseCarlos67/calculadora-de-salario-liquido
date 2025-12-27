# 💼 Gerador de Holerites e Folha de Ponto

![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apache-maven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-000000?logo=intellij-idea&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

Um sistema de automação de Departamento Pessoal desenvolvido em **Java**. A aplicação processa registros de ponto, calcula horas trabalhadas, aplica descontos tributários (INSS e IRRF) e gera relatórios contábeis.

---

## 🎯 Objetivo

O projeto está sendo desenvolvido para consolidar conhecimentos em **Java 17**, com foco em boas práticas de engenharia de software:
1.  **Regras de Negócio Complexas:** Cálculos financeiros e temporais.
2.  **Arquitetura Desacoplada:** Uso de Interfaces e Injeção de Dependência.
3.  **Manipulação de Arquivos:** Leitura e escrita de dados (I/O) para integração de sistemas.

---

## ⚙️ Funcionalidades Planejadas/Implementadas

- 📥 **Importação de Ponto:** Leitura automática de arquivos `.csv` contendo registros de entrada e saída.
- 🕒 **Cálculo de Horas:** Processamento de jornada de trabalho (em progresso).
- 💰 **Cálculo Tributário:** Aplicação automática das tabelas progressivas de **INSS** e **IRRF** (Base 2025).
- 📄 **Geração de Holerite:** Consolidação de vencimentos e descontos.
- 📤 **Relatório Contábil:** Exportação dos dados processados para arquivo `.csv` formatado.

---

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java (JDK 17)
- **Gerenciamento de Build:** Maven
- **IDE:** IntelliJ IDEA

---

## 📋 Conceitos e Práticas Aplicadas

- **POO Avançada:**
    - **Polimorfismo e Interfaces:** Criação da interface `DeductionService` para padronizar estratégias de desconto.
    - **Injeção de Dependência:** Aplicação do princípio de Inversão de Dependência nos serviços geradores.
    - **Encapsulamento:** Proteção rigorosa dos dados sensíveis do funcionário.
- **Java Core:**
    - **BigDecimal:** Uso obrigatório para precisão financeira.
    - **Date & Time API:** Uso de `LocalDate`, `LocalTime` e `Duration`.
    - **File I/O:** Leitura e Escrita de arquivos com `BufferedReader` e `BufferedWriter`.
    - **Exceções Personalizadas:** Tratamento de erros de domínio (`DomainException`).

---
## 📝 Regras de Negócio

✅ **INSS:** Tabela progressiva com 4 faixas salariais (teto 2025).
✅ **IRRF:** Dedução baseada no salário já descontado do INSS.
✅ **Salário Líquido:** Bruto - (INSS + IRRF).

---

## 👨‍💻 Desenvolvido por

**José Carlos da Silva Esteves**
[GitHub: @JoseCarlos67](https://github.com/JoseCarlos67)

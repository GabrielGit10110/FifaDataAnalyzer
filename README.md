# FIFA 19 Data Analyzer 🎮⚽

Um sistema Java para análise e manipulação de dados dos jogadores do FIFA 19, utilizando estruturas de dados como pilhas e listas encadeadas.

## 📋 Descrição do Projeto

Este projeto processa um arquivo CSV contendo informações de todos os jogadores do FIFA 19, implementando operações específicas usando estruturas de dados para:
- Empilhar jogadores brasileiros
- Filtrar e exibir jogadores brasileiros com alto overall
- Listar jovens revelações
- Buscar jovens jogadores com alto potencial

## 🏗️ Estrutura do Projeto

```
src/
├── controller/
│   ├── IFifaController.java      # Interface com operações definidas
│   └── FifaController.java       # Implementação das operações
└── view/
    └── Principal.java            # Classe principal com método main
```

## 📊 Estrutura de Dados Utilizadas

- **Pilha (Stack)**: Para armazenar jogadores brasileiros (LIFO)
- **Lista Encadeada (LinkedList)**: Para armazenar jovens revelações

## 🎯 Funcionalidades

### 1. Empilha Brasileiros
- Lê o arquivo CSV e empilha todos os jogadores brasileiros
- Ignora o cabeçalho do arquivo
- Retorna uma pilha com os dados completos dos jogadores

### 2. Desempilha Bons Brasileiros
- Desempilha e exibe apenas jogadores brasileiros com overall > 80
- Formata a saída para mostrar nome e overall
- Ordem de exibição: do pior para o melhor (devido à propriedade LIFO da pilha)

### 3. Lista Revelações
- Cria uma lista com todos os jogadores de 20 anos ou menos
- Adiciona os jogadores ao final da lista
- Retorna a lista encadeada com os dados completos

### 4. Busca Bons Jovens
- Percorre a lista de jovens revelações
- Exibe apenas jogadores com overall > 80 e idade ≤ 20 anos
- Formata a saída para mostrar nome, idade e overall

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- Arquivo `data.csv` na pasta `C:\TEMP`

### Configuração
1. Coloque o arquivo `data.csv` em `C:\TEMP\`
2. Compile o projeto:
   ```bash
   javac -d bin src/controller/*.java src/view/*.java
   ```
3. Execute o programa:
   ```bash
   java -cp bin view.Principal
   ```

### Execução com IDE
1. Importe o projeto em sua IDE preferida (Eclipse, IntelliJ, NetBeans)
2. Configure o classpath
3. Execute a classe `Principal` no pacote `view`

## 📝 Exemplo de Saída

```
===========================
NAME               OVERALL
===========================
Raffael              81
Renato Augusto       81
Hulk                 81
...
Neymar Jr            92

======================================================
NAME               AGE                 OVERALL
======================================================
K. Mbappé            19                   88
M. de Ligt           18                   82
G. Donnarumma        19                   82
...
```

## 🔧 Implementação Técnica

### Métodos Principais

#### `empilhaBrasileiros(String caminho, String nome)`
- **Estrutura**: Stack<String>
- **Filtro**: Nacionalidade = "Brazil"
- **Processamento**: Leitura sequencial e empilhamento

#### `desempilhaBonsBrasileiros(Stack<String> pilha)`
- **Filtro**: Overall > 80
- **Saída**: Nome e Overall formatados

#### `listaRevelacoes(String caminho, String nome)`
- **Estrutura**: LinkedList<String>
- **Filtro**: Idade ≤ 20 anos
- **Processamento**: Adição ao final da lista

#### `buscaListaBonsJovens(List<String> lista)`
- **Filtro**: Overall > 80 e Idade ≤ 20
- **Saída**: Nome, Idade e Overall formatados

## 📋 Estrutura do CSV

O arquivo CSV contém as seguintes colunas principais:
- Photo, Name, Age, Nationality, Overall, etc.
- Ordenado por Overall (decrescente)

## 🛠️ Tratamento de Erros

- Validação de existência do arquivo
- Tratamento de exceções de I/O
- Mensagens de erro descritivas

## 👨‍💻 Desenvolvido por GabrielGit10110

Projeto desenvolvido como atividade acadêmica para demonstração de uso de estruturas de dados em Java.

---

**Nota**: Certifique-se de que o arquivo `data.csv` está no diretório `C:\TEMP\` antes de executar o programa.
```

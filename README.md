
# Visão Geral

Este projeto em Java visa encontrar a submatriz (região de interesse) dentro de uma matriz quadrada. A solução utiliza uma abordagem de programação dinâmica combinada com o Algoritmo de Kadane para calcular de forma eficiente a soma máxima de todas as possíveis regiões retangulares da matriz.

---

## Explicação do Algoritmo

### Matriz de Entrada

A matriz é lida pelo método `MatrixServices.readInputMatrix()`, que coleta os dados fornecidos.

### Programação Dinâmica

O método `ROISolution` percorre todos os possíveis intervalos de linhas (de `initialRow` a `finalRow`). Para cada intervalo de linhas, ele calcula a soma de cada coluna e armazena essas somas em um array temporário.

### Algoritmo de Kadane

O array de somas de colunas é processado pelo método `maxSumArray`, que encontra a sublista com a soma máxima. Isso identifica os limites das colunas esquerda e direita que formam o retângulo com a maior soma.

### Cálculo da Soma Máxima

Sempre que uma nova soma máxima é encontrada, o algoritmo atualiza o resultado. Ele armazena a soma e as coordenadas do retângulo correspondente (topo, esquerda, baixo, direita).

### Saída

O programa imprime a matriz original, a soma máxima da submatriz encontrada e as coordenadas do retângulo.

---

**OBS.:** Este projeto não tem dependências de frameworks ou pacotes externos, portanto, o código pode ser executado de forma limpa e independente.

---

## Como Executar

1. **Compile a classe Main**:

   ```bash
   javac Main.java
   ```

2. **Execute o programa**:

   ```bash
   java Main
   ```

3. **Insira a matriz quando solicitado** ou modifique a classe `MatrixServices` para definir a matriz diretamente no código.

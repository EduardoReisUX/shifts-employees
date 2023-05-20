# Escalonador

A função do projeto é dividir funcionários pra cobrir todos turnos de trabalho com o menor custo possível, daí tem os requisitos de cada turno, o que cada funcionário faz e o custo do seu trabalho.

### Estrutura de pastas
- **entities**: contém as entidades, getters e setters (funcionário e turno).
- **repositories**: são funções para manipular cada entidade (criar, procurar, deletar).
- **useCases**: são ações que executam casos de uso de forma correta, como add funcionário a um turno, fechar um turno...
- **useCases/tests**: testes automatizado para conferir que td está funcionando (não precisa alterar).
- **lib**: biblioteca para os tests.

#### Entidades

| Funcionário |          |
|-------------|----------|
| id          | UUID     |
| habilidades | string[] |
| custo       | int      |

| Turno      |          |
|------------|----------|
| id         | UUID     |
| requisitos | string[] |
| orçamento  | int      |

### Como funciona
Para o devido funcionamento, os useCases dependem dos repositories e os repositories dependem das entidades. As entidades não possuem nenhuma dependência externa.

useCases -> Repositories -> Entities

### Programação dinâmica

Implementar de alguma forma...
https://www.codeflow.site/pt/article/java-knapsack

<img src="CleanArchitecture.jpg" alt="clean architecture" width="500"/>


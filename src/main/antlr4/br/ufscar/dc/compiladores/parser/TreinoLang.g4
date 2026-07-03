grammar TreinoLang;

// -----------------------------------------------------------------------------
// Regra inicial da linguagem.
// Um programa é composto pelo nome do treino, seu tipo e um ou mais exercícios.
// -----------------------------------------------------------------------------
program
    : 'treino' ID
      'tipo' TIPO_TREINO
      exercicio+
      EOF
    ;

// -----------------------------------------------------------------------------
// Tipos de treino suportados pela linguagem.
// -----------------------------------------------------------------------------
TIPO_TREINO
    : 'PUSH'
    | 'PULL'
    | 'LEGS'
    | 'FULLBODY'
    ;

// -----------------------------------------------------------------------------
// Define a estrutura de um exercício.
//
// Cada exercício possui:
// - nome;
// - objetivo;
// - grupo muscular;
// - número de séries;
// - número de repetições;
// - carga utilizada.
// -----------------------------------------------------------------------------
exercicio
    : 'exercicio' ID '{'
        'objetivo' OBJETIVO
        'grupo' GRUPO
        'series' INT
        'repeticoes' INT
        'carga' INT
      '}'
    ;

// -----------------------------------------------------------------------------
// Objetivos de treinamento aceitos.
// -----------------------------------------------------------------------------
OBJETIVO
    : 'FORCA'
    | 'HIPERTROFIA'
    | 'RESISTENCIA'
    ;

// -----------------------------------------------------------------------------
// Grupos musculares suportados pela linguagem.
// -----------------------------------------------------------------------------
GRUPO
    : 'PEITO'
    | 'COSTAS'
    | 'PERNAS'
    | 'OMBROS'
    | 'BICEPS'
    | 'TRICEPS'
    ;

// -----------------------------------------------------------------------------
// Identificadores.
// Utilizados para representar o nome do treino e dos exercícios.
// Devem iniciar com letra ou '_' e podem conter letras, números e '_'.
// -----------------------------------------------------------------------------
ID
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

// -----------------------------------------------------------------------------
// Literais inteiros.
// Utilizados para séries, repetições e carga.
// -----------------------------------------------------------------------------
INT
    : [0-9]+
    ;

// -----------------------------------------------------------------------------
// Espaços em branco.
// São ignorados durante a análise léxica.
// -----------------------------------------------------------------------------
WS
    : [ \t\r\n]+ -> skip
    ;

// -----------------------------------------------------------------------------
// Comentários de linha.
// Tudo após "//" até o fim da linha é ignorado.
// -----------------------------------------------------------------------------
COMMENT
    : '//' ~[\r\n]* -> skip
    ;

// -----------------------------------------------------------------------------
// Captura qualquer caractere não reconhecido pelas regras anteriores.
// Deve permanecer como a última regra léxica da gramática.
// -----------------------------------------------------------------------------
ERROR_CHAR
    : .
    ;
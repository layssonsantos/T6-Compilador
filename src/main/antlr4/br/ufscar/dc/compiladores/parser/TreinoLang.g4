grammar TreinoLang;

program
    : 'treino' ID
      'tipo' TIPO_TREINO
      exercicio+
      EOF
    ;

TIPO_TREINO
    : 'PUSH'
    | 'PULL'
    | 'LEGS'
    | 'FULLBODY'
    ;

exercicio
    : 'exercicio' ID '{'
        'objetivo' OBJETIVO
        'grupo' GRUPO
        'series' INT
        'repeticoes' INT
        'carga' INT
      '}'
    ;

OBJETIVO
    : 'FORCA'
    | 'HIPERTROFIA'
    | 'RESISTENCIA'
    ;

GRUPO
    : 'PEITO'
    | 'COSTAS'
    | 'PERNAS'
    | 'OMBROS'
    | 'BICEPS'
    | 'TRICEPS'
    ;

ID
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

INT
    : [0-9]+
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '//' ~[\r\n]* -> skip
    ;

// Sempre a última regra
ERROR_CHAR
    : .
    ;
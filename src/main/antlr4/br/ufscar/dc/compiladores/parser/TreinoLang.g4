grammar TreinoLang;

program
    : 'treino' ID exercicio+ EOF
    ;

exercicio
    : 'exercicio' ID '{'
        'series' INT
        'repeticoes' INT
        'carga' INT
      '}'
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
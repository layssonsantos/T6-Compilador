#!/bin/bash

ROOT=$(pwd)

JAR="target/t6-1.0-SNAPSHOT-jar-with-dependencies.jar"

echo "===================================="
echo "Compilando projeto..."
echo "===================================="

mvn clean package

if [ ! -f "$JAR" ]; then
    echo "Erro: JAR não encontrado!"
    exit 1
fi

rm -rf results
mkdir -p results

TOTAL=0
PASSOU=0
FALHOU=0

for SUITE in lexico sintatico semantico geracao-html
do

    echo ""
    echo "===================================="
    echo "Testando $SUITE"
    echo "===================================="

    mkdir -p "results/$SUITE"

    if [ "$SUITE" = "geracao-html" ]; then
        EXT="html"
    else
        EXT="txt"
    fi

    for ENTRADA in casos-de-teste/$SUITE/entrada/*.tlang
    do

        TOTAL=$((TOTAL + 1))

        NOME=$(basename "$ENTRADA" .tlang)

        SAIDA="results/$SUITE/$NOME.$EXT"

        ESPERADA="casos-de-teste/$SUITE/saida-esperada/$NOME.$EXT"

        printf "▶ %-35s" "$NOME"

        java -jar "$JAR" \
            "$ENTRADA" \
            "$SAIDA"

        if cmp -s "$ESPERADA" "$SAIDA"
        then
            echo "✅"

            PASSOU=$((PASSOU + 1))

        else

            echo "❌"

            FALHOU=$((FALHOU + 1))

            echo "-------------------------------------"
            diff -u "$ESPERADA" "$SAIDA"
            echo "-------------------------------------"

        fi

    done

done

echo ""
echo "===================================="
echo "Resumo dos testes"
echo "===================================="

echo "Total     : $TOTAL"
echo "Passaram  : $PASSOU"
echo "Falharam  : $FALHOU"

echo ""

if [ "$FALHOU" -eq 0 ]
then
    echo "🎉 Todos os testes passaram!"
    exit 0
else
    echo "⚠ Existem $FALHOU teste(s) com falha."
    exit 1
fi
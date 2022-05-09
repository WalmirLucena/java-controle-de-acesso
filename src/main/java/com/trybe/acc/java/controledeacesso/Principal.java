package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI
    Scanner scan = new Scanner(System.in);

    int countMinorAge = 0;
    int countAdultAge = 0;
    int countSeniorAge = 0;

    short option = 0;

    while (option != 1 || option != 2) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Acessar o estabelecimento");
      System.out.println("2 - Finalizar sistema e mostrar relatório");
      option = scan.nextShort();

      if (option == 1) {
        System.out.println("Entre com a idade:");
        short age = scan.nextShort();

        if (age < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
          countMinorAge += 1;
        } else if (age >= 18 && age < 50) {
          System.out.println("Pessoa adulta, catraca liberada!");
          countAdultAge += 1;
        } else {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
          countSeniorAge += 1;
        }
      }

      if (option == 2) {
        int total = countMinorAge + countAdultAge + countSeniorAge;

        System.out.println("----- Quantidade -----" + "\nmenores: " + countMinorAge + "\nadultas: "
            + countAdultAge + "\na partir de 50: " + countSeniorAge + "\n\n----- Percentual -----"
            + "\nmenores: " + percentual(countMinorAge, total) + "%" + "\nadultas: "
            + percentual(countAdultAge, total) + "%" + "\na partir de 50: "
            + percentual(countSeniorAge, total) + "%" + "\n\nTOTAL:" + total);
        break;

      }
      if (option != 1 || option != 2) {
        System.out.println("Entre com uma opção válida!");
      }
    }

  }

  // https://www.devmedia.com.br/forum/decimal-format/567155 Referência para a função abaixo.
  static String percentual(int number, int total) {
    DecimalFormat df = new DecimalFormat("0.00");

    float result = (number / total) * 100F;
    return df.format(result);
  }
}

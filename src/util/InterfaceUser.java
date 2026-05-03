package util;

import java.util.Scanner;

public class InterfaceUser {
    private static Scanner input = new Scanner(System.in);
    public static final String erro_vermelho = "\u001B[31m"; //Muda as cores de textos que informam erros.
    public static final String reset = "\u001B[0m";

    public static double inputDouble(String mensage) {
        while (true) {
            System.out.print(mensage);
            String lerInput = input.nextLine().trim();
            lerInput = lerInput.replace(",", "."); //Troca ',' por '.'

            if (lerInput.isEmpty()) { //Verifica se o campo esta vazio.
                continue;
            }

            try {
                double opSelecionada = Double.parseDouble(lerInput);  //Traduz o valor da String para Double.

                if (opSelecionada < 0) { //verifica se o numero é menor que zero.
                    System.out.println(erro_vermelho + "ERRO!! O VALOR NÃO PODE SER NEGATIVO!!" + reset);
                    continue;
                }
                return opSelecionada;

            } catch (NumberFormatException e) {
                System.out.println(erro_vermelho + "\nERRO!! DIGITE UM NUMERO VÁLIDO!!" + reset);
            }
        }
    }

    public static int inputInt(String mensage) {
        while (true) {
            System.out.print(mensage);
            String lerInput = input.nextLine().trim();
            lerInput = lerInput.replace(",", "."); //Converte ',' por '.'

            if (lerInput.isEmpty()) {
                continue;
            }

            try {
                int opSelecionada = Integer.parseInt(lerInput); //Traduz a String para Inteiro.

                if (opSelecionada < 0) { //verifica se o numero é menor que zero.
                    System.out.println(erro_vermelho + "ERRO!! O VALOR NÃO PODE SER NEGATIVO!!" +  reset);
                    continue;
                }
                return opSelecionada;
            } catch (NumberFormatException e) { //Lança uma exceção se o numero não for inteiro.
                System.out.println(erro_vermelho + "\nERRO!! DIGITE UM NUMERO INTEIRO VÁLIDO!!" + reset);
            }
        }
    }

    public static String inputString(String mensage) {
        while (true) {
            System.out.print(mensage);
            String lerInput = input.nextLine().trim();
            lerInput = lerInput.trim();

            if (!lerInput.isEmpty()) { //Verifica se o campo está vazio.
                return lerInput;
            }
            System.out.println(erro_vermelho + "\nERRO!! O TEXTO NÃO PODE ESTAR VAZIO" + reset);

        }
    }
}



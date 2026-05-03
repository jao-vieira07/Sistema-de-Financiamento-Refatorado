package controller;

import dataAccessObject.FinanciamentoDAO;
import model.Apartamento;
import model.Casa;
import model.Financiamento;
import model.Terreno;
import util.InterfaceUser;

import java.util.ArrayList;

public class SystemInterface {
    private ArrayList<Financiamento> financiamentos = new ArrayList<>();//Cria um array que recebe a classe financiamento.
    private FinanciamentoDAO fdao = new FinanciamentoDAO();
    public void iniciarSistema() {
        this.financiamentos = fdao.consultarFinanciamentos();

        int opcao;

        do { //Uso do "do" para que o programa se inicie uma vez.

            System.out.println(""" 
                    J-FINANCE
                    
                    [1] - FINANCIAMENTO CASA
                    [2] - FINANCIAMENTO APARTAMENTO
                    [3] - FINANCIAMENTO TERRENO
                    [4] - RELATÓRIOS DE FINANCIAMENTOS
                    [0] - SAIR
                    """); // imprime um menu

            opcao = InterfaceUser.inputInt("INFORME A OPÇÃO DESEJADA: "); // solicita a opção ao usuário.
            Financiamento f;
            switch (opcao) {
                case 1:
                    System.out.println("\nFINANCIAMENTO CASA: ");
                    double valorFCasa = InterfaceUser.inputDouble("\nINFORME O VALOR DO FINANCIAMENTO: ");
                    int prazoFCasa = InterfaceUser.inputInt("\nINFORME O PRAZO DO FINANCIAMENTO: ");
                    double jurosFCasa = InterfaceUser.inputDouble("\nINFORME O JUROS DO FINANCIAMENTO: ");
                    double areaCasa = InterfaceUser.inputDouble("\nINFORME A AREA DA CASA: ");
                    double areaTerreno = InterfaceUser.inputDouble("\nINFORME A AREA DO TERRENO: ");

                    f = new Casa(valorFCasa, prazoFCasa, jurosFCasa, areaCasa, areaTerreno); //crie um novo objeto Casa em array de financimentos.
                    financiamentos.add(f); //adiciona o novo objeto casa.
                    fdao.salvar(f);//Salva na tabela do DB do postgre.
                    System.out.println("FINANCIAMENTO EFETUADO COM SUCESSO!!");
                    break;
                case 2:
                    System.out.println("\nFINANCIAMENTO APARTAMENTO: ");
                    double valorFAp = InterfaceUser.inputDouble("\nINFORME O VALOR DO FINANCIAMENTO: ");
                    int prazoFAp = InterfaceUser.inputInt("\nINFORME O PRAZO DO FINANCIAMENTO: ");
                    double jurosFAp = InterfaceUser.inputDouble("\nINFORME O JUROS DO FINANCIAMENTO: ");
                    int vagaAp = InterfaceUser.inputInt("\nINFORME O VAGA DA GARAGEM DO APARTAMENTO: ");
                    int andarAp = InterfaceUser.inputInt("\nINFORME O ANDAR DO APARTAMENTO: ");

                    f = new Apartamento(valorFAp, prazoFAp, jurosFAp, vagaAp, andarAp); //crie um novo objeto Apartamento em array de financimentos.
                    financiamentos.add(f); //add o novo obejeto apartamento.
                    fdao.salvar(f);//Salva na tabela do DB do postgre.
                    System.out.println("FINANCIAMENTO EFETUADO COM SUCESSO!!");
                    break;
                case 3:
                    System.out.println("\nFINANCIAMENTO TERRENO: ");
                    double valorFTerreno = InterfaceUser.inputDouble("\nINFORME O VALOR DO FINANCIAMENTO: ");
                    int prazoFTerreno = InterfaceUser.inputInt("\nINFORME O PRAZO DO FINANCIAMENTO: ");
                    double jurosFTerreno = InterfaceUser.inputDouble("\nINFORME O JUROS DO FINANCIAMENTO: ");
                    String zonaTerreno = InterfaceUser.inputString("\nINFORME A ZONA DO TERRENO  [ZONA RURAL] [ZONA URBANA]: ");

                    f = new Terreno(valorFTerreno, prazoFTerreno, jurosFTerreno, zonaTerreno);
                    financiamentos.add(f);
                    fdao.salvar(f);//Salva na tabela do DB do postgre.
                    System.out.println("FINANCIAMENTO EFETUADO COM SUCESSO!!");
                    break;
                case 4:
                    if (this.financiamentos.isEmpty()) {
                        System.out.println(InterfaceUser.erro_vermelho + "ERRO! NÃO HÁ NENHUM RELATÓRIO DISPONÍVEL!!" + InterfaceUser.reset);
                    } else {
                        exibirRelatorio();
                    }
                    break;
                case 0:
                    System.out.println("AGRADECEMOS POR UTILIZAR NOSSOS SERVIÇOS!!");
                    break;
                default:
                    System.out.println("ERRO!! INFORME UMA ALTERNATIVA VÁLIDA!!");
            }

        } while (opcao != 0);
    }

    private void exibirRelatorio() {
        System.out.println("""
                RELATÓRIOS DE FINANCIAMENTOS
                [1] - RELATÓRIO DE CASAS
                [2] - RELATÓRIO DE APARTAMENTOS
                [3] - RELATÓRIO DE TERRENOS""");
        int opcaoR = InterfaceUser.inputInt("INFORME A OPÇÃO DESEJADA: ");

        switch (opcaoR) {
            case 1:
                System.out.println("--RELATÓRIO DE FINANCIAMENTOS CASAS--");
                for (Financiamento fin : financiamentos) {
                    if (fin instanceof Casa c) {
                        System.out.println(c.toString());
                    }
                }
                break;
            case 2:
                System.out.println("--RELATÓRIOS DE FINANCIAMENTOS APARTAMENTOS--");
                for (Financiamento fin : financiamentos) {
                    if (fin instanceof Apartamento a) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 3:
                System.out.println("--RELATÓRIOS DE FINANCIAMENTOS TERRENOS--");
                for (Financiamento fin : financiamentos) {
                    if (fin instanceof Terreno t) {
                        System.out.println(t.toString());
                    }
                }
                break;
            default:
                System.out.println("ERRO!! INFORME UM VALOR VÁLIDO!!");
        }
    }
}

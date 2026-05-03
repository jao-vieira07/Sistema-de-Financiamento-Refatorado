package main;


import controller.SystemInterface;

public class Main {
    static void main(String[] args) {
        SystemInterface system = new SystemInterface();
        system.iniciarSistema(); /** Chama o metodo que imprime toda a interface,
        // assim deixando essa classe mais limpa. **/
    }
}

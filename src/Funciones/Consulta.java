package Funciones;


public class Consulta extends Atributos{

    @Override
    public void Transacciones (){
        System.out.println("-----------------------------------");
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("-----------------------------------");
    }
}

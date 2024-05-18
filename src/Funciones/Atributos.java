package Funciones;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Atributos {

    protected int transacciones, retiro, deposito;
    private static int saldo;
    Scanner entrada = new Scanner(System.in);
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Atributos() {
        // Agregar usuarios predefinidos
        usuarios.add(new Usuario("user1", "password1"));
        usuarios.add(new Usuario("user2", "password2"));
    }

        public void iniciarSesion () {
            boolean loggedIn = false;
            while (!loggedIn) {
                System.out.print("Ingrese su nombre de usuario: ");
                String NombreUsuario = entrada.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String password = entrada.nextLine();

                for (Usuario user : usuarios) {
                    if (user.getNombreUsuario().equals(NombreUsuario) && user.getPassword().equals(password)) {
                        loggedIn = true;
                        System.out.println("Inicio de sesión exitoso. Bienvenido, " + NombreUsuario + "!");
                        operaciones();
                        break;
                    }
                }

                if (!loggedIn) {
                    System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
                }
            }
        }

        public void operaciones () {
            int bandera = 0;
            int seleccion = 0;
            do {
                do {
                    System.out.println("Por favor seleccione una opción: ");
                    System.out.println("      1. Consulta de saldo. ");
                    System.out.println("      2. Retiro de efectivo. ");
                    System.out.println("      3. Depositar dinero. ");
                    System.out.println("      4. Salir. ");
                    seleccion = entrada.nextInt();

                    if (seleccion >= 1 && seleccion <= 4) {
                        bandera = 1;
                    } else {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Opcion no valida, vuelve a intentarlo por favor. ");
                        System.out.println("--------------------------------------------------");
                    }
                } while (bandera == 0);

                if (seleccion == 1) {
                    Atributos mensaje = new Consulta();
                    mensaje.Transacciones();

                } else if (seleccion == 2) {
                    Atributos mensaje = new Retiro();
                    mensaje.Transacciones();

                } else if (seleccion == 3) {
                    Atributos mensaje = new Depositar();
                    mensaje.Transacciones();

                } else if (seleccion == 4) {
                    System.out.println("---------- ");
                    System.out.println("¡Gracias! ");
                    System.out.println("---------- ");
                    bandera = 2;
                }

            } while (bandera != 2);
        }

        //Metodo para solicitar cantidad de retiro
        public void Retiro () {
            retiro = entrada.nextInt();
        }

        //Metodo para solicitar deposito de dinero
        public void Deposito () {
            deposito = entrada.nextInt();
        }

        //Metodo Abstracto
        public abstract void Transacciones ();

        //Metodos setter y getter
        public int getSaldo () {
            return saldo;
        }

        public void setSaldo ( int saldo){
            this.saldo = saldo;

        }

    }




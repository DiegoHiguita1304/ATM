package Funciones;

public class Usuario {
        private String NombreUsuario;
        private String password;

        public Usuario(String NombreUsuario, String password) {
            this.NombreUsuario = NombreUsuario;
            this.password = password;
        }

        public String getNombreUsuario() {
            return NombreUsuario;
        }

        public String getPassword() {
            return password;
        }
    }


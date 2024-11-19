/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.ArrayList;

public class Login {
    private ArrayList<Usuario> usuarios;

    public Login() {
        usuarios = new ArrayList<>(); 
        usuarios.add(new Usuario("EscAdm21_JF", "A3sCur4!2024", "administracion"));
    }

    public boolean autenticar(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && 
                usuario.getContraseña().equals(contraseña) && 
                usuario.getRol().equals("administracion")) {
                return true;
            }
        }
        return false;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.SysProyec.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upeu.SysProyec.modelo.Cliente;

@Service
public class ClienteService {

    List<Cliente> listaCli = new ArrayList<>();

    public boolean saveEntidad(Cliente categoria) {
        return this.listaCli.add(categoria);
    }

    public List<Cliente> listarEntidad() {
        return listaCli;
    }

    public Cliente buscarCliente(String dnix) {
        return listaCli.stream()
                .filter(cliente -> cliente.getDni().equals(dnix))
                .findFirst()
                .orElse(null); // Devuelve null si no se encuentra ningún cliente
    }

    public Cliente updateEntidad(Cliente clientex) {
        listaCli.stream()
                .filter(cliente
                        -> cliente.getDni().equals(clientex.getDni())) // Filtrar por DNI
                .findFirst() // Obtener el primer cliente que cumpla con el filtro
                .ifPresent(cliente
                        -> cliente.setNombres(clientex.getNombres()));
        //return this.listaCli.set(index, cliente);
        return buscarCliente(clientex.getDni());
    }

    public void deleteRegistEntdad(String dato) {
        this.listaCli.remove(listaCli.stream()
                .filter(cliente -> cliente.getDni().equals(dato))
                .findFirst().orElse(null));
    }
}

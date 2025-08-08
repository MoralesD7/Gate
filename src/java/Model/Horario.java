/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class Horario {
    List<Dia> dias;
    public Horario() {
    }
    public Horario(List<Dia> dias) {
        this.dias = dias;
    }

    public List<Dia> getDias() {
        return dias;
    }

    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Horario{" + "dias=" + dias + '}';
    }
    
    
    
}

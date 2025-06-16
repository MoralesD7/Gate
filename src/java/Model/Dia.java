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
public class Dia {
    private String dia ; 
    private List<Materia>materia;

    public Dia() {
    }

    public Dia(String dia, List<Materia> materia) {
        this.dia = dia;
        this.materia = materia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Dia{" + "dia=" + dia + ", materia=" + materia + '}';
    }
    
}

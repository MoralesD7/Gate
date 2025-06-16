/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;


public class Horario {
    private String hora_inicio;
    private String hora_termino;
    private List<Dia> dia ;

    public Horario(){}

    public Horario(String hora_inicio, String hora_termino, List<Dia> dia) {
        this.hora_inicio = hora_inicio;
        this.hora_termino = hora_termino;
        this.dia = dia;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_termino() {
        return hora_termino;
    }

    public void setHora_termino(String hora_termino) {
        this.hora_termino = hora_termino;
    }

    public List<Dia> getDia() {
        return dia;
    }

    public void setDia(List<Dia> dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Horario{" + "hora_inicio=" + hora_inicio + ", hora_termino=" + hora_termino + ", dia=" + dia + '}';
    }
    
    
    
}

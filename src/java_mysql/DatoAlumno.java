/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_mysql;

/**
 *
 * @author raul
 */
public class DatoAlumno {

    private String NumeroDeContro;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String FechaNacimiento;

    public DatoAlumno(String NumeroDeControl, String Nombre,
            String ApellidoPaterno, String ApellidoMaterno, String FechaNacimiento) {
        this.NumeroDeContro = NumeroDeControl;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.FechaNacimiento = FechaNacimiento;

    }

    public String getNumeroDeControl() {
        return NumeroDeContro;
    }

    public void setNumeroDeControl(String NumeroDeControl) {
        this.NumeroDeContro = NumeroDeControl;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

}

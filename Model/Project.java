
package Model;

import java.sql.Date;

public class Project {
    
    private int id;
    private String name, Password, area;

    public Project() {
    }

    //Método construtor para atribuição de valores dos atributos
    public Project(int id, String name, String Password, String area) {
        this.id = id;
        this.name = name;
        this.Password = Password;
        this.area = area;
    }
    
    public void Project(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", Password=" + Password + ", area=" + area + '}';
    }
}

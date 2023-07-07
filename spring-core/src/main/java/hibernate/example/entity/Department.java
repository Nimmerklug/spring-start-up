package hibernate.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Auto - choose based on table || Identity - auto || Sequence - sequence from oracle
    private Integer id;
    @Column(name = "DEPARTMENT_NAME")
    private String name;
    @Column(name = "MANAGER_ID")
    private Integer manager_id;

    public Department() {
    }

    public Department(String name, Integer manager_id) {
        this.name = name;
        this.manager_id = manager_id;
    }

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

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager_id=" + manager_id +
                '}';
    }
}

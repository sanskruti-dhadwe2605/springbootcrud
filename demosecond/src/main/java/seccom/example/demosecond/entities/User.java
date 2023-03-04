package seccom.example.demosecond.entities;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
    
    @Entity
    @Table(name="user_table")
    @DynamicUpdate
    public class User{ 
        @Id
        

        @Column(name="id")
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
@Column(name="name")
private String name;


@Column(name="age")
private Integer age;

@Column(name="mobileNo")
private int mobileNSo;





public Integer getId() {
    return id;
}





public void setId(Integer id) {
    this.id = id;
}





public String getName() {
    return name;
}





public void setName(String name) {
    this.name = name;
}





public Integer getAge() {
    return age;
}





public void setAge(Integer age) {
    this.age = age;
}





public int getMobileNSo() {
    return mobileNSo;
}





public void setMobileNSo(int mobileNSo) {
    this.mobileNSo = mobileNSo;
}





public User(Integer id, String name, Integer age, int mobileNSo) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.mobileNSo = mobileNSo;
}





public User() {
}


    }

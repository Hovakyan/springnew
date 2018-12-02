package springprojectdb.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MyUserofficers {

    @Id
    @GeneratedValue
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", foreignKey = @ForeignKey(name = "user_officers_my_user_id"))
    private MyUser user;

    @Column (length = 500)
    private  String people_Name;
    @Column (length = 500)
    private  String people__Adres;
    @Column(length = 500)
    private  String people_Role;
    @Column(length = 500)
    private  String people_Date_of_birth;
    @Column(length = 500)
    private  String people_Appointed_on;
    @Column(length = 500)
    private  String people_Nationality;
    @Column(length = 500)
    private  String people_Country_of_residence;
    @Column(length = 500)
    private  String people_Occupation;



//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getPeople_Name() {
        return people_Name;
    }

    public void setPeople_Name(String people_Name) {
        this.people_Name = people_Name;
    }

    public String getPeople__Adres() {
        return people__Adres;
    }

    public void setPeople__Adres(String people__Adres) {
        this.people__Adres = people__Adres;
    }

    public String getPeople_Role() {
        return people_Role;
    }

    public void setPeople_Role(String people_Role) {
        this.people_Role = people_Role;
    }

    public String getPeople_Date_of_birth() {
        return people_Date_of_birth;
    }

    public void setPeople_Date_of_birth(String people_Date_of_birth) {
        this.people_Date_of_birth = people_Date_of_birth;
    }

    public String getPeople_Appointed_on() {
        return people_Appointed_on;
    }

    public void setPeople_Appointed_on(String people_Appointed_on) {
        this.people_Appointed_on = people_Appointed_on;
    }

    public String getPeople_Nationality() {
        return people_Nationality;
    }

    public void setPeople_Nationality(String people_Nationality) {
        this.people_Nationality = people_Nationality;
    }

    public String getPeople_Country_of_residence() {
        return people_Country_of_residence;
    }

    public void setPeople_Country_of_residence(String people_Country_of_residence) {
        this.people_Country_of_residence = people_Country_of_residence;
    }

    public String getPeople_Occupation() {
        return people_Occupation;
    }

    public void setPeople_Occupation(String people_Occupation) {
        this.people_Occupation = people_Occupation;
    }



}

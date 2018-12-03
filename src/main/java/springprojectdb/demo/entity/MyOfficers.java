package springprojectdb.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MyOfficers {

    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myCompany_officerslist_id", foreignKey = @ForeignKey(name = "myCompany_officerslist_my_officers"))

    private MyCompany myCompany;



    @Column ( nullable = false ,length = 500)
    private  String peopleName;
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


    public void setPeople_Name(String people_Name) {
        this.peopleName = people_Name;
    }

    public void setPeople__Adres(String people__Adres) {
        this.people__Adres = people__Adres;
    }

    public void setPeople_Role(String people_Role) {
        this.people_Role = people_Role;
    }

    public void setPeople_Date_of_birth(String people_Date_of_birth) {
        this.people_Date_of_birth = people_Date_of_birth;
    }

    public void setPeople_Appointed_on(String people_Appointed_on) {
        this.people_Appointed_on = people_Appointed_on;
    }

    public void setPeople_Nationality(String people_Nationality) {
        this.people_Nationality = people_Nationality;
    }

    public void setPeople_Country_of_residence(String people_Country_of_residence) {
        this.people_Country_of_residence = people_Country_of_residence;
    }

    public void setPeople_Occupation(String people_Occupation) {
        this.people_Occupation = people_Occupation;
    }




}

package springprojectdb.demo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company_names")
@Getter
@Setter
@NoArgsConstructor
public class MyCompany {

    @Id
    @GeneratedValue

    private Integer id;

    @Column(length = 500)
    private  String companyName;

    @Column(length = 500)
    private  String company_ID;

    @Column(length = 500)
    private  String company_Registeredofficaddress;

    @Column(length = 500)
    private  String company_Status;

    @Column(length = 500)
    private  String company_Type;

    @Column(length = 500)
    private  String company_Accounts;

    @Column(length = 500)
    private  String company_NatureOf_BusinessSIC;

    @Column(length = 500)
    private  String company_Previous_names;

    @OneToMany(mappedBy = "myCompany")
    private List<MyOfficers> officerslist;


    public String getCompany_Previous_names() {
        return company_Previous_names;
    }

    public List<MyOfficers> getOfficerslist() {
        return officerslist;
    }

    public void setCompany_Previous_names(String company_Previous_names) {
        this.company_Previous_names = company_Previous_names;
    }

    public void setOfficerslist(List<MyOfficers> officerslist) {
        this.officerslist = officerslist;
    }

    public  void setCompanyName(String companyName) {

            this.companyName = companyName;
    }

    public void setCompany_ID(String company_ID) {
        this.company_ID = company_ID;
    }

    public void setCompany_Registeredofficaddress(String company_Registeredofficaddress) {
        this.company_Registeredofficaddress = company_Registeredofficaddress;
    }

    public void setCompany_Status(String company_Status) {
        this.company_Status = company_Status;
    }

    public void setCompany_Type(String company_Type) {
        this.company_Type = company_Type;
    }

    public void setCompany_Accounts(String company_Accounts) {
        this.company_Accounts = company_Accounts;
    }

    public void setCompany_NatureOf_BusinessSIC(String company_NatureOf_BusinessSIC) {
        this.company_NatureOf_BusinessSIC = company_NatureOf_BusinessSIC;
    }

}

package springprojectdb.demo.entity;


import javafx.beans.binding.When;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "user_company")
@Getter
@Setter
@NoArgsConstructor
public class MyUser {


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




    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MyUserofficers> officers;

    public void setofficers(List<MyUserofficers> officers) {
        this.officers = officers;
    }





    public List<MyUserofficers> getofficers() {
        return officers;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public  void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompany_ID() {
        return company_ID;
    }

    public void setCompany_ID(String company_ID) {
        this.company_ID = company_ID;
    }

    public String getCompany_Registeredofficaddress() {
        return company_Registeredofficaddress;
    }

    public void setCompany_Registeredofficaddress(String company_Registeredofficaddress) {
        this.company_Registeredofficaddress = company_Registeredofficaddress;
    }

    public String getCompany_Status() {
        return company_Status;
    }

    public void setCompany_Status(String company_Status) {
        this.company_Status = company_Status;
    }

    public String getCompany_Type() {
        return company_Type;
    }

    public void setCompany_Type(String company_Type) {
        this.company_Type = company_Type;
    }

    public String getCompany_Accounts() {
        return company_Accounts;
    }

    public void setCompany_Accounts(String company_Accounts) {
        this.company_Accounts = company_Accounts;
    }

    public String getCompany_NatureOf_BusinessSIC() {
        return company_NatureOf_BusinessSIC;
    }

    public void setCompany_NatureOf_BusinessSIC(String company_NatureOf_BusinessSIC) {
        this.company_NatureOf_BusinessSIC = company_NatureOf_BusinessSIC;
    }

    public String getPrevious_company_names() {
        return company_Previous_names;
    }

    public void setPrevious_company_names(String previous_company_names) {
        company_Previous_names = previous_company_names;
    }


}

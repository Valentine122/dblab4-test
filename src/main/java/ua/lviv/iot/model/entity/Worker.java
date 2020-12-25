package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "worker")
public class Worker {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 500)
    private String name;
    @Column(name = "surname", length = 500)
    private String surname;
    @Column(name = "date_of_employment")
    private Date dateOfEmployment;
    @Column(name = "Technic_id")
    private Integer TechnicId;
    @Column(name = "Technic_Bosch_service_id")
    private Integer TechnicBoschServiceId;
    @Column(name = "status", length = 20)
    private String status;

    public Worker() {}

    public Worker(String name, String surname, Date dateOfEmployment, Integer TechnicId, Integer TechnicBoschServiceId, String status) {
        this(-1, name, surname, dateOfEmployment, TechnicId, TechnicBoschServiceId, status);
    }

    public Worker(Integer id, String name, String surname, Date dateOfEmployment, Integer TechnicId, Integer TechnicBoschServiceId, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfEmployment = dateOfEmployment;
        this.TechnicId = TechnicId;
        this.TechnicBoschServiceId = TechnicBoschServiceId;
        this.status = status;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Integer getTechnicId() {
        return TechnicId;
    }

    public void setTechnicId(Integer TechnicId) {
        this.TechnicId = TechnicId;
    }

    public Integer getTechnicBoschServiceId() {
        return TechnicBoschServiceId;
    }

    public void setTechnicBoschServiceId(Integer TechnicBoschServiceId) {
        this.TechnicBoschServiceId = TechnicBoschServiceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                ", TechnicId=" + TechnicId +
                ", childGroupKindergartenId=" + TechnicBoschServiceId +
                ", status='" + status + '\'';
    }
}


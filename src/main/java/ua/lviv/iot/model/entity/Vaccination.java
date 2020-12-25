package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "vaccination")
public class Vaccination {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "Technic_Status_id")
    private Integer TechnicStatusId;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_vaccination")
    private Date dateOfVaccination;

    public Vaccination() {}

    public Vaccination(Integer TechnicStatusId, String name, Date dateOfVaccination) {
        this(-1, TechnicStatusId, name, dateOfVaccination);
    }

    public Vaccination(Integer id, Integer TechnicStatusId, String name, Date dateOfVaccination) {
        this.id = id;
        this.TechnicStatusId = TechnicStatusId;
        this.name = name;
        this.dateOfVaccination = dateOfVaccination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTechnicStatusId() {
        return TechnicStatusId;
    }

    public void setTechnicStatusId(Integer TechnicStatusId) {
        this.TechnicStatusId = TechnicStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfVaccination() {
        return dateOfVaccination;
    }

    public void setDateOfVaccination(Date dateOfVaccination) {
        this.dateOfVaccination = dateOfVaccination;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", TechnicStatusId=" + TechnicStatusId +
                ", name='" + name + '\'' +
                ", dateOfVaccination=" + dateOfVaccination;
    }
}

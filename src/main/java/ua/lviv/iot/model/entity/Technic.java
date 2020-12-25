package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "child_group")
public class Technic {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "Bosch_service_id")
    private Integer BoschServiceId;
    @Column(name = "name", length = 200)
    private String name;

    public Technic() {}

    public Technic(Integer BoschServiceId, String name) {
        this(-1, BoschServiceId, name);
    }

    public Technic(Integer id, Integer BoschServiceId, String name) {
        this.id = id;
        this.BoschServiceId = BoschServiceId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoschServiceId() {
        return BoschServiceId;
    }

    public void setBoschServiceId(Integer BoschServiceId) {
        this.BoschServiceId = BoschServiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", BoschServiceId=" + BoschServiceId +
                ", name='" + name;
    }
}

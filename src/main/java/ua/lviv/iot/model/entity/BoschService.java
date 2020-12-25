package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "BoschService")
public class BoschService {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building_number")
    private Integer buildingNumber;

    public BoschService() {}

    public BoschService(String city, String street, Integer buildingNumber) {
        this(-1, city, street, buildingNumber);
    }

    public BoschService(Integer id, String city, String street, Integer buildingNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }


    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber;
    }
}

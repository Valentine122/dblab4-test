package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "Technic_info")
public class TechnicInfo {
    @PrimaryKey
    @Column(name = "Technic_status_")
    private Integer TechnicStatusId;
    @Column(name = "Spare_parts")
    private String SpareParts;
    @Column(name = "info_phone_number", length = 20)
    private String infoPhoneNumber;

    public TechnicInfo() {}

    public TechnicInfo(String SpareParts, String infoPhoneNumber) {
        this(-1, SpareParts, infoPhoneNumber);
    }

    public TechnicInfo(Integer TechnicStatusId, String SpareParts, String infoPhoneNumber) {
        this.TechnicStatusId = TechnicStatusId;
        this.SpareParts = SpareParts;
        this.infoPhoneNumber = infoPhoneNumber;
    }

    public Integer getTechnicStatusId() {
        return TechnicStatusId;
    }

    public void setTechnicStatusId(Integer TechnicStatusId) {
        this.TechnicStatusId = TechnicStatusId;
    }

    public String getSpareParts() {
        return SpareParts;
    }

    public void setSpareParts(String SpareParts) {
        this.SpareParts = SpareParts;
    }

    public String getInfoPhoneNumber() {
        return infoPhoneNumber;
    }

    public void setInfoPhoneNumber(String infoPhoneNumber) {
        this.infoPhoneNumber = infoPhoneNumber;
    }

    @Override
    public String toString() {
        return "\n" +
                "TechnicStatusId=" + TechnicStatusId +
                ", SpareParts='" + SpareParts + '\'' +
                ", infoPhoneNumber='" + infoPhoneNumber;
    }
}

package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "technic status")
public class TechnicStatus {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "Technic_id")
    private Integer TechnicId;
    @Column(name = "Technic_Bosch_service_id")
    private Integer TechnicBoschServiceId;
    @Column(name = "status", length = 20)
    private String status;

    public TechnicStatus() {}

    public TechnicStatus(Integer TechnicId, Integer TechnicBoschServiceId, String status) {
        this(-1, TechnicId, TechnicBoschServiceId, status);
    }

    public TechnicStatus(Integer id, Integer TechnicId, Integer TechnicBoschServiceId, String status) {
        this.id = id;
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
                ", childGroupId=" + TechnicId +
                ", childGroupKindergartenId=" + TechnicBoschServiceId +
                ", status='" + status + '\'';
    }
}

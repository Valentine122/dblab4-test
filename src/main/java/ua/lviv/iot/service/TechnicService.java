package ua.lviv.iot.service;

import ua.lviv.iot.DAO.TechnicDAO;
import ua.lviv.iot.model.entity.Technic;

public class TechnicService extends BaseService<Technic, Integer, TechnicDAO>{
    public TechnicService() {
        super(TechnicDAO.class);
    }
}

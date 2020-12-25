package ua.lviv.iot.service;

import ua.lviv.iot.DAO.TechnicStatusDAO;
import ua.lviv.iot.model.entity.TechnicStatus;

public class TechnicStatusService extends BaseService<TechnicStatus, Integer, TechnicStatusDAO>{
    public TechnicStatusService() {
        super(TechnicStatusDAO.class);
    }
}

package ua.lviv.iot.service;

import ua.lviv.iot.DAO.TechnicInfoDAO;
import ua.lviv.iot.model.entity.TechnicInfo;

public class TechnicInfoService extends BaseService<TechnicInfo, Integer, TechnicInfoDAO>{
    public TechnicInfoService() {
        super(TechnicInfoDAO.class);
    }
}

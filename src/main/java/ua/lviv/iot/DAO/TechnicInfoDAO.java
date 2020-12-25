package ua.lviv.iot.DAO;

import ua.lviv.iot.model.entity.TechnicInfo;

public class TechnicInfoDAO extends BaseDAO<TechnicInfo, Integer>{
    public TechnicInfoDAO() {
        super(TechnicInfo.class);
    }
}

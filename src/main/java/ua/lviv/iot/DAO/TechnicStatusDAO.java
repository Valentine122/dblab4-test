package ua.lviv.iot.DAO;

import ua.lviv.iot.model.entity.TechnicStatus;

public class TechnicStatusDAO extends BaseDAO<TechnicStatus, Integer>{
    public TechnicStatusDAO() {
        super(TechnicStatus.class);
    }
}

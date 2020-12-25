package ua.lviv.iot.DAO;

import ua.lviv.iot.model.entity.Technic;

public class TechnicDAO extends BaseDAO<Technic, Integer>{
    public TechnicDAO() {
        super(Technic.class);
    }
}

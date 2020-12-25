package ua.lviv.iot.service;

import ua.lviv.iot.DAO.BoschServiceDAO;
import ua.lviv.iot.model.entity.BoschService;

public class BoschServiceService extends BaseService<BoschService, Integer, BoschServiceDAO>{
    public BoschServiceService() {
        super(BoschServiceDAO.class);
    }
}

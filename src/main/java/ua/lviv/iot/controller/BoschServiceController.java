package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.BoschService;
import ua.lviv.iot.service.BoschServiceService;

public class BoschServiceController extends BaseController<BoschService, Integer, BoschServiceService>{
    public BoschServiceController() {
        super(BoschServiceService.class);
    }
}

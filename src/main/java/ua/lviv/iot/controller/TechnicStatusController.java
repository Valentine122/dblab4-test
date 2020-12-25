package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.TechnicStatus;
import ua.lviv.iot.service.TechnicStatusService;

public class TechnicStatusController extends BaseController<TechnicStatus, Integer, TechnicStatusService> {
    public TechnicStatusController() {
        super(TechnicStatusService.class);
    }
}

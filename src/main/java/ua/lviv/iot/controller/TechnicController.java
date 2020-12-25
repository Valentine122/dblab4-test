package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.Technic;
import ua.lviv.iot.service.TechnicService;

public class TechnicController extends BaseController<Technic, Integer, TechnicService>{
    public TechnicController() {
        super(TechnicService.class);
    }
}

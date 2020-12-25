package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.TechnicInfo;
import ua.lviv.iot.service.TechnicInfoService;

public class TechnicInfoController extends BaseController<TechnicInfo, Integer, TechnicInfoService>{
    public TechnicInfoController() {
        super(TechnicInfoService.class);
    }
}

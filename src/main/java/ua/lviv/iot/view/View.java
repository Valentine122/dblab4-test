package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.entity.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final TechnicStatusController TechnicStatusController = new TechnicStatusController();
    private final TechnicController TechnicController = new TechnicController();
    private final BoschServiceController BoschServiceController = new BoschServiceController();
    private final TechnicInfoController TechnicInfoController = new TechnicInfoController();
    private final PaymentController paymentController = new PaymentController();
    private final VaccinationController vaccinationController = new VaccinationController();
    private final WorkerController workerController = new WorkerController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("Q", "Q - exit program");
        menu.put("S", "S - show menu");

        menu.put("1", "1 - Get all TechnicStatus");
        menu.put("2", "2 - Get a TechnicStatus by ID");
        menu.put("3", "3 - Create a TechnicStatus");
        menu.put("4", "4 - Delete a TechnicStatus by ID");
        menu.put("5", "5 - Update a TechnicStatus \n");

        menu.put("6", "6 - Get all Technic");
        menu.put("7", "7 - Get a Technic by ID");
        menu.put("8", "8 - Create a Technic");
        menu.put("9", "9 - Delete a Technic");
        menu.put("0", "0 - Update a Technic \n");

        menu.put("11", "11 - Get all BoschService");
        menu.put("12", "12 - Get a BoschService by ID");
        menu.put("13", "13 - Create a BoschService");
        menu.put("14", "14 - Delete a BoschService");
        menu.put("15", "15 - Update a BoschService \n");

        menu.put("21", "21 - Get all Technic info");
        menu.put("22", "22 - Get Technic info by TechnicStatus ID");
        menu.put("23", "23 - Create Technic info for TechnicStatus");
        menu.put("24", "24 - Delete Technic info by TechnicStatus ID");
        menu.put("25", "25 - Update Technic info \n");

        menu.put("31", "31 - Get all payment info");
        menu.put("32", "32 - Get payment info by worker ID");
        menu.put("33", "33 - Create payment info for worker");
        menu.put("34", "34 - Delete payment info by worker ID");
        menu.put("35", "35 - Update payment info \n");

        menu.put("41", "41 - Get all vaccination info");
        menu.put("42", "42 - Get vaccination info by TechnicStatus ID");
        menu.put("43", "43 - Create vaccination info for TechnicStatus");
        menu.put("44", "44 - Delete vaccination info by TechnicStatus ID");
        menu.put("45", "45 - Update vaccination info \n");

        menu.put("51", "51 - Get all workers");
        menu.put("52", "52 - Get a worker by ID");
        menu.put("53", "53 - Create a worker");
        menu.put("54", "54 - Delete a worker by ID");
        menu.put("55", "55 - Update a worker \n");

        methodsMenu.put("S", this::outputMenu);

        methodsMenu.put("1", this::getAllTechnicStatus);
        methodsMenu.put("2", this::getTechnicStatusById);
        methodsMenu.put("3", this::createTechnicStatus);
        methodsMenu.put("4", this::deleteTechnicStatus);
        methodsMenu.put("5", this::updateTechnicStatus);

        methodsMenu.put("6", this::getAllTechnic);
        methodsMenu.put("7", this::getTechnicById);
        methodsMenu.put("8", this::createTechnic);
        methodsMenu.put("9", this::deleteGroup);
        methodsMenu.put("0", this::updateTechnic);

        methodsMenu.put("11", this::getAllBoschService);
        methodsMenu.put("12", this::getBoschServiceById);
        methodsMenu.put("13", this::createBoschService);
        methodsMenu.put("14", this::deleteBoschService);
        methodsMenu.put("15", this::updateBoschService);

        methodsMenu.put("21", this::getAllTechnicInfo);
        methodsMenu.put("22", this::getTechnicInfoByTechnicStatusId);
        methodsMenu.put("23", this::createTechnicInfoByTechnicStatusId);
        methodsMenu.put("24", this::deleteTechnicInfoByTechnicStatusId);
        methodsMenu.put("25", this::updateTechnicInfo);

        methodsMenu.put("31", this::getAllPaymentInfo);
        methodsMenu.put("32", this::getPaymentInfoByWorkerId);
        methodsMenu.put("33", this::createPaymentInfoByWorkerId);
        methodsMenu.put("34", this::deletePaymentInfoByWorkerId);
        methodsMenu.put("35", this::updatePaymentInfo);

        methodsMenu.put("41", this::getAllVaccinationInfo);
        methodsMenu.put("42", this::getVaccinationInfoByTechnicStatusId);
        methodsMenu.put("43", this::createVaccinationInfoByTechnicStatusId);
        methodsMenu.put("44", this::deleteVaccinationInfoByChildId);
        methodsMenu.put("45", this::updateVaccinationInfo);

        methodsMenu.put("51", this::getAllWorkers);
        methodsMenu.put("52", this::getWorkerById);
        methodsMenu.put("53", this::createWorker);
        methodsMenu.put("54", this::deleteWorker);
        methodsMenu.put("55", this::updateWorker);
    }

    private void getAllTechnicStatus() throws SQLException {
        System.out.println("\nTechnicStatus:");
        System.out.println(TechnicStatusController.findAll());
    }

    private void getTechnicStatusById() throws SQLException {
        System.out.println("\nEnter ID for a Technic Status you want to find");
        int id = INPUT.nextInt();
        System.out.println(TechnicStatusController.findBy(id));
    }

    private void createTechnicStatus() throws SQLException {
        System.out.println("\nEnter Technic ID");
        int TechnicId = INPUT.nextInt();
        System.out.println("\nEnter BoschServic ID");
        int TechnicBoschServiceId = INPUT.nextInt();
        System.out.println("\nEnter Technic status");
        String status = INPUT.next();
        TechnicStatus TechnicStatus = new TechnicStatus(TechnicId, TechnicBoschServiceId, status);
        System.out.println(TechnicStatusController.create(TechnicStatus));
    }

    private void updateTechnicStatus() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter Technic ID");
        int TechnicId = INPUT.nextInt();
        System.out.println("\nEnter BoschService ID");
        int TechnicBoschServiceId = INPUT.nextInt();
        System.out.println("\nEnter Technic status");
        String status = INPUT.next();
        TechnicStatus TechnicStatus = new TechnicStatus(id, TechnicId, TechnicBoschServiceId, status);
        System.out.println(TechnicStatusController.update(TechnicStatus));
    }

    private void deleteTechnicStatus() throws SQLException {
        System.out.println("\nEnter ID for TechnicStatus you want to delete");
        int id = INPUT.nextInt();
        System.out.println(TechnicStatusController.delete(id));
    }

    private void getAllTechnic() throws SQLException {
        System.out.println("\nTechnics:");
        System.out.println(TechnicController.findAll());
    }

    private void getTechnicById() throws SQLException {
        System.out.println("\nEnter ID for a Technic you want to find");
        int id = INPUT.nextInt();
        System.out.println(TechnicController.findBy(id));
    }

    private void createTechnic() throws SQLException {
        System.out.println("\nEnter BoschService ID");
        int BoschServiceId = INPUT.nextInt();
        System.out.println("\nEnter Technic name");
        String name = INPUT.next();
        Technic Technic = new Technic(BoschServiceId, name);
        System.out.println(TechnicController.create(Technic));
    }

    private void updateTechnic() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter BoschService ID");
        int BoschServiceId = INPUT.nextInt();
        System.out.println("\nEnter Technic name");
        String name = INPUT.next();
        Technic Technic = new Technic(id, BoschServiceId, name);
        System.out.println(TechnicController.update(Technic));
    }

    private void deleteGroup() throws SQLException {
        System.out.println("\nEnter ID for Technic you want to delete");
        int id = INPUT.nextInt();
        System.out.println(TechnicController.delete(id));
    }

    private void getAllBoschService() throws SQLException {
        System.out.println("\nBoschService:");
        System.out.println(BoschServiceController.findAll());
    }

    private void getBoschServiceById() throws SQLException {
        System.out.println("\nEnter ID for a BoschService you want to find");
        int id = INPUT.nextInt();
        System.out.println(BoschServiceController.findBy(id));
    }

    private void createBoschService() throws SQLException {
        System.out.println("\nEnter BoschService name");
        String city = INPUT.next();
        System.out.println("\nEnter BoschService street");
        String street = INPUT.next();
        System.out.println("\nEnter BoschService building number");
        int buildingNumber = INPUT.nextInt();
        BoschService BoschService = new BoschService(city, street, buildingNumber);
        System.out.println(BoschServiceController.create(BoschService));
    }

    private void updateBoschService() throws SQLException {
        System.out.println("\nEnter BoschService ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter BoschService name");
        String city = INPUT.next();
        System.out.println("\nEnter BoschService street");
        String street = INPUT.next();
        System.out.println("\nEnter BoschService building number");
        int buildingNumber = INPUT.nextInt();
        BoschService BoschService = new BoschService(id, city, street, buildingNumber);
        System.out.println(BoschServiceController.update(BoschService));
    }

    private void deleteBoschService() throws SQLException {
        System.out.println("\nEnter ID for BoschService you want to delete");
        int id = INPUT.nextInt();
        System.out.println(BoschServiceController.delete(id));
    }

    private void getAllTechnicInfo() throws SQLException {
        System.out.println("\nTechnic info:");
        System.out.println(TechnicInfoController.findAll());
    }

    private void getTechnicInfoByTechnicStatusId() throws SQLException {
        System.out.println("\nEnter ID to get information about Technic");
        int id = INPUT.nextInt();
        System.out.println(TechnicInfoController.findBy(id));
    }

    private void createTechnicInfoByTechnicStatusId() throws SQLException {
        System.out.println("\nEnter Technictatus ID");
        int TechnicStatusId = INPUT.nextInt();
        System.out.println("\nEnter Spare Parts");
        String SpareParts = INPUT.next();
        System.out.println("\nEnter info Phone Number");
        String infoPhoneNumber = INPUT.next();
        TechnicInfo TechnicInfo = new TechnicInfo(TechnicStatusId, SpareParts, infoPhoneNumber);
        System.out.println(TechnicInfoController.create(TechnicInfo));
    }

    private void updateTechnicInfo() throws SQLException {
        System.out.println("\nEnter TechnicStatus ID");
        int TechnicStatusId = INPUT.nextInt();
        System.out.println("\nEnter SpareParts");
        String SpareParts = INPUT.next();
        System.out.println("\nEnter info Phone Number");
        String infoPhoneNumber = INPUT.next();
        TechnicInfo TechnicInfo = new TechnicInfo(TechnicStatusId, SpareParts, infoPhoneNumber);
        System.out.println(TechnicInfoController.update(TechnicInfo));
    }

    private void deleteTechnicInfoByTechnicStatusId() throws SQLException {
        System.out.println("\nEnter ID to delete information about TechnicInfo");
        int id = INPUT.nextInt();
        System.out.println(TechnicInfoController.delete(id));
    }

    private void getAllPaymentInfo() throws SQLException {
        System.out.println("\nPayment info:");
        System.out.println(paymentController.findAll());
    }

    private void getPaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter ID to get information about payment");
        int id = INPUT.nextInt();
        System.out.println(paymentController.findBy(id));
    }

    private void createPaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter worker ID");
        int workerId = INPUT.nextInt();
        System.out.println("\nEnter salary");
        int salary = INPUT.nextInt();
        System.out.println("\nEnter amount of remuneration");
        int amountOfRemuneration = INPUT.nextInt();
        System.out.println("\nEnter date of pay (yyyy-mm-dd)");
        String dateOfPay = INPUT.next();
        Payment payment = new Payment(workerId, salary, amountOfRemuneration, Date.valueOf(dateOfPay));
        System.out.println(paymentController.create(payment));
    }

    private void updatePaymentInfo() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter worker ID");
        int workerId = INPUT.nextInt();
        System.out.println("\nEnter salary");
        int salary = INPUT.nextInt();
        System.out.println("\nEnter amount of remuneration");
        int amountOfRemuneration = INPUT.nextInt();
        System.out.println("\nEnter date of pay (yyyy-mm-dd)");
        String dateOfPay = INPUT.next();
        Payment payment = new Payment(id, workerId, salary, amountOfRemuneration, Date.valueOf(dateOfPay));
        System.out.println(paymentController.update(payment));
    }

    private void deletePaymentInfoByWorkerId() throws SQLException {
        System.out.println("\nEnter ID to delete information about payment");
        int id = INPUT.nextInt();
        System.out.println(paymentController.delete(id));
    }

    private void getAllVaccinationInfo() throws SQLException {
        System.out.println("\nVaccination info:");
        System.out.println(vaccinationController.findAll());
    }

    private void getVaccinationInfoByTechnicStatusId() throws SQLException {
        System.out.println("\nEnter ID to get information about vaccination");
        int id = INPUT.nextInt();
        System.out.println(vaccinationController.findBy(id));
    }

    private void createVaccinationInfoByTechnicStatusId() throws SQLException {
        System.out.println("\nEnter TechnicStatus ID");
        int TechnicStatusId = INPUT.nextInt();
        System.out.println("\nEnter vaccine name");
        String name = INPUT.next();
        System.out.println("\nEnter date of vaccination (yyyy-mm-dd)");
        String dateOfVaccination = INPUT.next();
        Vaccination vaccination = new Vaccination(TechnicStatusId, name, Date.valueOf(dateOfVaccination));
        System.out.println(vaccinationController.create(vaccination));
    }

    private void updateVaccinationInfo() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter vaccine name");
        String name = INPUT.next();
        System.out.println("\nEnter date of vaccination (yyyy-mm-dd)");
        String dateOfVaccination = INPUT.next();
        Vaccination vaccination = new Vaccination(id, name, Date.valueOf(dateOfVaccination));
        System.out.println(vaccinationController.update(vaccination));
    }

    private void deleteVaccinationInfoByChildId() throws SQLException {
        System.out.println("\nEnter ID to delete information about vaccination");
        int id = INPUT.nextInt();
        System.out.println(vaccinationController.delete(id));
    }

    private void getAllWorkers() throws SQLException {
        System.out.println("\nWorkers:");
        System.out.println(workerController.findAll());
    }

    private void getWorkerById() throws SQLException {
        System.out.println("\nEnter ID for a worker you want to find");
        int id = INPUT.nextInt();
        System.out.println(workerController.findBy(id));
    }

    private void createWorker() throws SQLException {
        System.out.println("\nEnter worker name");
        String name = INPUT.next();
        System.out.println("\nEnter worker surname");
        String surname = INPUT.next();
        System.out.println("\nEnter date of employment (yyyy-mm-dd)");
        String dateOfEmployment = INPUT.next();
        System.out.println("\nEnter TechnicStatus group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter kindergarten ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter worker status");
        String status = INPUT.next();
        Worker worker = new Worker(name, surname, Date.valueOf(dateOfEmployment), childGroupId, childGroupKindergartenId, status);
        System.out.println(workerController.create(worker));
    }

    private void updateWorker() throws SQLException {
        System.out.println("\nEnter ID");
        int id = INPUT.nextInt();
        System.out.println("\nEnter worker name");
        String name = INPUT.next();
        System.out.println("\nEnter worker surname");
        String surname = INPUT.next();
        System.out.println("\nEnter date of employment (yyyy-mm-dd)");
        String dateOfEmployment = INPUT.next();
        System.out.println("\nEnter TechnicStatus group ID");
        int childGroupId = INPUT.nextInt();
        System.out.println("\nEnter kindergarten ID");
        int childGroupKindergartenId = INPUT.nextInt();
        System.out.println("\nEnter worker status");
        String status = INPUT.next();
        Worker worker = new Worker(id, name, surname, Date.valueOf(dateOfEmployment), childGroupId, childGroupKindergartenId, status);
        System.out.println(workerController.update(worker));
    }

    private void deleteWorker() throws SQLException {
        System.out.println("\nEnter ID for worker you want to delete");
        int id = INPUT.nextInt();
        System.out.println(workerController.delete(id));
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    private void outputSubMenu() {
        System.out.println(menu.get("S"));
        System.out.println(menu.get("Q"));
        System.out.println("Please, select menu point.");
    }

    public void show() {
        String keyMenu;
        outputSubMenu();
        do {
            keyMenu = INPUT.next().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            }
            catch (Exception ignored) {
            }
            outputSubMenu();
        } while (!keyMenu.equals("Q"));
    }
}

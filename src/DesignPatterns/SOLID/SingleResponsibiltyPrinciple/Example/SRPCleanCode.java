package DesignPatterns.SOLID.SingleResponsibiltyPrinciple.Example;

class SRPBreadBakery {
    public void bakeBread() {
        System.out.println("Baking bread...");
    }
}
class SRPInventoryManager {
    public void manageInventory() {
        System.out.println("Managing inventory...");
    }
}
class SRPCustomerOrderHandler {
    public void handleCustomerOrders() {
        System.out.println("Handling customer orders...");
    }
}
class SRPDeliveryOrganizer {
    public void organizeDelivery() {
        System.out.println("Organizing delivery...");
    }
}
class SRPCleaner {
    public void cleanBakery() {
        System.out.println("Cleaning the bakery...");
    }
}
class SRPStaffManager {
    public void manageStaff() {
        System.out.println("Managing staff...");
    }
}
public class SRPCleanCode {
    public static void main(String[] args) {
        SRPBreadBakery bakery = new SRPBreadBakery();
        SRPInventoryManager inventoryManager = new SRPInventoryManager();
        SRPCustomerOrderHandler orderHandler = new SRPCustomerOrderHandler();
        SRPDeliveryOrganizer deliveryOrganizer = new SRPDeliveryOrganizer();
        SRPCleaner cleaner = new SRPCleaner();
        SRPStaffManager staffManager = new SRPStaffManager();

        bakery.bakeBread();
        inventoryManager.manageInventory();
        orderHandler.handleCustomerOrders();
        deliveryOrganizer.organizeDelivery();
        cleaner.cleanBakery();
        staffManager.manageStaff();
    }
}
// This code adheres to the Single Responsibility Principle by separating each responsibility into its own class.

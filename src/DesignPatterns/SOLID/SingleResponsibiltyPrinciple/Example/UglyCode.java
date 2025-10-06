package DesignPatterns.SOLID.SingleResponsibiltyPrinciple.Example;
// This class violates the Single Responsibility Principle by having multiple responsibilities.
class BreadBakery {
    public void bakeBread() {
        System.out.println("Baking bread...");
    }
    public void manageInventory() {
        System.out.println("Managing inventory...");
    }
    public void handleCustomerOrders() {
        System.out.println("Handling customer orders...");
    }
    public void organizeDelivery() {
        System.out.println("Organizing delivery...");
    }
    public void cleanBakery() {
        System.out.println("Cleaning the bakery...");
    }
    public void manageStaff() {
        System.out.println("Managing staff...");
    }

    public static void main(String[] args) {
        BreadBakery bakery = new BreadBakery();
        bakery.bakeBread();
        bakery.manageInventory();
        bakery.handleCustomerOrders();
        bakery.organizeDelivery();
        bakery.cleanBakery();
        bakery.manageStaff();
    }
}

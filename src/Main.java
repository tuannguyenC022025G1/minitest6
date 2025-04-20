import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleManager manager = new VehicleManager();

        while (true) {
            System.out.println("\n--- VEHICLE MANAGER ---");
            System.out.println("1. Add vehicle");
            System.out.println("2. Remove vehicle");
            System.out.println("3. Display all vehicles");
            System.out.println("4. Display tax report");
            System.out.println("5. Sort by year");
            System.out.println("6. Sort by brand");
            System.out.println("7. Sort by tax");
            System.out.println("8. View history");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter type (car/motorbike): ");
                    String type = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    if (type.equalsIgnoreCase("car")) {
                        System.out.print("Number of seats: ");
                        int seats = sc.nextInt();
                        manager.addVehicle(new Car(id, brand, year, seats));
                    } else if (type.equalsIgnoreCase("motorbike")) {
                        System.out.print("Engine power: ");
                        int power = sc.nextInt();
                        manager.addVehicle(new Motorbike(id, brand, year, power));
                    } else {
                        System.out.println("Invalid type.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    String id = sc.nextLine();
                    manager.removeVehicle(id);
                }
                case 3 -> manager.displayAllVehicles();
                case 4 -> manager.displayTaxReport();
                case 5 -> manager.sortByYear();
                case 6 -> manager.sortByBrand();
                case 7 -> manager.sortByTax();
                case 8 -> manager.printHistory();
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

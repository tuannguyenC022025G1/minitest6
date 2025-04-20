import java.util.*;

public class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();
    private LinkedList<String> history = new LinkedList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        history.add("Added vehicle: " + v.getId());
    }

    public void removeVehicle(String id) {
        boolean removed = vehicles.removeIf(v -> v.getId().equals(id));
        if (removed) history.add("Removed vehicle: " + id);
        else history.add("Attempted to remove non-existent vehicle: " + id);
    }

    public void displayAllVehicles() {
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
        history.add("Displayed all vehicles");
    }

    public void displayTaxReport() {
        for (Vehicle v : vehicles) {
            System.out.println("ID: " + v.getId() + ", Tax: " + v.calculateTax());
        }
        history.add("Displayed tax report");
    }

    public void sortByYear() {
        Collections.sort(vehicles);
        history.add("Sorted by year");
    }

    public void sortByBrand() {
        vehicles.sort(new BrandComparator());
        history.add("Sorted by brand");
    }

    public void sortByTax() {
        vehicles.sort(new TaxComparator());
        history.add("Sorted by tax");
    }

    public void printHistory() {
        for (String h : history) {
            System.out.println(h);
        }
    }
}

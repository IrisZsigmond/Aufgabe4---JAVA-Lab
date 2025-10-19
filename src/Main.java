import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person markus = new Person("Markus", 60);
        ArrayList<Keyboard> keyboards = new ArrayList<>(List.of(new Keyboard(40), new Keyboard(35), new Keyboard(70), new Keyboard(15), new Keyboard(45)));
        ArrayList<USBDrive> usbDrives = new ArrayList<>(List.of(new USBDrive(20), new USBDrive(15), new USBDrive(40), new USBDrive(15)));
        ElektronikShop shop = new ElektronikShop(keyboards, usbDrives);
        System.out.println("Billigste Tastatur: " + shop.getCheapestKeyboardPrice());
        System.out.println("Teuerster Gegenstand: " + shop.getPriciestItem());
    }

}
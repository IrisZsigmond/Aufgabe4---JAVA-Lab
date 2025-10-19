/*
 Markus will ein USB Laufwerk und eine Tastatur kaufen.
 Der Elektronik-Shop hat verschiedene USB Laufwerke und Tastaturen mit verschiedene Preise.
 Aufgaben:
1. Schreiben Sie eine Methode, welche die billigste Tastatur zurückgibt.
z.B. [40 35 70 15 45] => 15

2. Schreiben Sie eine Methode, welche den teuersten Gegenstand zurückgibt.
z.B. Tastatur = [15 20 10 35], USB = [20, 15, 40 15] => 40

3. Schreiben Sie eine Methode, welche das teuerste USB Laufwerk, das Markus kaufen kann, zurückgibt.
z.B. Preise = [15 45 20], Budget = 30 => 20

4. Finden Sie, anhand Markus’ Budget und der Preislisten für die Tastaturen und USB-Laufwerke, den maximalen Geldbetrag, der von Markus ausgegeben wird.
Wenn er nicht genug für beide hat, geben Sie stattdessen -1 zurück. Er kauft nur die zwei benötigten Gegenstände.
z.B.
b=60, tastaturen = [40 50 60] und USB-Laufwerke = [8 12] => 50 + 8 = 58
b=60, tastaturen = [60] und USB-Laufwerke = [8 12] => -1
b=60, tastaturen = [40 60] und USB-Laufwerke = [8 12] => 40 + 12 = 52
*/

import java.util.ArrayList;

public class ElektronikShop {
    private ArrayList<Keyboard> keyboards;
    private ArrayList<USBDrive> usbDrives;
    public ElektronikShop(ArrayList<Keyboard> keyboards, ArrayList<USBDrive> usbDrives) {
        this.keyboards = keyboards;
        this.usbDrives = usbDrives;
    }

    public int getCheapestKeyboardPrice() {
        int minPrice = Integer.MAX_VALUE;
        for (Keyboard keyboard : keyboards) {
            if (keyboard.getPrice() < minPrice) {
                minPrice = keyboard.getPrice();
            }
        }
        return minPrice;
    }

    public int getPriciestItem() {
        int maxPriceKeyboard = Integer.MIN_VALUE;

        for (Keyboard keyboard : keyboards)
            if (keyboard.getPrice() > maxPriceKeyboard)
                maxPriceKeyboard = keyboard.getPrice();

        int maxPriceUSBDrive = Integer.MIN_VALUE;
        for (USBDrive usbDrive : usbDrives)
            if (usbDrive.getPrice() > maxPriceUSBDrive)
                maxPriceUSBDrive = usbDrive.getPrice();

        if (maxPriceKeyboard > maxPriceUSBDrive)
            return maxPriceKeyboard;

        return maxPriceUSBDrive;
    }

    public int getUSBWithinBudget(int budget) {
        int maxPrice = -1;
        for (USBDrive usbDrive : usbDrives) {
            int price = usbDrive.getPrice();
            if (price <= budget && price > maxPrice)
                maxPrice = price;

        }
        return maxPrice;
    }

    public int getMaxSpendableAmount(int budget) {
        int maxSpendable = -1;
        for (Keyboard keyboard : keyboards) {
            for (USBDrive usbDrive : usbDrives) {
                int totalPrice = keyboard.getPrice() + usbDrive.getPrice();
                if (totalPrice <= budget && totalPrice > maxSpendable)
                    maxSpendable = totalPrice;

            }
        }
        return maxSpendable;
    }
}

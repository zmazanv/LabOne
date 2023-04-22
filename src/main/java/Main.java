import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Product
        System.out.println("What product would you like to purchase?:");
        StringBuilder product = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < product.length(); i++) {
            if (i == 0) {
                product.setCharAt(i, Character.toUpperCase(product.charAt(i)));
            } else {
                product.setCharAt(i, Character.toLowerCase(product.charAt(i)));
            }
        }

        // Quantity
        System.out.println("What is the quantity you would like to purchase?:");
        int quantityOfUnits = scanner.nextInt();

        // Price
        System.out.println("What is the cost per unit?:");
        double pricePerUnit = scanner.nextDouble();

        // Distance in Miles + Shipping Fee
        System.out.println("How many miles are you located from our shipping centre?\n"
                + "(You will be assessed a fee depending on the distance):");
        double distanceInMiles = scanner.nextDouble();
        int shippingFee = 0;
        if (distanceInMiles >= 0 && distanceInMiles < 5) {
            shippingFee = 2;
        } else if (distanceInMiles < 15) {
            shippingFee = 5;
        } else if (distanceInMiles < 25) {
            shippingFee = 10;
        } else if (distanceInMiles < 50) {
            shippingFee = 15;
        } else if (distanceInMiles >= 50) {
            shippingFee = 20;
        }

        // garbageCollection
        scanner.close();

        // Total
        double totalCost = quantityOfUnits * pricePerUnit + shippingFee;

        // Formatted Print Statement
        String response = (
                "Product  |  Quantity  |  Price Per Unit  |  Distance in Miles  |  Total Price"
                + "\n-----------------------------------------------------------------------------\n")
                + product + "\t\t"
                + quantityOfUnits + " Units\t\t"
                + String.format("$%.2f", pricePerUnit) + "\t\t\t\t\t"
                + distanceInMiles + "\t\t\t"
                + String.format("$%.2f", totalCost);

        System.out.println(response);

    }
}
package payment;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CartProcessor {
    public static void main(String[] args) {
        CartProcessor cartProcessor = new CartProcessor();
        cartProcessor.processCart();
    }

    public void processCart() {
        // Read the cart and update quantities in drinks
        Map<String, Integer> cartContents = readCartFile();
        if (cartContents != null) {
            updateDrinkQuantities(cartContents);
            clearCartFile();
        }
    }

    public Map<String, Integer> readCartFile() {
        Map<String, Integer> cartContents = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/cart.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] portions = line.split("\\|");
                if (portions.length >= 4) {
                    String drinkID = portions[0].trim();
                    int quantity = Integer.parseInt(portions[2].trim());

                    cartContents.put(drinkID, cartContents.getOrDefault(drinkID, 0) + quantity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return cartContents;
    }

    public void updateDrinkQuantities(Map<String, Integer> cartContents) {
        try {
            File drinksFile = new File("data/drinks.txt");
            File tempFile = new File("data/drinks_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(drinksFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("|")) {
                    String[] parts = line.split("\\|"); // Split using the pipe character |
                    if (parts.length >= 5) {
                        String drinkID = parts[0].trim();
                        if (cartContents.containsKey(drinkID)) {
                            int currentQuantity = Integer.parseInt(parts[3].trim());
                            int deductedQuantity = cartContents.get(drinkID);
                            parts[3] = String.valueOf(currentQuantity - deductedQuantity);
                        }
                        String updatedLine = String.join("|", parts);
                        writer.write(updatedLine + System.lineSeparator());
                    } else {
                        writer.write(line + System.lineSeparator()); // Write the line as is
                    }
                } else {
                    writer.write(line + System.lineSeparator()); // Write the line as is
                }
            }

            writer.close();
            reader.close();

            // Replace the original file with the updated temp file
            drinksFile.delete();
            tempFile.renameTo(drinksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearCartFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/cart.txt"))) {
            // Simply write an empty string to clear the cart file
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

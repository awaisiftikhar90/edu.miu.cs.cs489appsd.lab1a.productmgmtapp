package Lab1a.Task4.ProductMgmtApp;

import Lab1a.Task4.model.Product;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ProductMgmtApp {

    public static void main(String[] args) {
        // Creating an array of Products with company data
        Product[] products = {
                new Product(3128874119L, "Banana", new Date(2023 - 1900, 0, 24), 124, 0.55),
                new Product(2927458265L, "Apple", new Date(2022 - 1900, 11, 9), 18, 1.09),
                new Product(9189927460L, "Carrot", new Date(2023 - 1900, 2, 31), 89, 2.99)
                // Add more products as needed
        };
        // Sorting products by name in ascending order
        Arrays.sort(products, Comparator.comparing(Product::getName));

        // Print products in different formats
        printProducts(products, Format.JSON);
        printProducts(products, Format.XML);
        printProducts(products, Format.CSV);
    }

    private static void printProducts(Product[] products, Format format) {
        switch (format) {
            case JSON:
                printJSON(products);
                break;
            case XML:
                printXML(products);
                break;
            case CSV:
                printCSV(products);
                break;
            default:
                System.out.println("Unsupported format");
        }
    }
    private static void printJSON(Product[] products) {
        JSONObject json = new JSONObject(str);
        String xml = XML.toString(json);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
            System.out.println("JSON Format:");
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printXML(Product[] products) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
            System.out.println("XML Format:");
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printCSV(Product[] products) {
        System.out.println("CSV Format:");
        System.out.println("productId,name,dateSupplied,quantityInStock,unitPrice");
        for (Product product : products) {
            System.out.println(product.getProductId() + "," +
                    product.getName() + "," +
                    new SimpleDateFormat("yyyy-MM-dd").format(product.getDateSupplied()) + "," +
                    product.getQuantityInStock() + "," +
                    product.getUnitPrice());
        }
    }
    // Enum to represent different output formats
    private enum Format {
        JSON,
        XML,
        CSV
    }

}

//some issues
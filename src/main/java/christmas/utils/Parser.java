package christmas.utils;

import christmas.domain.validator.ParseValidator;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Integer> parse(String menuInput) {
        String[] parts = menuInput.split(",");
        ParseValidator.commaValid(parts);
        return generateMenusValues(parts);
    }

    private static Map<String, Integer> generateMenusValues(final String[] parts) {
        Map<String, Integer> menuValues = new HashMap<>();
        for (String part : parts) {
            part = part.trim();
            processPart(part, menuValues);
        }
        return menuValues;
    }
    private static void processPart(String part, Map<String, Integer> menuValues) {
        String[] itemParts = part.split("-");
        ParseValidator.typeValid(itemParts);

        String name = itemParts[0].trim();
        int quantity = Integer.parseInt(itemParts[1].trim());

        menuValues.put(name, menuValues.getOrDefault(name, 0) + quantity);
    }
}

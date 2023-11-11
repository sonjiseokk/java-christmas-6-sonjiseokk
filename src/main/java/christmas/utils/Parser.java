package christmas.utils;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Integer> parse(String menuInput) {
        String[] parts = menuInput.split(",");
        return generateMenus(parts);
    }

    private static Map<String, Integer> generateMenus(final String[] parts) {
        Map<String, Integer> menus = new HashMap<>();
        for (String part : parts) {
            processPart(part, menus);
        }
        return menus;
    }
    private static void processPart(String part, Map<String, Integer> menus) {
        String[] itemParts = part.split("-");
        String name = itemParts[0];
        int quantity = Integer.parseInt(itemParts[1]);

        menus.put(name, menus.getOrDefault(name, 0) + quantity);
    }
}

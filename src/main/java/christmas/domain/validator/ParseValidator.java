package christmas.domain.validator;

public class ParseValidator {
    public static void separatorValid(final String[] itemParts) throws IllegalArgumentException {
        if (isEmpty(itemParts)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        for (String part : itemParts) {
            if (part.trim().isEmpty()) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            if (isValidHyphen(part)) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void typeValid(final String[] itemParts) throws IllegalArgumentException{
        if (isNotNum(itemParts[1])) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    private static boolean isEmpty(final String[] itemParts) {
        return itemParts.length == 0;
    }

    private static boolean isNotNum(String number) {
        String regex = "^[0-9]+$";
        return !number.matches(regex);
    }

    private static boolean isValidHyphen(final String part) {
        return !part.contains("-") || part.endsWith("-") || part.startsWith("-") || part.contains("--");
    }
}

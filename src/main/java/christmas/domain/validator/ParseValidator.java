package christmas.domain.validator;

public class ParseValidator {
    public static void typeValid(final String[] itemParts) {
        if (isNotNum(itemParts[1])) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        if (isSatisfyOne(itemParts[1])) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    public static void commaValid(final String[] itemParts) {
        if (isEmpty(itemParts)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isSatisfyOne(final String itemPart) {
        return Integer.parseInt(itemPart) <= 0;
    }

    private static boolean isEmpty(final String[] itemParts) {
        return itemParts.length == 0;
    }

    private static boolean isNotNum(String number) {
        String regex = "^[0-9]+$";
        return !number.matches(regex);
    }
}

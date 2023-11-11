package christmas.domain.validator;

public class ParseValidator {
    public static void valid(final String[] itemParts) {
        if (isNotNum(itemParts[1])) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
    private static boolean isNotNum(String number) {
        String regex = "^[0-9]+$";
        return !number.matches(regex);
    }
}

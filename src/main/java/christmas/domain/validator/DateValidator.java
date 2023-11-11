package christmas.domain.validator;


import static christmas.constant.DateRange.MONTH;

public class DateValidator {
    public static void valid(String date) throws IllegalArgumentException {
        if (isNum(date)) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        if (inRange(Integer.parseInt(date))) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
    private static boolean isNum(String number) {
        String regex = "^[0-9]+$";
        return !number.matches(regex);
    }
    private static boolean inRange(int date) {
        return date < MONTH.getStart() || date > MONTH.getEnd();
    }

}

package christmas.domain.validator;


import static christmas.constant.DateRange.MONTH;

public class DateValidator {
    public static void valid(String date) throws IllegalArgumentException {
        if (isNum(date)) {
            throw new IllegalArgumentException("숫자로만 입력해주세요.");
        }
        if (inRange(Integer.parseInt(date))) {
            throw new IllegalArgumentException("알맞은 날짜 형식을 입력해주세요. " +
                    "입력 가능한 일은 " + MONTH.getStart() + "~" + MONTH.getEnd() +
                    "일 사이입니다.");
        }
    }
    public static boolean isNum(String number) {
        String regex = "^[0-9]+$";
        return !number.matches(regex);
    }
    private static boolean inRange(int date) {
        return date < MONTH.getStart() || date > MONTH.getEnd();
    }

}

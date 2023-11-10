package christmas.view.validator;


import static christmas.view.validator.DayRange.MONTH;

public class DateValidator {
    public static void valid(int day) throws IllegalArgumentException {
        if (isNum(String.valueOf(day))) {
            throw new IllegalArgumentException("숫자로만 입력해주세요.");
        }
        if (inRange(day)) {
            throw new IllegalArgumentException("알맞은 날짜 형식을 입력해주세요. " +
                    "입력 가능한 일은 " + MONTH.getStart() + "~" + MONTH.getEnd() +
                    "일 사이입니다.");
        }
    }

    private static boolean inRange(int day) {
        return day < MONTH.getStart() || day > MONTH.getEnd();
    }

    private static boolean isNum(String number) {
        String regex = "^[0-9]+$";
        return !number.matches(regex);
    }
}

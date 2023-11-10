package christmas.domain;

import java.util.regex.Pattern;

public class Customer {
    private static final String VISIT_DATE_BLANK_EXCEPTION_MESSAGE = "[ERROR] 공백 없이 입력해야 합니다. 다시 입력해 주세요.";
    private static final String VISIT_DATE_RANGE_EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String VISIT_DATE_TYPE_EXCEPTION_MESSAGE = "[ERROR] 자연수를 입력해야 합니다. 다시 입력해 주세요.";
    private static final Pattern NUMBER_MATCH = Pattern.compile("^[0-9]*$");
    private static final int DATE_START_NUMBER = 1;
    private static final int DATE_END_NUMBER = 31;
    private final int visitDate;

    public Customer(String visitDate) {
        validateVisitDate(visitDate);
        this.visitDate = toInt(visitDate);
    }

    private void validateVisitDate(String inputDate) {
        validateVisitDateBlank(inputDate);
        validateVisitDateType(inputDate);
        validateVisitDateRange(toInt(inputDate));
    }

    private void validateVisitDateBlank(String inputDate) {
        if (inputDate.contains(" ") || inputDate.equals(""))
            throw new IllegalArgumentException(VISIT_DATE_BLANK_EXCEPTION_MESSAGE);
    }

    private void validateVisitDateType(String inputDate) {
        if (!NUMBER_MATCH.matcher(inputDate).matches())
            throw new IllegalArgumentException(VISIT_DATE_TYPE_EXCEPTION_MESSAGE);
    }

    private void validateVisitDateRange(int inputDate) {
        if (!(inputDate >= DATE_START_NUMBER && inputDate <= DATE_END_NUMBER))
            throw new IllegalArgumentException(VISIT_DATE_RANGE_EXCEPTION_MESSAGE);
    }

    private int toInt(String inputDate) {
        return Integer.parseInt(inputDate);
    }

    public int getVisitDate() {
        return visitDate;
    }
}

package kalkulator;

/**
 * 
 * @author Kuba
 */
public class Calculator {

    /**
     * 
     * @param text value to count
     * @return answer of calculations
     */
    public String count(String text) {
        boolean correctString = true;
        for (int i = 0; i < text.length(); i++) {
            if (!isProperChar(text.charAt(i))) {
                correctString = false;
                break;
            }
        }
        if (correctString) {
            return answer(text);
        } else {
            return "Błędna składnia znaków.";
        }
    }

    private boolean isProperChar(char charAt) {
        return (Character.isDigit(charAt) || charAt == '='
                || charAt == '+' || charAt == '-' || charAt == '*' || charAt == '/');
    }

    private String answer(String text) {
        double answer = 0;
        double value1;
        char chaar;
        StringBuilder numberValue = new StringBuilder();
        char lastType = '+';
        for (int i = 0; i < text.length(); i++) {
            chaar = text.charAt(i);
            if (Character.isDigit(chaar) || ((i == 0) && (chaar == '+' || chaar == '-'))) {
                numberValue.append(chaar);
            } else if ((i == 0) && (chaar == '=' || chaar == '*' || chaar == '/')) {
                break;
            } else {
                value1 = Double.parseDouble(numberValue.toString());
                numberValue.setLength(0);
                switch (lastType) {
                    case '+': {
                        answer += value1;
                    }
                    break;
                    case '-': {
                        answer -= value1;
                    }
                    break;
                    case '*': {
                        answer *= value1;
                    }
                    break;
                    case '/': {
                        answer /= value1;
                    }
                    break;
                }
                lastType = chaar;
                if (lastType == '=') {
                    return String.valueOf(answer);
                }
            }
        }
        return "Błędna składnia znaków.";
    }

}

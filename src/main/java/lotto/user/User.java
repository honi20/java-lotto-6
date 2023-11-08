package lotto.user;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private static final PartialFunction PARTIAL_FUNCTION = new PartialFunction();

    public int purchaseLotto() {
        try {
            String purchaseMoney = input("구입금액을 입력해 주세요.");
            return PARTIAL_FUNCTION.getMoneyNumber(purchaseMoney);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            System.out.println();
            return purchaseLotto();
        }
    }

    public List<Integer> getWinningNumbersAndBonus() {
        List<Integer> winningNumbers = inputAndGetWinningNumbers();
        int bonusNumber = inputAndGetBonusNumber(winningNumbers);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    public List<Integer> inputAndGetWinningNumbers() {
        try {
            String winningLotto = input("\n당첨 번호를 입력해 주세요.");
            return PARTIAL_FUNCTION.getWinningNumbers(winningLotto);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return inputAndGetWinningNumbers();
        }
    }

    public int inputAndGetBonusNumber(List<Integer> winningNumbers) {
        try {
            String bonusLotto = input("\n보너스 번호를 입력해 주세요.");
            return PARTIAL_FUNCTION.getBonusNumber(bonusLotto, winningNumbers);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return inputAndGetBonusNumber(winningNumbers);
        }
    }

    private static String input(String printMessage) {
        System.out.println(printMessage);
        return Console.readLine();
    }

    private static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}

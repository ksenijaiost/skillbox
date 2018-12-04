public class FirstDayTaskOne {
    public static void main(String[] args) {

        int moneyAmount = 114;
        System.out.println("Кофемашина. У Вас на счету "+ moneyAmount);

        String drinks[] = {"Чай", "Эспрессо", "Американо", "Капучино", "Латте", "Раф", "Какао"};
        int prices[] = {100, 80, 80, 120, 125, 140, 110};

        int minPrice = prices[0];
        for (int i : prices) {if (i<minPrice) minPrice = i;}

        if (moneyAmount<minPrice) System.out.println("У Вас недостаточно средств для покупки напитка");
        else {
            System.out.println("Вы можете купить:");
            for (int i=0; i<drinks.length; i++) {
                if (moneyAmount >= prices[i]) System.out.println("      " + drinks[i] + " по цене " + prices[i]);
            }
        }
    }
}

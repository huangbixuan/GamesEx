package pokeGames;

/**
 * @Description TODO
 * @Author zuiai
 * @Date 2019/11/14 15:03
 **/

public class Dao {
    //将牌号转换成字符型数字
    public static int compareOnePokerNumber(String number){
        switch (number){
            case "A": return 1;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            default:return Integer.parseInt(number);
        }
    }
    //将花色转换成字符型数字
    public static String compareOnePokerColor(String color){
        switch (color){
            case "♠": return "4";
            case "♥": return "3";
            case "♣": return "2";
            case "♦": return "1";
            default:return "";
        }
    }
}

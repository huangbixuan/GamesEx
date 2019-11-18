package pokeGames;


import static pokeGames.Dao.compareOnePokerColor;
import static pokeGames.Dao.compareOnePokerNumber;

/**
 * @Description TODO
 * @Author zuiai
 * @Date 2019/11/13 10:44
 **/

public class Card implements Comparable<Card> {
    private String number;
    private String color;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Card [number=" + number + ", color=" + color + "]";
    }


    @Override
    public int compareTo(Card o) {
        int flag = -1;
        if (compareOnePokerNumber(this.getNumber()) <(compareOnePokerNumber(o.getNumber()))){
             flag = 1;
        }else if (compareOnePokerNumber(this.getNumber())==(compareOnePokerNumber(o.getNumber()))){
            if (compareOnePokerColor(this.getColor()).compareTo(compareOnePokerColor(o.getColor())) < 0){
                 flag = 1;
            }
        }
        return flag;
    }
}

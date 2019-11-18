package pokeGames;

import java.util.ArrayList;
import java.util.List;

import static pokeGames.Dao.compareOnePokerColor;
import static pokeGames.Dao.compareOnePokerNumber;


/**
 * @Description TODO
 * @Author zuiai
 * @Date 2019/11/13 10:43
 **/

public class Player implements Comparable<Player> {
    private int id;//
    private String name;
    public List<Card> cs = new ArrayList<Card>();
    public int Points = 0;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCs() {
        return cs;
    }

    public void setCs(List<Card> cs) {
        this.cs = cs;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cs=" + cs +
                ", Points=" + Points +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        int flag = -1;
        if (this.Points < o.Points){
            flag =1;
        }else if (this.Points == o.Points){
            if (compareOnePokerNumber(this.getCs().get(0).getNumber()) < compareOnePokerNumber(o.getCs().get(0).getNumber())) {
                flag =1;
            }else if (compareOnePokerNumber(this.getCs().get(0).getNumber()) == compareOnePokerNumber(o.getCs().get(0).getNumber())){
                if (compareOnePokerColor(this.getCs().get(0).getColor()).compareTo(compareOnePokerColor(o.getCs().get(0).getColor())) <0){
                    flag =1;
                }
            }
        }
        return flag;
    }
}

package pokeGames;


import java.util.*;

import static pokeGames.Dao.compareOnePokerNumber;

/**
 * @Description TODO
 * @Author zuiai
 * @Date 2019/11/13 10:44
 **/

public class Game {

    //定义卡牌
    public static String colors[] = { "♠", "♥", "♣", "♦" };
    public static String numbers[] = { "A", "2", "3", "4", "5", "6", "7", "8",
            "9", "10", "J", "Q", "K" };
    static List<Player> playerList = new ArrayList<Player>();

    public List<Card> getCardsList() {
        List<Card> cList = new ArrayList<>();
        for (String co : colors) {
            for (String nu : numbers) {
                Card card = new Card();
                card.setColor(co);
                card.setNumber(nu);
                cList.add(card);
            }
        }
        return cList;
    }

//    创建玩家
    public static void createPlayer(int playersNum,Scanner scanner) {
        System.out.println("---------创建玩家----------");

        for(int i=0; i<playersNum; i++) {
            System.out.println("请输入第"+(i+1)+"位玩家信息:");
                try {
                    Player player = new Player();
                    System.out.println("请输入玩家id:");
                    int idScanner = scanner.nextInt();
                    player.setId(idScanner);
                    isRepeatId(playerList,idScanner);
                    System.out.println("请输入玩家姓名:");
                    player.setName(scanner.next());
                    playerList.add(player);
                }catch (InputMismatchException e) {
                    System.out.println("请输入整数类型的id");
                    i--;
                } catch (idRepeatException e) {
                    System.err.println(e);
                    i--;
                }
        }

        for(Player play:playerList) {
            System.out.println("欢迎玩家："+play.getName());
        }
    }
    //判断id是否重复
    public static boolean isRepeatId(List<Player> players,int id) throws idRepeatException {
        boolean b = true;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id){
                b = false;
                throw new idRepeatException("玩家id已存在");
            }
        }
        return b;
    }
    //洗牌 Collections.shuffle
    public static List<Card> Shuffle(){
        List<Card> cards = new Game().getCardsList();
        Collections.shuffle(cards);
        return cards;
    }
    //发牌 Random
    public static void Licensing(){
        int pokerNum = 2;
        int pokerStart = 0;
        //打印打乱后的扑克牌
        System.out.println("打乱后的牌序：");
        List<Card> Licensing = Shuffle();
        System.out.println(Licensing);
        for (int i = 0; i < pokerNum; i++) {
            for (int j = 0; j < playerList.size(); j++) {
                playerList.get(j).cs.add(Licensing.get(pokerStart++));
                playerList.get(j).Points+=compareOnePokerNumber(playerList.get(j).cs.get(i).getNumber());
            }
        }
    }
    //打印赢家
    public static void printWin(List<Player> players){
        System.out.println( "本局赢家是："+players.get(0).getName());
        System.out.println( "他的手牌是："+players.get(0).getCs().get(0).getColor()+players.get(0).getCs().get(0).getNumber()+","
                +players.get(0).getCs().get(1).getColor()+players.get(0).getCs().get(1).getNumber());
    }
    //交换排序，从大到小排序
    public static void sortCard(List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            //对于玩家的手牌排序
            Collections.sort(players.get(i).getCs());
            //对于玩家排序
            Collections.sort(players);
        }
    }
    public static void main(String[] args) {
        //创建玩家
        System.out.println("游戏开始");
        System.out.println("请输入有几位玩家：");
        Scanner scanner = new Scanner(System.in);
        while (true){
            int playerNum = scanner.nextInt();
            if (playerNum >= 2 && playerNum <=26){
                createPlayer(playerNum,scanner);
        //打散发牌
                Licensing();
        //排序扑克牌从小到大,玩家排序
                sortCard(playerList);
                for (Player p  :playerList
                ) {
                    System.out.println("玩家："+p.getName()+"的手牌为--");
                    for (int i = 0; i < 2; i++) {
                        System.out.print(p.getCs().get(i).getColor()+p.getCs().get(i).getNumber());
                    }
                    System.out.println();
//                    System.out.println(p);
                }
                printWin(playerList);
                return;
            }else {
                System.out.println("请输入2到26位玩家");
            }
        }
    }
}

package models.test;

import factories.PlayerFactory;
import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private Game game;

    @Before
    public void setUp(){
        this.game = createGame();
    }

    private Game createGame() {
//        Game game = new Game();
//        Board board = new Board(3,3);
//        game.setBoard(board);
//
//        HumanPlayer human = new HumanPlayer();
//        human.setSymbol(GameSymbol.O);
////        human.setUser(new User());
//        human.setUser(User.builder().email("abc@xyz.com").name("abc").build());
//
//        Bot bot = new Bot();
//        bot.setSymbol(GameSymbol.X);
//
//        game.setPlayers(Arrays.asList(human, bot));

//        After

//        HumanPlayer human = new HumanPlayer();
//        human.setSymbol(GameSymbol.O);
//        human.setUser(User.builder().email("abc@xyz.com").name("abc").build());
//
//        Bot bot = new Bot();
//        bot.setSymbol(GameSymbol.X);
//
//        Game game = Game.getBuilder()
//                .withDimensions(3, 3)
//                .withPlayers(human)
//                .withPlayers(bot)
//                .build();

//        HumanPlayer human = new HumanPlayer();
//        human.setSymbol(GameSymbol.O);
//        human.setUser(User.builder().email("abc@xyz.com").name("abc").build());
//
//        Bot bot = new Bot();
//        bot.setSymbol(GameSymbol.X);

//        Game game = Game.getBuilder()
//                .withDimensions(3, 3)
//                .withPlayers(
//                        HumanPlayer.builder()
//                                .symbol(GameSymbol.O)
//                                .user(
//                                        User.builder()
//                                                .name("abc")
//                                                .email("abc@xyz.com")
//                                                .build())
//                                .build())
//                .withPlayers(
//                        Bot.builder()
//                                .symbol(GameSymbol.X)
//                                .build())
//                .build();

        Game game = Game.getBuilder()
                .withDimensions(3, 3)
                .withPlayers(
                        HumanPlayer.builder()
                                .symbol(GameSymbol.O)
                                .user(
                                        User.builder()
                                                .name("abc")
                                                .email("abc@xyz.com")
                                                .build())
                                .build())
                .withPlayers(
                        PlayerFactory.getBotPlayer()
                                .symbol(GameSymbol.X)
                                .build())
                .build();
        return game;
    }

    @Test
    public void testDimension(){
        List<List<BoardCell>> cells = game.getBoard().getCells();
        assertEquals("If board is created, number of row should be equal to input", 3, cells.size());

        List<BoardCell> firstRow = cells.get(0);
        assertEquals("If board is created, number of column should be", 3, firstRow.size());
    }
}

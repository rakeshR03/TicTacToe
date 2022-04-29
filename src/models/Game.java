package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();

    //After

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private Game game;
        Builder(){
            this.game = new Game();
        }
        public Builder withDimensions(int row, int col){
            Board board = new Board(row, col);
            this.game.setBoard(board);
            return this;
        }

        public Builder withPlayers(Player player){
            game.getPlayers().add(player);
            return this;
        }

        private boolean validate(){
            List<Player> players = game.getPlayers();
            if(players.size() == 2){
                return true;
            }
            else{
                return false;
            }
        }

        public Game build(){
            boolean isValid = validate();
            if(!isValid){
                throw new RuntimeException("invalid build condition");
            }
            return this.game;
        }
    }
}

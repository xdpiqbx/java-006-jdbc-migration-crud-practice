package cw.train.cli;

import cw.train.storage.ConnectionProvider;
import cw.train.ticket.TicketDAOService;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public class CliFSM {
    private CliState state;
    @Getter
    private Scanner scanner;
    @Getter
    private ConnectionProvider connectionProvider;

    public CliFSM(ConnectionProvider connectionProvider){
        this.connectionProvider = connectionProvider;
        state = new IdleState(this);
        scanner = new Scanner(System.in);
        while (true){
            String command = scanner.nextLine();
            switch(command){
                case "e":
                    System.exit(0);
                break;
                case "addt": // addTicket
                    newTickedRequested();
                break;
                case "ps": // planetStats
                    planetStatsRequested();
                break;
                default:
                    unknownCommand(command);
                break;
            }
        }
    }

    public void newTickedRequested(){
        state.newTickedRequested();
    }

    public void ticketOrdered(){
        state.ticketOrdered();
    }

    public void planetStatsRequested(){
        state.planetStatsRequested();
    }

    public void planetStatsPrinted(){
        state.planetStatsPrinted();
    }

    public void unknownCommand(String cmd){
        state.unknownCommand(cmd);
    }

    public void setState(CliState state){
        this.state = state;
        state.init();
    }
}

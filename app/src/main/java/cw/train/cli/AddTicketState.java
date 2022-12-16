package cw.train.cli;

public class AddTicketState extends CliState{
    public AddTicketState(CliFSM fsm) {
        super(fsm);
    }

    @Override
    public void init() {
        System.out.print("Enter passenger passport: ");
    }
}

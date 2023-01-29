package commands;

public interface ICommand {
    boolean matches(String command);
    void execute(String command);
}

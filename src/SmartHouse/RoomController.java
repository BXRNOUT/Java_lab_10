package SmartHouse;

import SmartHouse.Commands.ClassCommand;
import SmartHouse.Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class RoomController
{
     List <Command> commands = new ArrayList<>();

    public void addCommand(Command command)
    {
        boolean inList = false;
        if(commands != null)
            for (Command i : commands)
                if(i == command)
                {
                    inList = true;
                    break;
                }
        if(!inList)
            commands.add(command);
    }
    public void pressButton()
    {
        if(commands != null)
        {
            for (Command command : commands)
                command.execute();
            commands.clear();
        }

    }
}

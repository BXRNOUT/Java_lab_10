package SmartHouse.Commands;

import SmartHouse.Room;

public class ClassCommand implements Command
{
    protected Room room;

    public ClassCommand(Room room) {this.room = room;}
    public void execute() {}
}

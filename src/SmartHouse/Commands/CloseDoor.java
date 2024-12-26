package SmartHouse.Commands;

import SmartHouse.Room;

public class CloseDoor extends ClassCommand implements Command
{
    public CloseDoor(Room room) {super(room);}
    public void execute() {super.room.closeDoor();}
}

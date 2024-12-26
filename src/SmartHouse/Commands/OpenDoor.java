package SmartHouse.Commands;


import SmartHouse.Room;

public class OpenDoor extends ClassCommand
{
    public OpenDoor(Room room) {super(room);}
    @Override
    public void execute() {super.room.openDoor();}
}

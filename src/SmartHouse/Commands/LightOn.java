package SmartHouse.Commands;

import SmartHouse.Room;

public class LightOn extends ClassCommand
{
    public LightOn(Room room) {super(room);}
    @Override
    public void execute() {super.room.lightOn();}
}

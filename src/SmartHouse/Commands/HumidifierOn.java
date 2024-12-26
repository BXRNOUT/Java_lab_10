package SmartHouse.Commands;


import SmartHouse.Room;

public class HumidifierOn extends ClassCommand
{
    public HumidifierOn(Room room) {super(room);}
    @Override
    public void execute() {super.room.humidifierOn();}
}

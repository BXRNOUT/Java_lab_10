package SmartHouse.Commands;

import SmartHouse.Room;

public class SetTemperature extends ClassCommand
{
    private int temperature;
    public SetTemperature(Room room, int temperature)
    {
        super(room);
        this.temperature = temperature < 18 ? 18 : Math.min(26, temperature);
    }
    @Override
    public void execute() {super.room.setTemperature(temperature);}
}

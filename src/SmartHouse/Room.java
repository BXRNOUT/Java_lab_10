package SmartHouse;
import SmartHouse.InterfacesRooms.*;

public class Room implements Street, Bathroom, Kitchen, Bedroom, WaitingRoom, Hall
{
    private boolean isLight = false;
    private boolean isDoorOpen = true;
    private boolean isKitchenHood = false;
    private boolean isTV = false;
    private boolean isMusic = false;
    private boolean isHumidifier = false;
    private int temperature = 19;

    public void lightOn() {isLight = true;}
    public void lightOff() {isLight = false;}
    public boolean getLightStatus() {return isLight;}
    public void openDoor() {isDoorOpen = true;}
    public void closeDoor() {isDoorOpen = false;}
    public boolean getDoorStatus() {return isDoorOpen;}
    public void kitchenHoodOn() {isKitchenHood = true;}
    public void kitchenHoodOff() {isKitchenHood = false;}
    public boolean getKitchenHoodStatus() {return isKitchenHood;}
    public void tvOn() {isTV = true;}
    public void tvOff() {isTV = false;}
    public boolean getTVStatus() {return isTV;}
    public void musicOn() {isMusic = true;}
    public void musicOff() {isMusic = false;}
    public boolean getMusicStatus() {return isMusic;}
    public void humidifierOn() {isHumidifier = true;}
    public void humidifierOff() {isHumidifier = false;}
    public boolean getHumidifierStatus() {return isHumidifier;}
    public void setTemperature(int temperature){this.temperature = temperature;}
    public double getTemperature() {return temperature;}
}

import java.awt.List;
import java.util.ArrayList;

public class Computer
{
    // Could make it really fancy, but I'm not going to.
    private String cpu;

    // The amount of RAM the computer has in GB.
    private int ramAmount;

    // A list of all the peripherals a computer has.
    protected ArrayList<Peripheral> peripherals = new ArrayList<Peripheral>();

    public Computer ( int ramInGB, String cpu )
    {
        this.cpu = cpu;
        this.ramAmount = ramInGB;
    }

    public Computer ( int ramInGB, String cpu,  Peripheral[] peripherals)
    {
        this.cpu = cpu;
        this.ramAmount = ramInGB;
        for (int i = 0; i < peripherals.length; i++)
        {
            addPeripheral(peripherals[i]);
        }
    }

    public void addPeripheral (Peripheral peripheral)
    {
        peripherals.add(peripheral);
    }
    
    public void addPeripherals (Peripheral[] peripherals)
    {
        for (int i = 0; i < peripherals.length; i++)
        {
            addPeripheral(peripherals[i]);
        }
    }

    public Peripheral[] getPeripherals ()
    {
        return peripherals.toArray(new Peripheral[peripherals.size()]);
    }

    public void changeRAM(int ramInGB)
    {
        this.ramAmount = ramInGB;
    }

    public String getCPU()
    {
        return cpu;
    }
    
    public int getRAM()
    {
        return ramAmount;
    }
}
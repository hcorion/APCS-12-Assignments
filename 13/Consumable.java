public class Consumable
{
    private String name;
    private boolean organic;

    public Consumable(String name)
    {
        this.name = name;
    }

    public Consumable(String name, boolean organic)
    {
        this.name = name;
        this.organic = organic;
    }

    public String toString()
    {
        if (organic)
            return "organic " + name;
        else
            return name;
    }

    public String getName()
    {
        return name;
    }

    public boolean isOrganic()
    {
        return organic;
    }

    public boolean equals (Object obj)
    {
        if (obj.getClass() == this.getClass())
        {
            Consumable item = (Consumable)obj;
            if (item.getName() == this.name && item.isOrganic() == this.organic)
            {
                return true;
            }
        }
        return false;
    }
}
// I'm going to be lazy here and not create a Person class because it's not needed.
public class Employee
{
    private String name;
    
    public Employee(String name)
    {
        this.name = name;
    }
    public Employee()
    {
        this.name = "John Adams";
    }

    public String toString()
    {
        return "Employee " + name;
    }

    public String getName()
    {
        return name;
    }
}
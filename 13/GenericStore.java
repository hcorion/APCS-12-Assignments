import java.util.ArrayList;

public abstract class GenericStore<E> implements Store<E>
{
    // These are protected so that I can access them in the subclass.
    protected int checkouts = 0;
    protected ArrayList<Employee> employees;
    protected boolean isOpen;
    protected ArrayList<E> goods;
    public GenericStore()
    {
        System.out.println("Setting up a generic store!");
        isOpen = true;
        employees = new ArrayList<Employee>();
        goods = new ArrayList<E>();
    }

    public E buy(E item)
    {
        if (isOpen)
        {
            if (employees.size() >= 1)
            {
                int index = goods.indexOf(item);
                System.out.println(index);
                if (index >= 0)
                {
                    System.out.println("Alright! Buying a " + item + "!");

                    E boughtItem = goods.get(index);
                    goods.remove(item);
                    return boughtItem;
                }
                else
                {
                    System.out.println("Woops, we don't have " + item + " in stock!");
                }
            }
            else
            {
                System.out.println("Woops! It looks like there are no employees at the store! You can't buy anything!");
            }
        }
        else
        {
            System.out.println("You can't buy things while the store is closed.");
        }
        return null;
    }

    public void closeStore()
    {
        isOpen = false;
    }

    public void addEmployee(Employee employee)
    {
        this.employees.add(employee);
    }

    public ArrayList<E> getGoods()
    {
        return goods;
    }

    public void stock(ArrayList<E> goods )
    {
        for (E item: goods)
        {
            this.goods.add(item);
        }
    }

    public void removeEmployee(Employee employee)
    {
        int index = employees.indexOf(employee);
        if (index >= 0 )
        {
            System.out.println("Yep, we have that employee.");
            this.employees.remove(index);
        }
        else
        {
            System.out.println("Woops, " + employee.getName() + " doesn't work here!");
        }
    }
    public String listEmployees()
    {
        return "";
    }

    public int GetCheckouts()
    {
        return checkouts;
    }

    public void CloseStore()
    {
        isOpen = false;
    }
}
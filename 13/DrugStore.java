import java.util.ArrayList;
import java.util.Arrays;

public class DrugStore<E> extends GenericStore<E>
{
    public DrugStore()
    {
        super();
        checkouts = 1;
    }

    // Doesn't actually do anything.
    public Object getPrescription()
    {
        System.out.println("You now have a prescription!");
    }
}
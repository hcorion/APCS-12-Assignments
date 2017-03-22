import java.util.ArrayList;
import java.util.Arrays;

public class CornerStore<E> extends GenericStore<E>
{
    public CornerStore()
    {
        super();
        checkouts = 1;
    }

    // Doesn't actually do anything.
    public fillGas(Object car)
    {
        System.out.println("Your car is now full of gas!");
    }
}
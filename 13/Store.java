import java.util.ArrayList;

public abstract interface Store<E>
{
    E buy(E item);
    void addEmployee(Employee employee);
    void removeEmployee(Employee employee);

    String listEmployees();

    int GetCheckouts();

    void CloseStore();

    ArrayList<E> getGoods();

    void stock(ArrayList<E> goods);
}
public class AllInOne extends Computer
{
    private Screen screen;
    public AllInOne(int screenWidth, int screenHeight, int amountOfRAMInGB, String cpu)
    {
        super(amountOfRAMInGB, cpu);
        screen = new Screen(screenWidth, screenHeight);
    }
}
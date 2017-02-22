public class Peripheral
{
    public enum connectorType {
        USB1, USB2, USB3, Jack, Thunderbolt
    }
    private connectorType connector;

    protected void setConnector(connectorType connector)
    {
        this.connector = connector;
    }

    public String getConnector()
    {
        return connector.toString();
    }

    public String getName()
    {
        return this.getClass().getName();
    }
}
package cs2410.assn7.logic;


public enum Difficulty
{
    EASY(10, 800),
    NORMAL(20, 500),
    HARD(30, 300);

    private int stackLength;
    private long sleepTime;

    Difficulty(int stackLength, long sleepTime)
    {
        this.stackLength = stackLength;
        this.sleepTime = sleepTime;
    }

    public int getStackLength()
    {
        return stackLength;
    }

    public long getSleepTime()
    {
        return sleepTime;
    }
}

public class Printer {

    private int tonerLevel;
    private int numberOfPagesPrinted;
    private boolean isDuplexPrinter;

    public Printer(int tonerLevel, boolean isDuplexPrinter) {
        if (tonerLevel > -1 && tonerLevel <= 100)
        {
            this.tonerLevel = tonerLevel;
        }
        else
        {
            this.tonerLevel = -1;
        }
        this.isDuplexPrinter = isDuplexPrinter;
        this.numberOfPagesPrinted = 0;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public int fillToner(int tonerAmount)
    {
        if (tonerAmount > 0 && tonerAmount <= 100)
        {
            if (this.tonerLevel + tonerAmount > 100)
            {
                return -1;
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        }
        else
        {
            return -1;
        }
    }

    public int printPage(int pages)
    {
        int pagesToPrint = pages;
        if (this.isDuplexPrinter)
        {
            pagesToPrint = (pages / 2) + (pages % 2);
            System.out.println("Printing in Duplex mode");

        }
        this.numberOfPagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

}

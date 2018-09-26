import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StockTest {

    StockPortfolio stockPortfolio;
    StockService stockService;

    public static void main(String[] args) {


        new StockTest().setUp();
    }

    private void setUp() {
        Stock miami = new Stock();
        miami.setName("miami");
        miami.setPrice(40);
        miami.setQuantity(5);

        Stock payPal = new Stock();
        payPal.setQuantity(5);
        payPal.setPrice(80);
        payPal.setName("payPal");

        stockPortfolio = new StockPortfolio();
        stockPortfolio.addStock(payPal);
        stockPortfolio.addStock(miami);
        stockService = mock(StockService.class);
        stockPortfolio.setStockService(stockService);

        when(stockService.getPrice(miami)).thenReturn(200.0);
        when(stockService.getPrice(payPal)).thenReturn(400.0);

        System.out.println(stockPortfolio.getMarketValue());
    }
}

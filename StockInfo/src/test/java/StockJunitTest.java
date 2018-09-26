import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StockJunitTest {
    @InjectMocks
    StockPortfolio stockPortfolio=new StockPortfolio();

    @Mock
    StockService stockService;

    @Test
    public void testPortfolio(){
        Stock fb = new Stock("facebook", 70, 4);
        Stock youtube = new Stock("youtube", 65, 10);

        stockPortfolio.addStock(fb);
        stockPortfolio.addStock(youtube);

        Mockito.when(stockService.getPrice(fb)).thenReturn(70*4.0);
        Mockito.when(stockService.getPrice(youtube)).thenReturn(65*10.0);

        Assert.assertEquals(stockPortfolio.getMarketValue(), 930, 2);

    }
}

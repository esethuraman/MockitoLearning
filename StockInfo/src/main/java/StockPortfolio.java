import java.util.LinkedList;
import java.util.List;

public class StockPortfolio {

    private StockService stockService;
    private List<Stock> stocks;
    private double marketPrice;

    StockPortfolio(){
        marketPrice = 0;
        stocks = new LinkedList<Stock>();
    }

    public void setStockService(StockService stockService){
        this.stockService = stockService;
    }

    public StockService getStockService(){
        return stockService;
    }

    public void addStock(Stock stock){
        stocks.add(stock);
    }

    public double getMarketValue(){
        for(Stock stock: stocks){
            marketPrice += stockService.getPrice(stock);
        }

        return marketPrice;
    }
}

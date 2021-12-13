package vendingmachine.domain.machine;

import vendingmachine.domain.machine.coin.Coin;
import vendingmachine.domain.machine.coin.storage.CoinStorage;
import vendingmachine.domain.machine.coin.storage.CoinStorageImpl;
import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.machine.product.storage.ProductStorage;
import vendingmachine.domain.machine.product.storage.ProductStorageImpl;
import vendingmachine.domain.user.Balance;
import vendingmachine.domain.user.User;

public class Machine {

	private CoinStorage coinStorage = new CoinStorageImpl();
	private ProductStorage productStorage = new ProductStorageImpl();

	public void saveCoin(Coin coin) {
		coinStorage.save(coin);
	}

	public void saveProduct(Product product) {
		productStorage.save(product);
	}

	public void purchaseProduct(Balance balance, String productName) {
		Product product = productStorage.findOne(productName);
		product.sell(balance);
	}

	public void refund(User user) {
		coinStorage.refund(user);
	}

}

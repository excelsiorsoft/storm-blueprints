package wordcount;

import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class YahooLoaderTest {

	@Test
	public void grabbingQuotesFromYahoo() throws Throwable {

		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(
				"http://ichart.finance.yahoo.com/table.csv?s=RIG");
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			Scanner scanner = new Scanner(entity.getContent());
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}

		}
	}

}

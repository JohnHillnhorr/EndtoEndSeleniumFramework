package AbstractComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerDemo implements IRetryAnalyzer {
	int run=0;
	@Override
	public boolean retry(ITestResult result) {
		if(run<1) {
			run++;
			return true;
		}
		return false;
	}

}

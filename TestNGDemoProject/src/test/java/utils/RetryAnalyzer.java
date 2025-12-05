package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count = 0;
    int max = 3;  // retry 3 times

    @Override
    public boolean retry(ITestResult result) {
        if (count < max) {
            count++;
            System.out.println("Retrying test → Attempt: " + count);
            return true;
        }
        return false;
    }
}

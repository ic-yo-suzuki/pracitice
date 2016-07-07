package jp.co.junit4.sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ConverterUtilityTest.class, ValidatorUtilityTest.class})
public class AllTests {

}

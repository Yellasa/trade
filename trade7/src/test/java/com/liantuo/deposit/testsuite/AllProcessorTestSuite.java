package com.liantuo.deposit.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.liantuo.deposit.testsuite.processor.AllPoolProcessorTestSuite;

/**
 * 账务模块所有Processor单元测试 com.liantuo.deposit.*.controller
 *
 */
@RunWith(Suite.class)
@SuiteClasses({AllPoolProcessorTestSuite.class})
public class AllProcessorTestSuite {

}

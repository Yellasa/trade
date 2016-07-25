package com.liantuo.deposit.testsuite.mapper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.liantuo.deposit.advanceaccount.orm.mapper.AccountForbidMapperTest;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountMapperTest;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountTradeHistoryMapperTest;
/**
 * 账务模块pool子模块所有DAO单元测试 com.liantuo.deposit.advanceaccount.*.mapper.*
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CreditAccountMapperTest.class,
		CreditAccountTradeHistoryMapperTest.class,
		AccountForbidMapperTest.class })
public class AllAdvancedAccountMapperTestSuite {

}

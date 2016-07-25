package com.liantuo.deposit.testsuite.mapper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapperTest;
/**
 * 账务模块pool子模块所有DAO单元测试 com.liantuo.deposit.pool.*.mapper.*
 *
 */
@RunWith(Suite.class)
@SuiteClasses({PoolMapperTest.class})
public class AllPoolMapperTestSuite {

}

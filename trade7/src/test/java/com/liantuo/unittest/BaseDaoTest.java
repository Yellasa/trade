package com.liantuo.unittest;

import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({
	"test-applicationContext-deposit-mapper.xml" })
public class BaseDaoTest  extends UnitilsJUnit4{

    @SpringApplicationContext  
    public ApplicationContext applicationContext;
}

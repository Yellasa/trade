package com.liantuo.deposit.pool.bus.service;

import java.util.List;

import com.ebill.framework.exception.BusinessException;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.PoolQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;

public interface PoolService {
//	 public Pool selectByPrimaryKey(Integer id);
//	 public int deleteByPrimaryKey(Integer id);
//	 public int updateByPrimaryKey(Pool record);
//	 public int insert(Pool record);
	 public List<PoolRspVo> findPoolsByQueryVO(PoolQueryVo poolQueryVo);
	 public List<PoolInnerRspVo> findPoolsByQueryInnerVO(PoolQueryInnerVo poolQueryInnerVo);
	 public PoolRspVo findByMerchantNoAndPoolName(PoolQueryVo poolQueryVo);
	 public Pool createPool(Pool record) throws BusinessException;
	 int countPoolsByQueryVO(PoolQueryVo poolQueryVo); 
	 int countPoolsByQueryInnerVO(PoolQueryInnerVo poolQueryVo);
}

package com.liantuo.deposit.pool.bus.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebill.framework.exception.BusinessException;
import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapper;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.PoolQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.deposit.common.constants.errorcode.SystemErrorCode;
import com.liantuo.deposit.pool.bus.service.PoolService;

@Service("poolService")
public class PoolServiceImpl implements PoolService {
    @Autowired
    private PoolMapper poolMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(PoolServiceImpl.class);

//    public Pool selectByPrimaryKey(Integer id) {
//        return this.poolMapper.selectByPrimaryKey(id);
//    }
//
//    public int deleteByPrimaryKey(Integer id) {
//        return this.poolMapper.deleteByPrimaryKey(id);
//    }
//
// 
//    public int updateByPrimaryKey(Pool record) {
//        return this.poolMapper.updateByPrimaryKey(record);
//    }
//
//    public int insert(Pool record) {
//        return this.poolMapper.insert(record);
//    }

    /**
     * 资金池查询接口
     */
	public List<PoolRspVo> findPoolsByQueryVO(PoolQueryVo poolQueryVo) {
		return poolMapper.findPoolsByQueryVO(poolQueryVo);
	}
	/**
	 * 资金池内部查询接口
	 */
	public List<PoolInnerRspVo> findPoolsByQueryInnerVO(PoolQueryInnerVo poolQueryVo) {
		return poolMapper.findPoolsByQueryInnerVO(poolQueryVo);
	}

	@Override
	public PoolRspVo findByMerchantNoAndPoolName(PoolQueryVo poolQueryVo) {
		return poolMapper.findByMerchantNoAndPoolName(poolQueryVo);
	}

	@Override
	public Pool createPool(Pool record) throws BusinessException {
		int rows =poolMapper.insert(record);
		if(rows!=1){
			LOGGER.error("创建资金池接口返回结果为{}",rows);
			throw new BusinessException(SystemErrorCode.UNKNOWN_EXCEPTION,"系统异常");
		}else{
			return record;
		}
	}

	@Override
	public int countPoolsByQueryVO(PoolQueryVo poolQueryVo) {
	  return poolMapper.countPoolsByQueryVO(poolQueryVo);
	}

	@Override
	public int countPoolsByQueryInnerVO(PoolQueryInnerVo poolQueryVo) {
		return poolMapper.countPoolsByQueryInnerVO(poolQueryVo);
	}


}
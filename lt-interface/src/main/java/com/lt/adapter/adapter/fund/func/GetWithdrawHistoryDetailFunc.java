package com.lt.adapter.adapter.fund.func;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.adapter.adapter.BaseFunction;
import com.lt.api.fund.IFundAccountApiService;
import com.lt.util.error.LTResponseCode;
import com.lt.util.utils.model.Response;

/**
 * 获取出金明细
 * @author jingwb
 *
 */
@Service
public class GetWithdrawHistoryDetailFunc  extends BaseFunction{
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IFundAccountApiService fundAccountApiService;
	
	@Override
	public Response response(Map<String, Object> paraMap) {
		String userId = String.valueOf(paraMap.get("userId"));
		Long ioId = Long.valueOf(paraMap.get("ioId").toString());
		Map<String,Object> map = fundAccountApiService.getWithdrawHistoryDetail(userId, ioId);
		return LTResponseCode.getCode(LTResponseCode.SUCCESS, map);
	}
}

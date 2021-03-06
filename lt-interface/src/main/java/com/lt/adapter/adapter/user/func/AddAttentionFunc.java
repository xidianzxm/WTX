package com.lt.adapter.adapter.user.func;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.adapter.adapter.BaseFunction;
import com.lt.api.user.IUserApiService;
import com.lt.util.error.LTException;
import com.lt.util.error.LTResponseCode;
import com.lt.util.utils.StringTools;
import com.lt.util.utils.model.Response;

@Service
public class AddAttentionFunc extends BaseFunction {

	@Autowired
	private IUserApiService userApiService;

	@Override
	public Response response(Map<String, Object> paraMap) {
		Response response = null;
		String userId = String.valueOf(paraMap.get("userId"));
//		String productIds = StringTools.formatStr(paraMap.get("productIds"), "");
		String productCode = StringTools.formatStr(paraMap.get("productCode"), "");
		try {
//			userApiService.addProductOptional(userId, productIds);
			userApiService.addProductOptionalByCode(userId, productCode);
			response = LTResponseCode.getCode(LTResponseCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			throw new LTException(e.getMessage());
		}
		return response;
	}
}

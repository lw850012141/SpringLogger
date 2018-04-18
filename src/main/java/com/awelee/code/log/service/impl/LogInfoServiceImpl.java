package com.awelee.code.log.service.impl;

import java.util.List;
import com.awelee.code.log.po.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.awelee.code.log.service.LogInfoService;

@Service
public class LogInfoServiceImpl implements LogInfoService {
	
	public final static Logger LOGGER = LoggerFactory.getLogger(LogInfoServiceImpl.class);

	@Override
	public List<Log> selectLogs(Log var1) {
		System.out.println("模块名称："+var1.getModel()+"\t\n子模块："+var1.getSubModelName()+"\t\n操作类型："+var1.getOperateType()+"\t\n备注："+var1.getRemark());
		return null;
	}

	@Override
	public int insertLog(Log var1) {
		System.out.println("模块名称："+var1.getModel()+"\t\n子模块："+var1.getSubModelName()+"\t\n操作类型："+var1.getOperateType()+"\t\n备注："+var1.getRemark());
		return 0;
	}
}
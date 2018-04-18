package com.awelee.code.log.service;

import com.awelee.code.log.po.Log;
import java.util.List;

public interface LogInfoService {

	List<Log> selectLogs(Log var1);

	int insertLog(Log var1);
}
package com.hgt.service.impl;

import com.hgt.domain.DataResult;
import com.hgt.domain.SimpleStringBean;
import com.hgt.entity.LogApps;
import com.hgt.mapper.LogAppsMapper;
import com.hgt.service.LogAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * README:
 * Created by root on 11/17/16.
 * =============================================================================
 * CHANGELOG:
 */
@Service
public class LogAppsServiceImpl implements LogAppsService {

    @Autowired
    private LogAppsMapper logAppsMapper;

    @Override
    public DataResult<LogApps> findLogAppById(String laId) {
        return new DataResult<>(logAppsMapper.selectLogAppsById(laId));
    }

    @Override
    public DataResult<List<LogApps>> findAllLogApps() {
        return new DataResult<>(logAppsMapper.selectAllLogApps());
    }

    @Override
    public DataResult<SimpleStringBean> getTableCounts() {
        int ret = logAppsMapper.getTableCounts();
        return new DataResult<>(new SimpleStringBean(String.valueOf(ret)));
    }

    @Override
    public DataResult<SimpleStringBean> addLogApp(LogApps logApp) {
        int ret = logAppsMapper.insertLogApps(logApp);
        return new DataResult<>(new SimpleStringBean("成功插入： " + ret + " 条记录"));
    }

    @Override
    public DataResult<SimpleStringBean> deleteLogAppByRowId(String laId) {
        int ret = logAppsMapper.deleteLogAppByRowId(laId);
        return new DataResult<>(new SimpleStringBean("成功删除： " + ret + " 条记录"));
    }

    @Override
    public DataResult<SimpleStringBean> deleteLogAppByAppCode(String appCode) {
        int ret = logAppsMapper.deleteLogAppByAppCode(appCode);
        return new DataResult<>(new SimpleStringBean("成功删除： " + ret + " 条记录"));
    }

    @Override
    public DataResult<SimpleStringBean> updateLogApp(LogApps logApps) {
        int ret = logAppsMapper.updateByPrimaryKey(logApps);
        return new DataResult<>(new SimpleStringBean("成功更新： " + ret + " 条记录"));    }
}

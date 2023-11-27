package com.shiyan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiyan.dao.RecordMapper;
import com.shiyan.domain.Record;
import com.shiyan.domain.User;
import com.shiyan.service.RecordService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional //不懂
public class RecordMapperImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public Integer addRecord(Record record) {
        return recordMapper.addRecord(record);
    }

    @Override
    public PageResult searchRecords(Record record, User user, Integer pageNum, Integer pageSize) {
        // 设置分页查询的参数，开始分页
        PageHelper.startPage(pageNum, pageSize);
        //如果不是管理员，则查询条件中的借阅人设置为当前登录用户
        if(!"ADMIN".equals(user.getRole())){
            record.setBorrower(user.getName());
        }
        Page<Record> page= recordMapper.searchRecords(record);
        return new PageResult(page.getTotal(),page.getResult());
    }
}

package com.shiyan.service;

import com.shiyan.domain.Record;
import com.shiyan.domain.User;
import entity.PageResult;

public interface RecordService {
    //新增借阅记录
    Integer addRecord(Record record);
    //查询借阅记录
    PageResult searchRecords(Record record, User user, Integer pageNum, Integer pageSize);
}

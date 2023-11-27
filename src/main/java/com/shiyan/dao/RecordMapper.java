package com.shiyan.dao;

import com.github.pagehelper.Page;
import com.shiyan.domain.Record;

public interface RecordMapper {
    //新增借阅记录
    Integer addRecord(Record record);
    Page<Record> searchRecords(Record record);
}

package com.cyan.mapper;

import com.cyan.pojo.Label;
import org.apache.ibatis.annotations.Select;

public interface LabelMapper2 {
    @Select("select * from t_label where id=#{id}")
    Label selectLabelById(Integer id);
}

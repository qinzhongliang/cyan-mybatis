package com.cyan.mapper;

import com.cyan.pojo.Label;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LabelMapper1 {

    @Select("select * from t_label where id=#{id}")
    Label selectLabelById(Integer id);

    @Select("select * from t_label where id=#{id}")
    Label getLabelById(Integer id);

    @Update("update t_label set name=#{name} where id=#{id}")
    Integer updateLabelById(Label label);
}

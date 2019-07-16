package com.qf.java1902.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */
@Data
public class EasyuiDataGridResult {

    private Long total; //总记录数
    private List<?> rows;   //返回当前页的结果集
}

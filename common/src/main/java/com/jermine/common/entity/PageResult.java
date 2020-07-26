package com.jermine.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {

    private Long page;

    private Long pageSize;

    private Long totalSize;

    private List<T> pageList;

}

package com.jermine.base.entity;

import com.jermine.base.exception.BaseBizStatusCode;
import com.jermine.common.annotation.FieldExInfo;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {

    @Id
    private String id;

    @NotNull(message = "标签名不能为空")
    @Size(min = 1, max = 7, message = "标签名长度必须是1-7个字符")
    @FieldExInfo(value = "000005", message = "标签名称输入不合法")
    private String labelName;

    private String state;

    private Long count;

    private String recommend;

    private Long fans;
}


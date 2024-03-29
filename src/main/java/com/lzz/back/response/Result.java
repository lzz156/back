package com.lzz.back.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("统一响应对象")
public class Result<T>{
    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("信息")
    private String message;

    @ApiModelProperty("数据")
    private T data;
}

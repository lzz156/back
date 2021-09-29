package com.lzz.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzz
 * @since 2021-09-23
 */
@Data//为类提供读写功能，从而不用写get、set方法
@EqualsAndHashCode(callSuper = false) //会使用所有非瞬态(non-transient)和非静态(non-static)字段来生成equals和hascode方法
@Component//泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注
@AllArgsConstructor//为类提供一个全参的构造方法
@NoArgsConstructor//为类提供一个无参的构造方法
@ApiModel("用户实体")//标注为用户实体
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)//来实现自增序列id自动插入的功能
    @ApiModelProperty("用户id")//表示对model属性的说明或者数据操作更改
    private Integer userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("加密的盐")
    private String salt;

    @ApiModelProperty("姓名")
    private String nickname;

    @ApiModelProperty("学院id")
    private int schoolId;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("电话号码")
    private String tel;

    @ApiModelProperty("班级")
    private String studentClass;
}

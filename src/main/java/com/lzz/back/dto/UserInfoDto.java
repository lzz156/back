package com.lzz.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UserInfoDto {
    private String username;

    private String password;
}

package com.mvc.user.mapper;

import com.mvc.user.dto.UserDTO;
import com.mvc.user.entity.User;
import com.mvc.user.vo.UserVO;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author qyc
 */
public interface UserMapper extends Mapper<User> {
    /**
     * selectUserByPwd
     *
     * @param user
     * @return
     */
    @Select("select * from user where cellphone=#{cellphone} and password=#{password}")
    User selectUserByPwd(User user);

    /**
     * selectUserByPhone
     *
     * @param user
     * @return
     */
    @Select("select * from user where cellphone=#{cellphone}")
    User selectUserByPhone(UserDTO user);

    /**
     * list
     *
     * @return
     */
    @Select({"<script>",
            "SELECT * FROM `user`",
            "WHERE 1 = 1",
            "<when test=\"cellphone!=null and cellphone !=''\">",
            "AND cellphone = #{cellPhone}",
            "</when>",
            "</script>"})
    List<UserVO> list(String cellphone);

    /**
     * selectNullAddr
     *
     * @return
     */
    @Select("SELECT * FROM user WHERE address_eth is null")
    List<User> selectNullAddr();
}
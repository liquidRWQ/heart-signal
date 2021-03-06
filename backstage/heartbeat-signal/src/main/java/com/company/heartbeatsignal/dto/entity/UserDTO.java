package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liquid
 * @类名： UserDTO
 * @描述：
 * @date 2019/5/8
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 6542778703832168720L;

    /**
     * 微信公众号用户id
     */
    private String publicUserOpenid;

    /**
     * id
     */
    private Integer id;


    /**
     * ids
     */
    private List<Integer> ids;

    /**
     * key
     */

    String sessionKey;

    /**
     * 用户私密数据
     */
    String encryptedData;
    /**
     * 秘钥向量
     */

    String iv;

    /**
     * 微信小程序的用户code
     */
    String code;

    /**
     * 用户微信openid
     */
    private String userOpenid;

    /**
     * 用户头像url
     */
    private String userAvatarUrl;

    /**
     * 用户微信昵称
     */
    private String userNickname;

    /**
     * 用户所在城市
     */
    private String userCity;

    /**
     * 用户手机号
     */
    private String phoneNumber;

    /**
     * 身份证号码
     */
    private String idCardNumber;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户首页图片
     */
    private String firstUserPhotoName;

    /**
     * 用户性别
     */
    private Short gender;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户身高
     */
    private Double height;

    /**
    *   首页图片名
    */
    String photoName;

    private static UserConvert userConvert;

    static {
        userConvert = new UserConvert();
    }

    public User convertToUser() {

        return userConvert.convertToDO(this);
    }

    public UserDTO convertToUserDTO(User user) {
        return userConvert.convertToDTO(user);
    }

    public static class UserConvert implements Convertible<User, UserDTO> {

        @Override
        public User convertToDO(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            return user;
        }

        @Override
        public UserDTO convertToDTO(User user) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        }
    }
}

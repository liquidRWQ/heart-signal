package com.company.heartbeatsignal.dto.entity;

import com.company.heartbeatsignal.dto.Convertible;
import com.company.heartbeatsignal.entity.UserBaseInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Liquid
 * @类名： UserBaseInfoDTO
 * @描述：
 * @date 2019/5/8
 */
@Data
public class UserBaseInfoDTO implements Serializable {
    private static final long serialVersionUID = -6054347142096242568L;
    /**
     * 用户信息id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 关联用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户性别
     */
    private Short gender;

    /**
     * 用户头像
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户身高
     */
    private Double height;

    /**
     * 毕业或就读大学
     */
    private String collage;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 最高学历
     */
    @Column(name = "highest_education")
    private String highestEducation;

    /**
     * 用户生日
     */
    private Date birthday;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 用户写真图片路径，用逗号隔开
     */
    private String portrayPath;

    /**
     * 用户对自己的描述
     */
    private String about;

    /**
     * 用户的兴趣爱好
     */
    private String hobby;

    /**
     * 用户的感情观
     */
    private String emotionalView;

    /**
     * 用户的好友印象
     */
    private String friendImpression;

    /**
     * 用户心仪对象的描述
     */
    private String loveHer;

    private static UserBaseInfoConvert userBaseInfoConvert;

    static {
        userBaseInfoConvert = new UserBaseInfoConvert();
    }

    public UserBaseInfo convertToUserBaseInfo() {
        return userBaseInfoConvert.convertToDO(this);
    }

    public UserBaseInfoDTO convertToUserBaseInfoDTO(UserBaseInfo userBaseInfo) {
        return userBaseInfoConvert.convertToDTO(userBaseInfo);
    }

    public static class UserBaseInfoConvert implements Convertible<UserBaseInfo, UserBaseInfoDTO> {

        @Override
        public UserBaseInfo convertToDO(UserBaseInfoDTO userBaseInfoDTO) {
            UserBaseInfo userBaseInfo = new UserBaseInfo();
            BeanUtils.copyProperties(userBaseInfoDTO, userBaseInfo);
            return userBaseInfo;
        }

        @Override
        public UserBaseInfoDTO convertToDTO(UserBaseInfo userBaseInfo) {
            UserBaseInfoDTO userBaseInfoDTO = new UserBaseInfoDTO();
            BeanUtils.copyProperties(userBaseInfo, userBaseInfoDTO);
            return userBaseInfoDTO;
        }
    }
}

package com.xiao.spring5.vo.invo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

public class UserVo4Validate implements Serializable {
    @NotBlank(message = "登录名不能为空")
    private String loginName;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 8, message = "密码长度必须再6-8位之间")
    private String password;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Range(min = 15, max = 60, message = "年龄必须在15-60岁之间")
    private Integer age;
    @Email(message = "必须是合法的邮箱地址")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "日期必须是一个过去的时间")
    private Date birthday;
    @Pattern(regexp = "[1][3,8][3, 6, 9][0-8]{8}", message = "无效的电话号码")
    private String phone;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

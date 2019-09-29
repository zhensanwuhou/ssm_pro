package com.kk.po;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
* Created by kk on 2019-1-25.
*/
public class User implements Serializable{
        // 
        private Integer id;
        // 
        private String name;
        // 
        private String password;
        // 
        private Integer roleType;
        // 
        private Date createTime;
        // 
        private Integer deleteFlag;

        public Integer getId() {
            return id;
        }

        public User setId(Integer id) {
            this.id = id;
            return this;
        }
        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }
        public String getPassword() {
            return password;
        }

        public User setPassword(String password) {
            this.password = password;
            return this;
        }
        public Integer getRoleType() {
            return roleType;
        }

        public User setRoleType(Integer roleType) {
            this.roleType = roleType;
            return this;
        }
        public Date getCreateTime() {
            return createTime;
        }

        public User setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
        public Integer getDeleteFlag() {
            return deleteFlag;
        }

        public User setDeleteFlag(Integer deleteFlag) {
            this.deleteFlag = deleteFlag;
            return this;
        }
}

package com.kk.shiro.realm;

import com.kk.po.User;
import com.kk.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /*
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;
    */

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取登录时输入的用户名
        String username = (String) principalCollection.getPrimaryPrincipal();

        if (username != null) {
            //获取用户信息
            User user = userService.getUserByName(username);
            /*
            //获取用户角色
            List<Role> roles=roleService.getRoles(username);
            //获取权限列表
            List<String> permission=permissionService.getTheUrl(user.getId());
            */
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            /*if(roles!=null&&!roles.isEmpty()){
                for(Role role:roles){
                    info.addRole(role.getRole());//加入角色
                }
            }

            if(permission!=null&&!permission.isEmpty()){
                for(String url:permission){
                    info.addStringPermission(url);//加入权限
                }
            }*/

            return info;
        }
        return null;
    }

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //通过表单接收的用户名
        String username = token.getUsername();
        System.out.println("username:" + username);
        if (username != null && !"".equals(username)) {
            User user = userService.getUserByName(username);
            if (user != null) {
                return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
            }
        }
        System.out.println("认证失败");
        return null;
    }
}

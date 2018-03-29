package com.bolean.conf;

import com.bolean.entity.Role;
import com.bolean.entity.RoleFolder;
import com.bolean.entity.User;
import com.bolean.service.RoleFolderService;
import com.bolean.service.RoleService;
import com.bolean.service.UserRoleService;
import com.bolean.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LogManager.getLogger(ShiroRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleFolderService roleFolderService;

    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("+++++++++++++++++++++++++++++++++++++doGetAuthorizationInfo+"+principalCollection.toString());

        User user = userService.selectByUserName((String) principalCollection.getPrimaryPrincipal());
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getUserId()),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        /*//赋予角色
        for(Role userRole:user.getRoles()){
            info.addRole(userRole.getRoleName());
        }*/

        Role role = roleService.selectByPrimaryKey(user.getRoleId());

        /*UserRole userRole = new UserRole();
        userRole.setUserId(user.getUserId());
        UserRole role = userRoleService.selectOne(userRole);*/
        info.addRole(role.getKeyName());

        //赋予权限
        RoleFolder roleFolder = new RoleFolder();
        roleFolder.setRoleId(role.getRoleId());
        for (RoleFolder folder:roleFolderService.selectByInfo(roleFolder)){
            info.addStringPermission(folder.getKeyName());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("--------------------------------doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        logger.info(userName+token.getPassword());

        User u = new User();
        u.setUserName(token.getUsername());
        User user = userService.selectOne(u);
        if (user != null) {
//            byte[] salt = Encodes.decodeHex(user.getSalt());
//            ShiroUser shiroUser=new ShiroUser(user.getId(), user.getLoginName(), user.getName());
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
    }
}

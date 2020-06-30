package com.ryzezhao.springcloud.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * MyBatis拦截器，自动注入创建人、创建时间、修改人、修改时间
 *
 * @author: HeHaoZhao
 * @date: 2020/5/4 17:59
 */
@Slf4j
@Component
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class MybatisInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		String sqlId = mappedStatement.getId();
		log.debug("------sqlId------" + sqlId);
		SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
		Object parameter = invocation.getArgs()[1];
		log.debug("------sqlCommandType------" + sqlCommandType);

		if (parameter == null) {
			return invocation.proceed();
		}
		if (SqlCommandType.INSERT == sqlCommandType) {
			Field[] fields = ConvertUtils.getAllFields(parameter);
			for (Field field : fields) {
				log.debug("------field.name------" + field.getName());
				try {
					// 获取登录用户信息
//					UserInfo sysUser = CurrentUserInfoUtils.getUserInfo();

					if ("createBy".equals(field.getName())) {
						field.setAccessible(true);
						Object local_createBy = field.get(parameter);
						field.setAccessible(false);
						if (local_createBy == null || local_createBy.equals("")) {
							String createBy = "zhao";
//							if (sysUser != null) {
//								// 登录账号
//								createBy = sysUser.getUsername();
//							}
							if (ConvertUtils.isNotEmpty(createBy)) {
								field.setAccessible(true);
								field.set(parameter, createBy);
								field.setAccessible(false);
							}
						}
					}
					// 注入创建时间
					if ("createTime".equals(field.getName())) {
						field.setAccessible(true);
						Object local_createDate = field.get(parameter);
						field.setAccessible(false);
						if (local_createDate == null || local_createDate.equals("")) {
							field.setAccessible(true);
							field.set(parameter, new Date());
							field.setAccessible(false);
						}
					}

					// 注入修改时间
					if ("updateTime".equals(field.getName())) {
						field.setAccessible(true);
						Object local_updateDate = field.get(parameter);
						field.setAccessible(false);
						if (local_updateDate == null || local_updateDate.equals("")) {
							field.setAccessible(true);
							field.set(parameter, new Date());
							field.setAccessible(false);
						}
					}
				} catch (Exception e) {
				}
			}
		}
		if (SqlCommandType.UPDATE == sqlCommandType) {
			Field[] fields = null;
			if (parameter instanceof ParamMap) {
				ParamMap<?> p = (ParamMap<?>) parameter;
				//原来的参数为param1，会导致报错，正常使用为et
				if (p.containsKey("param1")) {
					parameter = p.get("param1");
				}else{
					parameter = p.get("et");
				}
				fields = ConvertUtils.getAllFields(parameter);
			} else {
				fields = ConvertUtils.getAllFields(parameter);
			}

			for (Field field : fields) {
				log.debug("------field.name------" + field.getName());
				try {
					if ("updateBy".equals(field.getName())) {
						field.setAccessible(true);
						Object local_updateBy = field.get(parameter);
						field.setAccessible(false);
						if (local_updateBy == null || local_updateBy.equals("")) {
							String updateBy = "zhao";
							// 获取登录用户信息
//							UserInfo sysUser = CurrentUserInfoUtils.getUserInfo();
//							if (sysUser != null) {
//								// 登录账号
//								updateBy = sysUser.getUsername();
//							}
							if (ConvertUtils.isNotEmpty(updateBy)) {
								field.setAccessible(true);
								field.set(parameter, updateBy);
								field.setAccessible(false);
							}
						}
					}
					if ("updateTime".equals(field.getName())) {
						field.setAccessible(true);
						Object local_updateDate = field.get(parameter);
						field.setAccessible(false);
						if (local_updateDate == null || local_updateDate.equals("")) {
							field.setAccessible(true);
							field.set(parameter, new Date());
							field.setAccessible(false);
						}
					}
				} catch (Exception e) {
				}
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

}

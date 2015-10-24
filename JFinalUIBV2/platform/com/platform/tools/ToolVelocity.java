package com.platform.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import freemarker.template.TemplateException;

/**
 * Velocity工具类
 * @author 董华健
 */
public abstract class ToolVelocity {

	/**
	 * 渲染模板
	 * @param templateContent
	 * @param paramMap
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String render(String templateContent, Map<String, Object> paramMap) {
		// 初始化并取得Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		ve.init();

		// 取得velocity的上下文context
		VelocityContext context = new VelocityContext();
		
		Set<String> keys = paramMap.keySet();
		for (String key : keys) {
			context.put(key, paramMap.get(key));// 把数据填入上下文
		}

		// 输出流
		StringWriter writer = new StringWriter();

		// 转换输出
		ve.evaluate(context, writer, "", templateContent); // 关键方法

		return writer.toString();
	}
	
	/**
	 * 生成静态html
	 * @param ftlPath 模板路径
	 * @param paramMap 参数
	 * @param htmlPath html文件保存路径
	 */
	public static void makeHtml(String ftlPath, Map<String, Object> paramMap, String htmlPath) {
		try {
            //初始化vm模板
            Template template = Velocity.getTemplate(ftlPath, "UTF-8");
           
            //初始化上下文
            VelocityContext context = new VelocityContext();
            
            //添加数据到上下文中
            Set<String> keys = paramMap.keySet();
            for (String key : keys) {
            	context.put(key, paramMap.get(key));
			}
            
            //生成html页面
            PrintWriter pw=new PrintWriter("htmlPath");
            template.merge(context, pw);
            
            //关闭流
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        } catch (ParseErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}

package com.kk;

import com.alibaba.fastjson.JSON;
import com.kk.po.User;
import com.kk.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringReader;

@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMyBatis {

    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    @Resource
    private UserService userService = null;

    @Test
    public void test1() {
        User user = userService.getById(1);
        logger.info(JSON.toJSONString(user));
    }

    public static void main(String[] args) {
        //String text = "在中国进入全面建成小康社会决定性阶段，胡锦涛同志所作的十八大报告，浓缩了改革开放以来特别是最近十年来党领导中国发展建设的经验与启示，勾画出中国未来发展的蓝图。报告中的新表述、新思想、新论断，引发了与会代表和各界干部群众的广泛关注。";
        String text = "基于java语言开发的轻量级的中文分词工具包";

        //独立Lucene实现
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re,true);
        Lexeme lex = null;
        try {
            while((lex=ik.next())!=null){
                System.out.print(lex.getLexemeText()+"|");
            }
        }catch (Exception e) {
        }

    }

}

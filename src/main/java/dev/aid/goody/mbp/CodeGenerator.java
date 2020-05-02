package dev.aid.goody.mbp;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器
 *
 * @author: 04637@163.com
 * @date: 2019/3/3
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        // ================= 必须修改的配置 start =================

        // 数据源配置
        String jdbcUrl = "jdbc:mysql://deva.wiki:3306/goody?serverTimezone=Asia/Shanghai&useUnicode=true&useSSL=false&characterEncoding=utf8";
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String jdbcUsername = "root";
        String jdbcPassword = "mysql_Jgt.2019";

        // 父级包名配置
        String parentPackage = "dev.aid.goody";

        // 生成代码的 @author 值
        String author = "04637@163.com";

        // 要生成代码的表名配置
        String[] tables = {
                "user_info"
        };

        // ================= 必须修改的配置 end =================


        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        // 生成完毕后是否打开输出目录
        gc.setOpen(false);
        // 为true时生成entity将继承Model类，单类即可完成基于单表的业务逻辑操作，按需开启
        gc.setActiveRecord(false);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(jdbcUrl);
        dsc.setDriverName(jdbcDriver);
        dsc.setUsername(jdbcUsername);
        dsc.setPassword(jdbcPassword);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 父级包名，按需修改
        pc.setParent(parentPackage);
        // 设置模块名, 会在parent包下生成一个指定的模块包
        pc.setModuleName(null);
        pc.setMapper("dao");
        pc.setXml("dao/mapper");
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setRestControllerStyle(true);
        strategy.setSkipView(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tables);
        strategy.setSuperEntityColumns("id");
        // Controller驼峰连字符，如开启，则requestMapping由 helloWorld 变为 hello-world 默认false
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        // 开启后将使用lombok注解代替set-get方法，false则生成set-get方法
        strategy.setEntityLombokModel(true);
        // 在实体类中移除is前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setSkipView(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }

}
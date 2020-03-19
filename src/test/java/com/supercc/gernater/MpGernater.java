package com.supercc.gernater;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wcc
 * Date 2020/3/17.
 */
public class MpGernater {
    //    作者
    private static String author = "wcc";
    //    项目输出路径
    private static String outPutDir = "D:\\javawork\\mybites-puls-demo\\src\\main\\java";
    //    resource路径
    private static String resourcePath = "D:\\javawork\\mybites-puls-demo\\src\\main\\resources";
    //    顶级包结构
    private static String parentPackage = "com.supercc.gernater";
    //    驱动
    private static String driver = "com.mysql.cj.jdbc.Driver";
    //    数据库连接地址
    private static String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=GMT%2B8&characterEncoding=UTF-8&allowMultiQueries=true";
    //    用户名
    private static String userName = "root";
    //    密码
    private static String password = "123456";
    //    数据表前缀
    private static String tableFperFix = "sys_";
    //    生成的表
    //    多表使用逗号分隔
    private static String[] tables = {"sys_user"};
    //    数据访问层包名
    private static String dao = "dao";
    //     业务逻辑层包名
    private static String service = "service";
    //     业务逻辑层包名
    private static String impl = "service.impl";
    //    实体类包名
    private static String entity = "model.entity";
    //    控制器层包名
    private static String controller = "controller";
    //    mapper映射包名
    private static String mapperxml = "mapper";

    private static String xmlVM = "/templates/mapper.xml.vm";

    /**
     * 代码生成
     */
    @Test
    public void create() {
//        全局配置
        GlobalConfig config = new GlobalConfig();
        config.setAuthor(author)
                .setOpen(false)
                .setSwagger2(true)
                .setOutputDir(outPutDir)
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setEntityName("%s")
                .setMapperName("%sDao")
                .setControllerName("%sController")
                .setBaseResultMap(true)
                .setBaseColumnList(true);
//        数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(driver)
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        //将数据库中datetime转换成date
                        if (fieldType.toLowerCase().contains("datetime")) {
                            return DbColumnType.DATE;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                })
                .setUrl(url)
                .setUsername(userName)
                .setPassword(password);
//        策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("createTime", FieldFill.INSERT));
        tableFillList.add(new TableFill("updateTime", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("modifyTime", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("create_Time", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_Time", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("modify_Time", FieldFill.INSERT_UPDATE));
        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix(tableFperFix)
                .setInclude(tables)
                .setTableFillList(tableFillList)
                .setEntityTableFieldAnnotationEnable(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true);
//        包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parentPackage)
                .setMapper(dao)
                .setService(service)
                .setServiceImpl(impl)
                .setController(controller)
                .setEntity(entity);
//        整合配置
        TemplateConfig tc = new TemplateConfig();
        tc.setEntity("/templates/entity.java").setService("/templates/service.java")
                .setController("/templates/controller.java").setMapper("/templates/mapper.java")
                .setServiceImpl("/templates/serviceImpl.java").setXml(null);
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setCfg(getInjectionConfig())
                .setTemplate(tc)
                .setPackageInfo(packageConfig);
        autoGenerator.execute();
    }

    /**
     * 获取InjectionConfig
     * 自定义使用模版
     *
     * @return
     */
    protected InjectionConfig getInjectionConfig() {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        //生成xml
        focList.add(new FileOutConfig(
                xmlVM) {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return resourcePath + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        return injectionConfig;

    }


}

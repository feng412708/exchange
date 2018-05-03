package com.mywind.windfarmplan.utils.mybatisgenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成的执行文件，直接执行main方法即可生成代码
 * Created by LiRongJiang on 2017/4/5.
 */
public class MybatisGenerator {

    //项目所在地址，如果项目不是这个地址，需要修改，生成的文件将会放到这个目录下
    private static final String PROJECT_DIR ="D://MY//new//windfarmplan//src//main//java";
    //包名
    private static final String PACKAGE_NAME ="com.mywind";
    //项目名
    private static final String PROJECT_NAME ="windfarmplan";

    /**
     * 原则上本地库建好表进行代码生成
     * 线上测试环境和正式环境不可能运行本代码
     */
    //数据库驱动名称
    private static final String DATABASE_CLASS_NAME ="com.mysql.jdbc.Driver";
    //数据库用户名
    private static final String DATABASE_USERNAME ="root";
    //数据库密码
    private static final String DATABASE_PASSWORD ="123456";
    //数据库地址
    private static final String DATABASE_URL ="jdbc:mysql://127.0.0.1:3306/wind_farm_plan?characterEncoding=utf8&serverTimezone=UTC";



    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_DIR);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("zhanglinbo");


        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName(DATABASE_CLASS_NAME);
        dsc.setUsername(DATABASE_USERNAME);
        dsc.setPassword(DATABASE_PASSWORD);
        dsc.setUrl(DATABASE_URL);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[]{"tlog_", "tsys_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略,下划线转为驼峰
        strategy.setInclude(new String[] {
                /* "sys_role",
                 "sys_role_menu_relation",
                 "sys_user",
                 "sys_user_role_relation"*/
                "tb_tower_wind_speed_data"
        }); // 需要生成的表

        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_NAME);
        pc.setModuleName(PROJECT_NAME);
        pc.setEntity("beans.entity"); //设置实体类所在的包目录
        pc.setMapper("dao");    //设置mapper 接口所在的目录
        mpg.setPackageInfo(pc);

//        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
//        // 自定义 xxList.jsp 生成
//        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//        focList.add(new FileOutConfig("/template/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return "D://my_" + tableInfo.getEntityName() + ".jsp";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        // 打印注入设置
        //System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}

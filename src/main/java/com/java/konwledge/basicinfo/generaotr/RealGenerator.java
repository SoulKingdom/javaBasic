package com.java.konwledge.basicinfo.generaotr;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import com.java.konwledge.basicinfo.util.Func;
import com.java.konwledge.basicinfo.util.StringUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;



public class RealGenerator {


    /**
     * 作者
     */
    private String author;
    /**
     * 代码模块名称
     */
    private String codeName;

    /**
     * 代码所在服务名
     */
    private String serviceName = "";
    /**
     * 代码生成的包名
     */
    private String packageName = "com.neusoft.web.hello.demo";
    /**
     * 代码后端生成的地址
     */
    private String packageDir;
    /**
     * 代码前端生成的地址
     */
    private String packageWebDir;
    /**
     * 需要去掉的表前缀
     */
    private String[] tablePrefix = {"t_security_"};
    /**
     * 需要生成的表名(两者只能取其一)
     */
    private String[] includeTables = {"t_security_blacklist"};
    /**
     * 需要排除的表名(两者只能取其一)
     */
    private String[] excludeTables = {};
    /**
     * 是否包含基础业务字段
     */
    private Boolean hasSuperEntity = Boolean.FALSE;
    /**
     * 是否包含包装器
     */
    private Boolean hasWrapper = Boolean.TRUE;
    /**
     * 基础业务字段
     */
    private String[] superEntityColumns = {"create_time", "create_user", "create_dept", "update_time", "update_user", "status", "is_deleted"};

    /**
     * 是否启用swagger
     */
    private Boolean isSwagger2 = Boolean.TRUE;
    /**
     * 数据库驱动名
     */
    private String driverName;
    /**
     * 数据库链接地址
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;

    public  void run() {
//        Properties props = getProperties();
        AutoGenerator mpg = new AutoGenerator();
        //配置模板信息
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/templates/controller3.java");
        tc.setEntity("/templates/entity.java");
        tc.setMapper("/templates/mapper.java");
        tc.setService("/templates/service3.java");
        tc.setServiceImpl("/templates/serviceImpl3.java");
        mpg.setTemplate(tc);

        GlobalConfig gc = new GlobalConfig();
        String outputDir = getOutputDir();
//        String author = props.getProperty("author");
        gc.setOutputDir(outputDir);
        gc.setAuthor(author);
        gc.setFileOverride(true);
        gc.setOpen(false);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setSwagger2(isSwagger2);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
        String driverName = Func.toStr(this.driverName);
        if (StringUtil.containsAny(driverName, DbType.MYSQL.getDb())) {
            dsc.setDbType(DbType.MYSQL);
            dsc.setTypeConvert(new MySqlTypeConvert());
        } else if (StringUtil.containsAny(driverName, DbType.POSTGRE_SQL.getDb())) {
            dsc.setDbType(DbType.POSTGRE_SQL);
            dsc.setTypeConvert(new PostgreSqlTypeConvert());
        } else {
            dsc.setDbType(DbType.ORACLE);
            dsc.setTypeConvert(new OracleTypeConvert());
        }
        dsc.setDriverName(driverName);
        dsc.setUrl(Func.toStr(this.url));//, props.getProperty("spring.datasource.url")
        dsc.setUsername(Func.toStr(this.username));//, props.getProperty("spring.datasource.username")
        dsc.setPassword(Func.toStr(this.password));//, props.getProperty("spring.datasource.password")
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名
        // strategy.setDbColumnUnderline(true);//全局下划线命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(tablePrefix);
        if (includeTables.length > 0) {
            strategy.setInclude(includeTables);
        }
        if (excludeTables.length > 0) {
            strategy.setExclude(excludeTables);
        }
        if (hasSuperEntity) {
            strategy.setSuperEntityClass("com.neusoft.common.base.SelfBaseEntity");
            strategy.setSuperEntityColumns(superEntityColumns);
            strategy.setSuperServiceClass("com.neusoft.common.base.SelfBaseService");
            strategy.setSuperServiceImplClass("com.neusoft.common.base.SelfBaseServiceImpl");
            strategy.setSuperMapperClass("com.neusoft.common.base.SelfBaseMapper");
        } else {
            strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
            strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        }
        // 自定义 controller 父类
//		strategy.setSuperControllerClass("org.springblade.core.boot.ctrl.BladeController");
        strategy.setEntityBuilderModel(false);
        strategy.setEntityLombokModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        // 控制台扫描
        pc.setModuleName(null);
        pc.setParent(packageName);
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setXml("mapper");
        pc.setMapper("dao");
        mpg.setPackageInfo(pc);
        mpg.setCfg(getInjectionConfig());
        mpg.execute();
    }

    private InjectionConfig getInjectionConfig() {
        String servicePackage = serviceName.split("-").length > 1 ? serviceName.split("-")[1] : serviceName;
        // 自定义配置
        Map<String, Object> map = new HashMap<String, Object>(16);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                map.put("codeName", codeName);
                map.put("serviceName", serviceName);
                map.put("servicePackage", servicePackage);
                map.put("servicePackageLowerCase", servicePackage.toLowerCase());
//                map.put("tenantColumn", tenantColumn);
                map.put("hasWrapper", hasWrapper);
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/sql/menu.sql.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                map.put("entityKey", (tableInfo.getEntityName().toLowerCase()));
                map.put("menuId", IdWorker.getId());
                map.put("addMenuId", IdWorker.getId());
                map.put("editMenuId", IdWorker.getId());
                map.put("removeMenuId", IdWorker.getId());
                map.put("viewMenuId", IdWorker.getId());
                return getOutputDir() + "/" + "/sql/" + tableInfo.getEntityName().toLowerCase() + ".menu.mysql";
            }
        });
        focList.add(new FileOutConfig("/templates/entityVO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "vo" + "/" + tableInfo.getEntityName() + "VO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/entityDTO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "dto" + "/" + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        if (hasWrapper) {
            focList.add(new FileOutConfig("/templates/wrapper2.java.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String wrapperPath = packageName.replace(".", "/") + "/" + "wrapper" + "/" + tableInfo.getEntityName() + "Wrapper" + StringPool.DOT_JAVA;
                    String path = getOutputDir() + "/" + wrapperPath;
                    map.put("wrapperPath",packageName+".wrapper."+tableInfo.getEntityName()+"Wrapper;");
                    return path;
                }
            });
        }
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 获取配置文件
     *
     * @return 配置Props
     */
    private Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("/templates/code.properties");
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * 生成到项目中
     *
     * @return outputDir
     */
    public String getOutputDir() {
        return (Func.isBlank(packageDir) ? System.getProperty("user.dir") + "/demo/develop" : packageDir) + "/src/main/java";
    }

    /**
     * 生成到Web项目中
     *
     * @return outputDir
     */
    public String getOutputWebDir() {
        return (Func.isBlank(packageWebDir) ? System.getProperty("user.dir") : packageWebDir) + "/src";
    }

    /**
     * 页面生成的文件名
     */
    private String getGeneratorViewPath(String viewOutputDir, TableInfo tableInfo, String suffixPath) {
        String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
        String path = viewOutputDir + "/" + name + "/" + name + suffixPath;
        File viewDir = new File(path).getParentFile();
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }
        return path;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDir() {
        return packageDir;
    }

    public void setPackageDir(String packageDir) {
        this.packageDir = packageDir;
    }

    public String getPackageWebDir() {
        return packageWebDir;
    }

    public void setPackageWebDir(String packageWebDir) {
        this.packageWebDir = packageWebDir;
    }

    public String[] getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String[] tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String[] getIncludeTables() {
        return includeTables;
    }

    public void setIncludeTables(String[] includeTables) {
        this.includeTables = includeTables;
    }

    public String[] getExcludeTables() {
        return excludeTables;
    }

    public void setExcludeTables(String[] excludeTables) {
        this.excludeTables = excludeTables;
    }

    public Boolean getHasSuperEntity() {
        return hasSuperEntity;
    }

    public void setHasSuperEntity(Boolean hasSuperEntity) {
        this.hasSuperEntity = hasSuperEntity;
    }

    public Boolean getHasWrapper() {
        return hasWrapper;
    }

    public void setHasWrapper(Boolean hasWrapper) {
        this.hasWrapper = hasWrapper;
    }

    public String[] getSuperEntityColumns() {
        return superEntityColumns;
    }

    public void setSuperEntityColumns(String[] superEntityColumns) {
        this.superEntityColumns = superEntityColumns;
    }


    public Boolean getSwagger2() {
        return isSwagger2;
    }

    public void setSwagger2(Boolean swagger2) {
        isSwagger2 = swagger2;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

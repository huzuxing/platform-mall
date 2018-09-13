import pymysql, os, threading, shutil, datetime, getpass, sys

# 没有参数，抛出异常
if len(sys.argv) < 7:
    raise ValueError("arguments host, port, user, password,db,dbdialect are needed")

host = sys.argv[1]
port = sys.argv[2]
user = sys.argv[3]
password = sys.argv[4]
db = sys.argv[5]
dbdialect = sys.argv[6]
# table 是可选项
table = ""
if len(sys.argv) == 8:
    table = sys.argv[7]

print("db operate arguments: { host : " + host + ". port : " + port + ", user : " + user + ", password : " + password + ", db : " + db)
print("begin handling...")

def getConnection(dbdialect):
    if "mysql" == dbdialect:
        return pymysql.connect(host = host, port = int(port), user = user, password = password, db = db, charset = "utf8mb4", cursorclass = pymysql.cursors.DictCursor);

connection = getConnection(dbdialect)

#获取当前工作目录，并处理成Java包路径格式,目前只是支持maven格式，将Java后面的路径作为包路径
workdir = os.getcwd().strip().split("\\java\\")
package = ""
if len(workdir) >= 2:
    package = workdir[1].replace("\\", ".")

# 根据数据库自动生成Java entity，controller，service，dao

def entity(bean, tableSchema, tableName):
    print(bean + " entity producing begin ...")
    with open(bean + ".java", "w", encoding="UTF-8") as file:
        file.write("package " + package + ".entity;")
        file.write("\n\n\n")
        file.write("/**\n * Auto Created through python on " + str(datetime.datetime.now().date()) + ", author:" + getpass.getuser() + "\n **/\n\n")
        file.write("public class " + bean + "{\n")

        # 根据字段生成属性，以及对应的构造器，getter、setter函数
        # 获取表的字段
        columnSql = "select column_name,column_type, column_comment from information_schema.columns where table_schema ='" + tableSchema + "' and table_name = '" + tableName + "';"
        cursor.execute(columnSql)
        result = cursor.fetchall()
        # 处理字段，Java 采用驼峰命名，若数据库字段属性有“_”，则处理成驼峰命名
        # 构造 填充构造器的参数
        constructorStr = ""
        assignAttr = ""
        # 装载getter 、setter的容器
        getterSetters = []
        for info in result:
            columnName = info["column_name"]  # 字段名
            columnType = info["column_type"]  # 字段类型
            columnComment = info["column_comment"]  # 注释
            # 将带有下划线的字段变为驼峰式
            attrs = columnName.split("_")
            propertyName = ""
            for i, att in enumerate(attrs):
                if i == 0:
                    propertyName += att[0] + att[1:]
                else:
                    propertyName += att[0].upper() + att[1:]
            propertyName = propertyName

            # 处理字段类型
            columnType = columnType.split("(")[0]
            cate = ""
            if "int" == columnType or "tinyint" == columnType or "bigint" == columnType or "smallint" == columnType or "integer" == columnType:
                cate = "Integer"
            elif "double" == columnType:
                cate = "Double"
            elif "varchar" == columnType or "char" == columnType or "text" == columnType or "longtext" == columnType:
                cate = "String"
            # 加入注释
            if "" != columnComment:
                file.write("\n\t")
                file.write("/**\t" + columnComment + "**/")

            if "" != propertyName:
                file.write("\n\t")
                file.write("private " + cate + " " + propertyName + ";")
                file.write("\n")
                # 构造 填充构造器的参数
                constructorStr += cate + " " + propertyName + ","
                assignAttr += "\t\tthis." + propertyName + " = " + propertyName + ";\n"
                getOrSetP = propertyName[0].upper() + propertyName[1:]
                # 构造setter方法
                setterInfo = "public void set" + getOrSetP + "(" + cate + " " + propertyName + ") {\n";
                setterInfo += "\t\t this." + propertyName + " = " + propertyName + ";\n\t}"
                getterSetters.append(setterInfo)
                # 构造getter方法
                getterInfo = "public " + cate + " get" + getOrSetP + "() {\n";
                getterInfo += "\t\t return this." + propertyName + ";\n\t}"
                getterSetters.append(getterInfo)

        constructorStr = constructorStr.strip()[:-1]  # 去掉最后一个“,”
        # 空构造方法
        file.write("\n\t")
        file.write("public " + bean + "() {}")
        file.write("\n")
        # 带有参数的构造方法
        file.write("\n\t")
        file.write("public " + bean + "(" + constructorStr + ") {")
        file.write("\n")
        file.write(assignAttr)
        file.write("\t}")
        for setter in getterSetters:
            file.write("\n\t")
            file.write(setter)
        file.write("\n}")
    # 写完文件，归类到entity中
    shutil.move(bean + ".java", "entity/")
    print(bean + " entity producing finished ...")
# 生成controller

def controller(bean):
    print(bean + " controller producing finished ...")
    with open(bean + "Controller.java", "w", encoding="UTF-8") as file:
        file.write("package " + package + ".controller;")
        file.write("\n\n\n")
        # 生成import
        file.write("import " + package + ".common.Constant;\n")
        file.write("import " + package + ".entity." + bean + ";\n")
        file.write("import " + package + ".service." + bean + "Service;\n")
        file.write("import org.springframework.web.bind.annotation.RequestMapping;\n")
        file.write("import org.springframework.web.bind.annotation.RequestMethod;\n")
        file.write("import org.springframework.web.bind.annotation.RestController;\n")
        file.write("import org.springframework.web.context.request.async.WebAsyncTask;\n")
        file.write("\n\n\n")
        file.write("import javax.servlet.http.HttpServletRequest;\n")
        file.write("import javax.annotation.Resource;\n")
        file.write("import java.util.concurrent.Callable;\n")
        file.write("\n\n\n")
        file.write("/**\n * Auto Created through python on " + str(datetime.datetime.now().date()) + ", author:" + getpass.getuser() + " \n **/\n\n")
        file.write("@RestController\n")
        file.write("@RequestMapping(\"/api/"+ bean.lower() +"\")\n")
        file.write("public class " + bean + "Controller {\n")

        # 生成findList方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件获取list列表信息 \n \t**/\n")
        file.write("\t@RequestMapping(value = \"/findList\", method = RequestMethod.POST)\n")
        file.write("\tpublic WebAsyncTask<String> findList(final " + bean + " bean, HttpServletRequest request) {")
        file.write("\n")
        file.write("\t\tCallable callable = () -> {\n")
        file.write("\n\t\t\treturn null;")
        file.write("\n\t\t};")

        file.write("\n")
        file.write("\t\treturn new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);")
        file.write("\n\t}")
        # 生成findPage方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件获取分页数据 \n \t**/\n")
        file.write("\t@RequestMapping(value = \"/findPage\", method = RequestMethod.POST)\n")
        file.write("\tpublic WebAsyncTask<String> findPage(final  " + bean + " bean,Integer page,Integer rows, HttpServletRequest request) {")
        file.write("\n")
        file.write("\t\tCallable callable = () -> {\n")
        file.write("\n\t\t\treturn null;")
        file.write("\n\t\t};")

        file.write("\n")
        file.write("\t\treturn new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);")
        file.write("\n\t}")

        # 生成add方法
        file.write("\n")
        file.write("\t/**\n \t * 新增数据接口 \n \t**/\n")
        file.write("\t@RequestMapping(value = \"/add\", method = RequestMethod.POST)\n")
        file.write(
            "\tpublic WebAsyncTask<String> add(final " + bean + " bean) {")
        file.write("\n")
        file.write("\t\tCallable callable = () -> {\n")
        file.write("\n\t\t\treturn null;")
        file.write("\n\t\t};")

        file.write("\n")
        file.write("\t\treturn new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);")
        file.write("\n\t}")

        # 生成update方法
        file.write("\n")
        file.write("\t/**\n \t * 更新数据 \n \t**/\n")
        file.write("\t@RequestMapping(value = \"/update\", method = RequestMethod.POST)\n")
        file.write(
            "\tpublic WebAsyncTask<String> update(final " + bean + " bean) {")
        file.write("\n")
        file.write("\t\tCallable callable = () -> {\n")
        file.write("\n\t\t\treturn null;")
        file.write("\n\t\t};")

        file.write("\n")
        file.write("\t\treturn new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);")
        file.write("\n\t}")

        # 生成findById方法
        file.write("\n")
        file.write("\t/**\n \t * 根据ID获取数据，需要参数校验 \n \t**/\n")
        file.write("\t@RequestMapping(value = \"/findById\", method = RequestMethod.POST)\n")
        file.write(
            "\tpublic WebAsyncTask<String> findById(final " + bean + " bean) {")
        file.write("\n")
        file.write("\t\tCallable callable = () -> {\n")
        file.write("\n\t\t\treturn null;")
        file.write("\n\t\t};")

        file.write("\n")
        file.write("\t\treturn new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);")
        file.write("\n\t}")

        # 生成delete方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件删除数据 \n \t**/\n")
        file.write("\t@RequestMapping(value = \"/delete\", method = RequestMethod.POST)\n")
        file.write(
            "\tpublic WebAsyncTask<String> delete(final " + bean + " bean) {")
        file.write("\n")
        file.write("\t\tCallable callable = () -> {\n")
        file.write("\n\t\t\treturn null;")
        file.write("\n\t\t};")

        file.write("\n")
        file.write("\t\treturn new WebAsyncTask<String>(Constant.REQUEST_TIMEOUT_MILLISECOND, callable);")
        file.write("\n\t}")

        # 导入依赖
        file.write("\n")
        file.write("\t@Resource\n")
        file.write("\tprivate " + bean + "Service " + bean[0].lower() + bean[1:] + "Service;\n")
        file.write("\n}")
    # 写完文件，将所有controller移到controller文件夹下
    shutil.move(bean + "Controller.java", "controller/")
    print(bean + " controller producing finished ...")

# 生成service，包括接口已经对应的实现

def service(bean):
    print(bean + " service producing begin ...")
    # service接口
    with open(bean + "Service.java", "w", encoding="UTF-8") as file:
        file.write("package " + package + ".service;")
        file.write("\n\n\n")
        file.write("import " + package + ".entity." + bean + ";\n")
        file.write("import java.util.List;")
        file.write("\n\n\n")
        file.write("/**\n * Auto Created through python on " + str(datetime.datetime.now().date()) + ", author:" + getpass.getuser() + " \n **/\n\n")
        file.write("public interface " + bean + "Service {\n")

        # 生成findList方法
        file.write("\n")
        file.write("\tList<" + bean +"> findList(" + bean +" bean);")
        file.write("\n")
        # 生成findPage方法
        file.write("\n")
        file.write("\tList<" + bean + "> findPage(" + bean + " bean, Integer page, Integer row);")
        file.write("\n")
        # 生成add方法
        file.write("\n")
        file.write("\t" + bean + " add(" + bean + " bean);")
        file.write("\n")
        # 生成update方法
        file.write("\n")
        file.write("\t" + bean + " update(" + bean + " bean);")
        file.write("\n")
        # 生成findById方法
        file.write("\n")
        file.write("\t" + bean + " findById(" + bean + " bean);")
        file.write("\n")
        # 生成delete方法
        file.write("\n")
        file.write("\t" + bean + " delete(" + bean + " bean);")
        file.write("\n")
        # 生成批量保存方法
        file.write("\n")
        file.write("\tboolean batchSave(List<" + bean + "> bean);")
        file.write("\n")

        # 生成批量更新方法
        file.write("\n")
        file.write("\tboolean batchUpdate(List<" + bean + "> bean);")
        file.write("\n")

        # 生成批量删除方法
        file.write("\n")
        file.write("\tboolean batchDelete(List<" + bean + "> bean);")
        file.write("\n")

        file.write("\n}")
    # 写完文件，将所有service 接口移到service根目录文件夹下
    shutil.move(bean + "Service.java", "service/")

    # service 实现
    with open(bean + "ServiceImpl.java", "w", encoding="UTF-8") as file:
        file.write("package " + package + ".service.impl;")
        file.write("\n\n\n")
        file.write("import " + package + ".entity." + bean + ";\n")
        file.write("import " + package + ".service." + bean + "Service;\n")
        file.write("import " + package + ".dao." + bean + "Dao;\n")
        file.write("import org.springframework.stereotype.Service;\n")
        file.write("import javax.annotation.Resource;\n")
        file.write("import java.util.List;")
        file.write("\n\n\n")
        file.write("/**\n * Auto Created through python on " + str(datetime.datetime.now().date()) + ", author:" + getpass.getuser() + " \n **/\n\n")
        serviceName = bean[0].lower() + bean[1:]
        file.write("@Service(\"" + serviceName + "Service\")\n")
        file.write("public class " + bean + "ServiceImpl implements " + bean + "Service {\n")

        # 生成findList方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件获取list列表信息 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic List<" + bean + "> findList(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")
        # 生成findPage方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件获取分页数据 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic List<" + bean + "> findPage(final " + bean + " bean, Integer page, Integer rows) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成add方法
        file.write("\n")
        file.write("\t/**\n \t * 新增数据接口 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " add(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成update方法
        file.write("\n")
        file.write("\t/**\n \t * 更新数据 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " update(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成findById方法
        file.write("\n")
        file.write("\t/**\n \t * 根据ID获取数据，需要参数校验 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " findById(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成delete方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件删除数据 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " delete(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成批量保存方法
        file.write("\n")
        file.write("\t/**\n \t * 批量保存 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic boolean batchSave(List<" + bean + "> bean) {\n")
        file.write("\n")
        file.write("\t\treturn false;")
        file.write("\n\t}")

        # 生成批量更新方法
        file.write("\n")
        file.write("\t/**\n \t * 批量更新 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic boolean batchUpdate(List<" + bean + "> bean) {\n")
        file.write("\n")
        file.write("\t\treturn false;")
        file.write("\n\t}")

        # 生成批量删除方法
        file.write("\n")
        file.write("\t/**\n \t * 批量删除 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic boolean batchDelete(List<" + bean + "> bean) {\n")
        file.write("\n")
        file.write("\t\treturn false;")
        file.write("\n\t}")

        # 导入依赖
        file.write("\n")
        file.write("\t@Resource\n")
        file.write("\tprivate " + bean +"Dao " + bean[0].lower() + bean[1:] +"Dao;\n")

        file.write("\n}")
    # 写完文件，归档文件
    shutil.move(bean + "ServiceImpl.java", "service/impl/")
    print(bean + " service producing finished ...")

# 生成dao

def dao(bean):
    print(bean + " dao producing begin ...")
    # dao接口
    with open(bean + "Dao.java", "w", encoding="UTF-8") as file:
        file.write("package " + package + ".dao;")
        file.write("\n\n\n")
        file.write("import " + package + ".entity." + bean + ";\n")
        file.write("import java.util.List;")
        file.write("\n\n\n")
        file.write("/**\n * Auto Created through python on " + str(datetime.datetime.now().date()) + ", author:" + getpass.getuser() + " \n **/\n\n")
        file.write("public interface " + bean + "Dao {\n")

        # 生成findList方法
        file.write("\n")
        file.write("\tList<" + bean + "> findList(" + bean + " bean);")
        file.write("\n")
        # 生成findPage方法
        file.write("\n")
        file.write("\tList<" + bean + "> findPage(" + bean + " bean, Integer page, Integer row);")
        file.write("\n")
        # 生成add方法
        file.write("\n")
        file.write("\t" + bean + " save(" + bean + " bean);")
        file.write("\n")
        # 生成update方法
        file.write("\n")
        file.write("\t" + bean + " update(" + bean + " bean);")
        file.write("\n")
        # 生成findById方法
        file.write("\n")
        file.write("\t" + bean + " findById(" + bean + " bean);")
        file.write("\n")
        # 生成delete方法
        file.write("\n")
        file.write("\t" + bean + " delete(" + bean + " bean);")
        file.write("\n")
        # 生成批量保存方法
        file.write("\n")
        file.write("\tboolean batchSave(List<" + bean + "> bean);")
        file.write("\n")

        # 生成批量更新方法
        file.write("\n")
        file.write("\tboolean batchUpdate(List<" + bean + "> bean);")
        file.write("\n")

        # 生成批量删除方法
        file.write("\n")
        file.write("\tboolean batchDelete(List<" + bean + "> bean);")
        file.write("\n")

        file.write("\n}")
    # 写完文件，将所有service 接口移到service根目录文件夹下
    shutil.move(bean + "Dao.java", "dao/")

    # dao 实现
    with open(bean + "DaoImpl.java", "w", encoding="UTF-8") as file:
        file.write("package " + package + ".dao.impl;")
        file.write("\n\n\n")
        file.write("import " + package + ".entity." + bean + ";\n")
        file.write("import " + package + ".dao." + bean + "Dao;\n")
        file.write("import org.springframework.stereotype.Repository;\n")
        file.write("import java.util.List;")
        file.write("\n\n\n")
        file.write("/**\n * Auto Created through python on " + str(datetime.datetime.now().date()) + ", author:" + getpass.getuser() + " \n **/\n\n")
        serviceName = bean[0].lower() + bean[1:]
        file.write("@Repository(\"" + serviceName + "Dao\")\n")
        file.write("public class " + bean + "DaoImpl implements " + bean + "Dao {\n")

        # 生成findList方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件获取list列表信息 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic List<" + bean + "> findList(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")
        # 生成findPage方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件获取分页数据 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic List<" + bean + "> findPage(final " + bean + " bean, Integer page, Integer rows) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成add方法
        file.write("\n")
        file.write("\t/**\n \t * 新增数据接口 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " save(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成update方法
        file.write("\n")
        file.write("\t/**\n \t * 更新数据 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " update(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成findById方法
        file.write("\n")
        file.write("\t/**\n \t * 根据ID获取数据，需要参数校验 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " findById(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成delete方法
        file.write("\n")
        file.write("\t/**\n \t * 根据条件删除数据 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic " + bean + " delete(final " + bean + " bean) {\n")
        file.write("\n")
        file.write("\t\treturn null;")
        file.write("\n\t}")

        # 生成批量保存方法
        file.write("\n")
        file.write("\t/**\n \t * 批量保存 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic boolean batchSave(List<" + bean + "> bean) {\n")
        file.write("\n")
        file.write("\t\treturn false;")
        file.write("\n\t}")

        # 生成批量更新方法
        file.write("\n")
        file.write("\t/**\n \t * 批量更新 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic boolean batchUpdate(List<" + bean + "> bean) {\n")
        file.write("\n")
        file.write("\t\treturn false;")
        file.write("\n\t}")

        # 生成批量删除方法
        file.write("\n")
        file.write("\t/**\n \t * 批量删除 \n \t**/\n")
        file.write("\t@Override\n")
        file.write("\tpublic boolean batchDelete(List<" + bean + "> bean) {\n")
        file.write("\n")
        file.write("\t\treturn false;")
        file.write("\n\t}")

        file.write("\n}")
    # 写完文件，将所有controller移到controller文件夹下
    shutil.move(bean + "DaoImpl.java", "dao/impl/")
    print(bean + " dao producing finished ...")

# 创建目录
def generatedir():
    mkdir("entity")
    mkdir("controller")
    mkdir("service")
    mkdir("service/impl")
    mkdir("dao")
    mkdir("dao/impl")

# 当文件夹存在时，只需要删除其中得文件，否则新建文件夹就行
def mkdir(dir):
    if "" == dir:
        return
    if os.path.exists(dir):
        for d in os.listdir(dir):
            filePath = os.path.join(dir, d)
            if (os.path.isfile(filePath)):
                os.remove(filePath)
            else:
                mkdir(filePath)
    else:
        os.mkdir(dir)

try:
    with connection.cursor() as cursor:

        tables = []

        # 当指定了表名，说明只需要生成某个表的代码
        if "" != table:
            t = {"table_name" : table}
            tables.append(t)
        else:
            # 获取指定数据库的所有表名
            tableSql = "SELECT table_name FROM information_schema.`TABLES` WHERE TABLE_SCHEMA = '" + db + "'"
            cursor.execute(tableSql)
            tables = cursor.fetchall()
        # 创建文件夹
        generatedir()
        for t in tables:
            table = t["table_name"]
            # 将表名首字母大写，作为Java实体bean名称,生成Java文件
            bean = ""
            # 若表名中包含下划线，则转化为驼峰命名方式
            nameStrs = table.split("_")
            for s in nameStrs:
                bean += s[0].upper() + s[1:]

            # 开启一个线程去生成实体bean代码
            entityThread = threading.Thread(target=entity(bean, db, table), name="entityThread")
            entityThread.start()

            # 开启一个线程去生成controller代码
            controllerThread = threading.Thread(target=controller(bean), name="controllerThread")
            controllerThread.start()

            # 开启一个线程去生成实体service代码
            serviceThread = threading.Thread(target=service(bean), name="serviceThread")
            serviceThread.start()

            # 开启一个线程去生成实体dao代码
            daoThread = threading.Thread(target=dao(bean), name="daoThread")
            daoThread.start()

    connection.commit()

finally:
    connection.close()

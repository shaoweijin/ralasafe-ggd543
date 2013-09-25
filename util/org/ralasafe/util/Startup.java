/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ralasafe.SystemConstant;
import org.ralasafe.db.DBPower;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Startup {
    private static boolean started = false;
    private static final Log LOG = LogFactory.getLog(Startup.class);

    public static void startup(String datasourceDir, String repositoryDir) {
        if (started) {
            return;
        }

        try {
            innerStart(datasourceDir, repositoryDir);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

        started = true;
    }

    private static void innerStart(String datasourceDir, String repositoryDir) throws IOException {
        assert !StringUtil.isEmpty(datasourceDir);
        assert !StringUtil.isEmpty(repositoryDir);

        String datasourcePath = new File(datasourceDir).getCanonicalPath();
        String repositoryPath = new File(repositoryDir).getCanonicalPath();

        //PropertyConfigurator.configure(webinfoDir + "ralasafe/log4j.properties");
        Map map = new HashMap();
        map.put(DBPower.BASE_CONFIG_DIR_MAP_KEY, datasourcePath + "/");
        map.put(DBPower.DATASOURCES_CONFIG_FILE_MAP_KEY, "datasources.xml");
        DBPower.on(map);

        File businessDataStoreDir = new File(repositoryPath, "ralasafe/businessData/");
        File queryStoreDir = new File(repositoryPath, "ralasafe/query/");
        File userCategoryStoreDir = new File(repositoryDir, "ralasafe/userCategory/");
        File userTypeStoreDir = new File(repositoryDir, "ralasafe/userType/");

        businessDataStoreDir.mkdirs();
        queryStoreDir.mkdirs();
        userCategoryStoreDir.mkdirs();
        userTypeStoreDir.mkdirs();

        SystemConstant.setRepositoryDir(repositoryPath + "/");
        SystemConstant.setBusinessDataStoreDir(businessDataStoreDir.getCanonicalPath() + "/");
        SystemConstant.setQueryStoreDir(queryStoreDir.getCanonicalPath() + "/");
        SystemConstant.setUserCategoryStoreDir(userCategoryStoreDir.getCanonicalPath() + "/");
        SystemConstant.setUserTypeStoreDir(userTypeStoreDir.getCanonicalPath() + "/");
    }
}

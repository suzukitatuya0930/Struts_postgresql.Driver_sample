package mailreader2;

import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import junit.framework.TestCase;

import javax.sql.DataSource;
import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Ted Husted
 * @version $Revision: 1.0 $ $Date: Jul 29, 2006 4:59:19 PM $
 */
public class BaseSqlMapTest extends TestCase {

    protected static SqlMapClient sqlMap;

    protected static void initSqlMap(String configFile, Properties props) throws Exception {
        Reader reader = Resources.getResourceAsReader(configFile);
        sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader, props);
        reader.close();
    }

    protected static void initScript(String script) throws Exception {
        DataSource ds = sqlMap.getDataSource();

        Connection conn = ds.getConnection();

        Reader reader = Resources.getResourceAsReader(script);

        ScriptRunner runner = new ScriptRunner(conn, false, false);
        runner.setLogWriter(null);
        runner.setErrorLogWriter(null);

        runner.runScript(reader);
        conn.commit();
        conn.close();
        reader.close();
    }


    protected void setUp() throws Exception {
        if (sqlMap==null) {
            initSqlMap("sql-map-config.xml", null);
            initScript("sql/mailreader-schema.sql");
            initScript("sql/mailreader-sample.sql");
        }
    }

    protected void tearDown() throws Exception {
    }

    public void testInit() throws Exception {
        assertNotNull(sqlMap);
    }
}

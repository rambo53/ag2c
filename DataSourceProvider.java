package core;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 *
 * @author user
 */
public class DataSourceProvider {
    
    private static BasicDataSource singleDataSource;
    
    public static DataSource getSingleDataSourceInstance(){
        if(singleDataSource==null){
           singleDataSource=new BasicDataSource();
           singleDataSource.setInitialSize(5);
           singleDataSource.setUrl("jdbc:mysql://localhost:3306/materiaux?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
           singleDataSource.setUsername("root");
           singleDataSource.setPassword("Rambo666");
        }
        return singleDataSource;
    }
}

package sample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @Author hhbk
 */
public class HibernateManager
{
    private static HibernateManager hibernateutility = null;

    private Configuration configuration = null;

    private SessionFactory sessionfactory = null;

    private String dbname = "";

    /**
     *
     */
    private HibernateManager()
    {
        this.configuration = new Configuration();
    }

    /**
     *
     * @return
     */
    public static HibernateManager getInstance()
    {
        if(hibernateutility == null)
        {
            hibernateutility = new HibernateManager();
        }
        return hibernateutility;
    }

    /**
     *
     * @param dbname
     */
    public void setDbname(String dbname)
    {
        this.dbname = dbname;
    }

    /**
     *
     * @param annotatedclass
     */
    public void addAnnotatedClass(Class annotatedclass)
    {
        this.configuration
                .addAnnotatedClass(annotatedclass);
    }
    /**
     *
     * @return
     */
    public Session getNewSession()
    {
        return  this.sessionfactory
                .openSession();
    }

    /**
     *
     //     * @throws HardwareException
     */
    public void buildSessionFactory()
            throws DBconException
    {
        this.setProperties();

        try
        {
            if(this.sessionfactory == null)
            {
                ServiceRegistry serviceregistry = null;

                serviceregistry =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                                .build();
                this.sessionfactory = configuration.buildSessionFactory(serviceregistry);
            }
            else
            {
                throw new DBconException("SessionFactory existiert schon!");
            }
        }
        catch(Exception e)
        {
            throw new DBconException("SessionFactory konnte nicht erzeugt " +
                    "werden!");
        }

    }

    /**
     *
     */
    public void shutDown()
    {
        if(this.sessionfactory != null)
        {
            this.sessionfactory
                    .close();
            this.sessionfactory = null;
        }
    }

    /**
     *
     */
    private void setProperties()
    {
		/*
		=========== CREATE OR UPDATE ? =========================================
		*/
        this.configuration
                .setProperty("hibernate.hbm2ddl.auto",
                        "create");
		/*
		========================================================================
		*/

        this.configuration
                .setProperty("hibernate.connection.username",
                        "root");
        this.configuration
                .setProperty("hibernate.connection.password",
                        "");
        this.configuration
                .setProperty("hibernate.connection.url",
                        "jdbc:mysql://localhost:3306/" + dbname +
                                "?useLegacyDatetimeCode=false&serverTimezone" +
                                "=Europe/Amsterdam");
//        jdbc:mysql://localhost:3306/?serverTimezone=CET#
        this.configuration
                .setProperty("hibernate.connection.driver_class",
                        "com.mysql.cj.jdbc.Driver");
        this.configuration
                .setProperty("hibernate.dialect",
                        "org.hibernate.dialect.MySQL5Dialect");
        this.configuration
                .setProperty("show_sql",
                        "true");
        this.configuration.setProperty("format_sql",
                "true");
        this.configuration
                .setProperty("use_sql_comments",
                        "true");
        this.configuration
                .setProperty("hibernate.show_sql",
                        "true");
        this.configuration
                .setProperty("hibernate.format_sql",
                        "true");
        this.configuration
                .setProperty("hibernate.use_sql_comments",
                        "true");
        this.configuration
                .setProperty("hibernate.default_schema",
                        "public");
    }
}
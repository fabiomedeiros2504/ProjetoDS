package br.com.stefaninids.projetods.dao;

import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.sql.ConnectionPoolDataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.PooledDataSource;

import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

public class DSComboPooledDataSource implements PooledDataSource {
	
	private Logger logger = ProjetoDSLogger.getDAO();
	
	private ComboPooledDataSource dataSource;
	
	public DSComboPooledDataSource() {
		super();
	}
	
	public void init() throws PropertyVetoException {
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("net.sourceforge.jtds.jdbc.Driver");			
		} catch (PropertyVetoException e) {
			String msg = "Erro ao setar o driver do DataSource, " + e.getMessage();
			logger.log(Level.ERROR, msg);
			
			throw e;
		}
		
		dataSource.setJdbcUrl("jdbc:jtds:sqlserver://localhost;databaseName=DS_TESTE;=SQLEXPRESS;");		
		dataSource.setUser("sa");
		dataSource.setPassword("123456");
		dataSource.setAcquireIncrement(1);
		dataSource.setMinPoolSize(1);
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(30);		
	}
	
	public void close() {
		if (dataSource != null) {
			dataSource.close();
		}
	}
	
	public ComboPooledDataSource getComboPooledDataSource() {
		return dataSource;
	}
	
	
	public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
		this.dataSource = comboPooledDataSource;
	}
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return dataSource.getLogWriter();
	}
	
	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		dataSource.setLogWriter(out);
	}
	
	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		dataSource.setLoginTimeout(seconds);
	}
	
	@Override
	public int getLoginTimeout() throws SQLException {
		return dataSource.getLoginTimeout();
	}
	
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return dataSource.unwrap(iface);
	}
	
	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return dataSource.isWrapperFor(iface);
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return dataSource.getConnection(username, password);
	}
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		dataSource.addPropertyChangeListener(pcl);
	}
	
	public void addPropertyChangeListener(String propName,
			PropertyChangeListener pcl) {
		dataSource.addPropertyChangeListener(propName, pcl);
	}
	
	public void addVetoableChangeListener(VetoableChangeListener vcl) {
		dataSource.addVetoableChangeListener(vcl);
	}
	
	@SuppressWarnings("deprecation")
	public void close(boolean force_destroy) {
		dataSource.close(force_destroy);
	}
	
	public boolean equals(Object o) {
		return dataSource.equals(o);
	}
	
	public int getAcquireIncrement() {
		return dataSource.getAcquireIncrement();
	}
	
	public int getAcquireRetryAttempts() {
		return dataSource.getAcquireRetryAttempts();
	}
	
	public int getAcquireRetryDelay() {
		return dataSource.getAcquireRetryDelay();
	}
	
	@SuppressWarnings("rawtypes")
	public Collection getAllUsers() throws SQLException {
		return dataSource.getAllUsers();
	}
	
	public String getAutomaticTestTable() {
		return dataSource.getAutomaticTestTable();
	}
	
	public int getCheckoutTimeout() {
		return dataSource.getCheckoutTimeout();
	}
	
	public String getConnectionCustomizerClassName() {
		return dataSource.getConnectionCustomizerClassName();
	}
	
	public ConnectionPoolDataSource getConnectionPoolDataSource() {
		return dataSource.getConnectionPoolDataSource();
	}
	
	public String getConnectionTesterClassName() {
		return dataSource.getConnectionTesterClassName();
	}
	
	public String getDataSourceName() {
		return dataSource.getDataSourceName();
	}
	
	public String getDescription() {
		return dataSource.getDescription();
	}
	
	public String getDriverClass() {
		return dataSource.getDriverClass();
	}
	
	public float getEffectivePropertyCycle(String username, String password)
			throws SQLException {
		return dataSource.getEffectivePropertyCycle(username, password);
	}
	
	public float getEffectivePropertyCycleDefaultUser() throws SQLException {
		return dataSource.getEffectivePropertyCycleDefaultUser();
	}
	
	public String getFactoryClassLocation() {
		return dataSource.getFactoryClassLocation();
	}
	
	public String getIdentityToken() {
		return dataSource.getIdentityToken();
	}
	
	public int getIdleConnectionTestPeriod() {
		return dataSource.getIdleConnectionTestPeriod();
	}
	
	public int getInitialPoolSize() {
		return dataSource.getInitialPoolSize();
	}
	
	public String getJdbcUrl() {
		return dataSource.getJdbcUrl();
	}
	
	public Throwable getLastAcquisitionFailure(String username, String password)
			throws SQLException {
		return dataSource.getLastAcquisitionFailure(username, password);
	}
	
	public Throwable getLastAcquisitionFailureDefaultUser() throws SQLException {
		return dataSource.getLastAcquisitionFailureDefaultUser();
	}
	
	public Throwable getLastCheckinFailure(String username, String password)
			throws SQLException {
		return dataSource.getLastCheckinFailure(username, password);
	}
	
	public Throwable getLastCheckinFailureDefaultUser() throws SQLException {
		return dataSource.getLastCheckinFailureDefaultUser();
	}
	
	public Throwable getLastCheckoutFailure(String username, String password)
			throws SQLException {
		return dataSource.getLastCheckoutFailure(username, password);
	}
	
	public Throwable getLastCheckoutFailureDefaultUser() throws SQLException {
		return dataSource.getLastCheckoutFailureDefaultUser();
	}
	
	public Throwable getLastConnectionTestFailure(String username,
			String password) throws SQLException {
		return dataSource.getLastConnectionTestFailure(username, password);
	}
	
	public Throwable getLastConnectionTestFailureDefaultUser()
			throws SQLException {
		return dataSource.getLastConnectionTestFailureDefaultUser();
	}
	
	public Throwable getLastIdleTestFailure(String username, String password)
			throws SQLException {
		return dataSource.getLastIdleTestFailure(username, password);
	}
	
	public Throwable getLastIdleTestFailureDefaultUser() throws SQLException {
		return dataSource.getLastIdleTestFailureDefaultUser();
	}
	
	public int getMaxAdministrativeTaskTime() {
		return dataSource.getMaxAdministrativeTaskTime();
	}
	
	public int getMaxConnectionAge() {
		return dataSource.getMaxConnectionAge();
	}
	
	public int getMaxIdleTime() {
		return dataSource.getMaxIdleTime();
	}
	
	public int getMaxIdleTimeExcessConnections() {
		return dataSource.getMaxIdleTimeExcessConnections();
	}
	
	public int getMaxPoolSize() {
		return dataSource.getMaxPoolSize();
	}
	
	public int getMaxStatements() {
		return dataSource.getMaxStatements();
	}
	
	public int getMaxStatementsPerConnection() {
		return dataSource.getMaxStatementsPerConnection();
	}
	
	public int getMinPoolSize() {
		return dataSource.getMinPoolSize();
	}
	
	public int getNumBusyConnections() throws SQLException {
		return dataSource.getNumBusyConnections();
	}
	
	public int getNumBusyConnections(String username, String password)
			throws SQLException {
		return dataSource.getNumBusyConnections(username, password);
	}
	
	public int getNumBusyConnectionsAllUsers() throws SQLException {
		return dataSource.getNumBusyConnectionsAllUsers();
	}
	
	public int getNumBusyConnectionsDefaultUser() throws SQLException {
		return dataSource.getNumBusyConnectionsDefaultUser();
	}
	
	public int getNumConnections() throws SQLException {
		return dataSource.getNumConnections();
	}
	
	public int getNumConnections(String username, String password)
			throws SQLException {
		return dataSource.getNumConnections(username, password);
	}
	
	public int getNumConnectionsAllUsers() throws SQLException {
		return dataSource.getNumConnectionsAllUsers();
	}
	
	public int getNumConnectionsDefaultUser() throws SQLException {
		return dataSource.getNumConnectionsDefaultUser();
	}
	
	public long getNumFailedCheckins(String username, String password)
			throws SQLException {
		return dataSource.getNumFailedCheckins(username, password);
	}
	
	public long getNumFailedCheckinsDefaultUser() throws SQLException {
		return dataSource.getNumFailedCheckinsDefaultUser();
	}
	
	public long getNumFailedCheckouts(String username, String password)
			throws SQLException {
		return dataSource.getNumFailedCheckouts(username, password);
	}
	
	public long getNumFailedCheckoutsDefaultUser() throws SQLException {
		return dataSource.getNumFailedCheckoutsDefaultUser();
	}
	
	public long getNumFailedIdleTests(String username, String password)
			throws SQLException {
		return dataSource.getNumFailedIdleTests(username, password);
	}
	
	public long getNumFailedIdleTestsDefaultUser() throws SQLException {
		return dataSource.getNumFailedIdleTestsDefaultUser();
	}
	
	public int getNumHelperThreads() {
		return dataSource.getNumHelperThreads();
	}
	
	public int getNumIdleConnections() throws SQLException {
		return dataSource.getNumIdleConnections();
	}
	
	public int getNumIdleConnections(String username, String password)
			throws SQLException {
		return dataSource.getNumIdleConnections(username, password);
	}
	
	public int getNumIdleConnectionsAllUsers() throws SQLException {
		return dataSource.getNumIdleConnectionsAllUsers();
	}
	
	public int getNumIdleConnectionsDefaultUser() throws SQLException {
		return dataSource.getNumIdleConnectionsDefaultUser();
	}
	
	public int getNumThreadsAwaitingCheckout(String username, String password)
			throws SQLException {
		return dataSource.getNumThreadsAwaitingCheckout(username, password);
	}
	
	public int getNumThreadsAwaitingCheckoutDefaultUser() throws SQLException {
		return dataSource.getNumThreadsAwaitingCheckoutDefaultUser();
	}
	
	public int getNumUnclosedOrphanedConnections() throws SQLException {
		return dataSource.getNumUnclosedOrphanedConnections();
	}
	
	public int getNumUnclosedOrphanedConnections(String username,
			String password) throws SQLException {
		return dataSource.getNumUnclosedOrphanedConnections(username, password);
	}
	
	public int getNumUnclosedOrphanedConnectionsAllUsers() throws SQLException {
		return dataSource.getNumUnclosedOrphanedConnectionsAllUsers();
	}
	
	public int getNumUnclosedOrphanedConnectionsDefaultUser()
			throws SQLException {
		return dataSource.getNumUnclosedOrphanedConnectionsDefaultUser();
	}
	
	public int getNumUserPools() throws SQLException {
		return dataSource.getNumUserPools();
	}
	
	public String getOverrideDefaultPassword() {
		return dataSource.getOverrideDefaultPassword();
	}
	
	public String getOverrideDefaultUser() {
		return dataSource.getOverrideDefaultUser();
	}
	
	public String getPassword() {
		return dataSource.getPassword();
	}
	
	public String getPreferredTestQuery() {
		return dataSource.getPreferredTestQuery();
	}
	
	public Properties getProperties() {
		return dataSource.getProperties();
	}
	
	public int getPropertyCycle() {
		return dataSource.getPropertyCycle();
	}
	
	public Reference getReference() throws NamingException {
		return dataSource.getReference();
	}
	
	public long getStartTimeMillis(String username, String password)
			throws SQLException {
		return dataSource.getStartTimeMillis(username, password);
	}
	
	public long getStartTimeMillisDefaultUser() throws SQLException {
		return dataSource.getStartTimeMillisDefaultUser();
	}
	
	public int getStatementCacheNumCheckedOut(String username, String password)
			throws SQLException {
		return dataSource.getStatementCacheNumCheckedOut(username, password);
	}
	
	public int getStatementCacheNumCheckedOutDefaultUser() throws SQLException {
		return dataSource.getStatementCacheNumCheckedOutDefaultUser();
	}
	
	public int getStatementCacheNumCheckedOutStatementsAllUsers()
			throws SQLException {
		return dataSource.getStatementCacheNumCheckedOutStatementsAllUsers();
	}
	
	public int getStatementCacheNumConnectionsWithCachedStatements(
			String username, String password) throws SQLException {
		return dataSource.getStatementCacheNumConnectionsWithCachedStatements(
				username, password);
	}
	
	public int getStatementCacheNumConnectionsWithCachedStatementsAllUsers()
			throws SQLException {
		return dataSource
				.getStatementCacheNumConnectionsWithCachedStatementsAllUsers();
	}
	
	public int getStatementCacheNumConnectionsWithCachedStatementsDefaultUser()
			throws SQLException {
		return dataSource
				.getStatementCacheNumConnectionsWithCachedStatementsDefaultUser();
	}
	
	public int getStatementCacheNumStatements(String username, String password)
			throws SQLException {
		return dataSource.getStatementCacheNumStatements(username, password);
	}
	
	public int getStatementCacheNumStatementsAllUsers() throws SQLException {
		return dataSource.getStatementCacheNumStatementsAllUsers();
	}
	
	public int getStatementCacheNumStatementsDefaultUser() throws SQLException {
		return dataSource.getStatementCacheNumStatementsDefaultUser();
	}
	
	public int getThreadPoolNumActiveThreads() throws SQLException {
		return dataSource.getThreadPoolNumActiveThreads();
	}
	
	public int getThreadPoolNumIdleThreads() throws SQLException {
		return dataSource.getThreadPoolNumIdleThreads();
	}
	
	public int getThreadPoolNumTasksPending() throws SQLException {
		return dataSource.getThreadPoolNumTasksPending();
	}
	
	public int getThreadPoolSize() throws SQLException {
		return dataSource.getThreadPoolSize();
	}
	
	public int getUnreturnedConnectionTimeout() {
		return dataSource.getUnreturnedConnectionTimeout();
	}
	
	public long getUpTimeMillis(String username, String password)
			throws SQLException {
		return dataSource.getUpTimeMillis(username, password);
	}
	
	public long getUpTimeMillisDefaultUser() throws SQLException {
		return dataSource.getUpTimeMillisDefaultUser();
	}
	
	public String getUser() {
		return dataSource.getUser();
	}
	
	public String getUserOverridesAsString() {
		return dataSource.getUserOverridesAsString();
	}
	
	public void hardReset() {
		dataSource.hardReset();
	}
	
	public int hashCode() {
		return dataSource.hashCode();
	}
	
	public boolean isAutoCommitOnClose() {
		return dataSource.isAutoCommitOnClose();
	}
	
	public boolean isBreakAfterAcquireFailure() {
		return dataSource.isBreakAfterAcquireFailure();
	}
	
	public boolean isDebugUnreturnedConnectionStackTraces() {
		return dataSource.isDebugUnreturnedConnectionStackTraces();
	}
	
	public boolean isForceIgnoreUnresolvedTransactions() {
		return dataSource.isForceIgnoreUnresolvedTransactions();
	}
	
	public boolean isTestConnectionOnCheckin() {
		return dataSource.isTestConnectionOnCheckin();
	}
	
	public boolean isTestConnectionOnCheckout() {
		return dataSource.isTestConnectionOnCheckout();
	}
	
	public boolean isUsesTraditionalReflectiveProxies() {
		return dataSource.isUsesTraditionalReflectiveProxies();
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		dataSource.removePropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(String propName,
			PropertyChangeListener pcl) {
		dataSource.removePropertyChangeListener(propName, pcl);
	}
	
	public void removeVetoableChangeListener(VetoableChangeListener vcl) {
		dataSource.removeVetoableChangeListener(vcl);
	}
	
	public void resetPoolManager() {
		dataSource.resetPoolManager();
	}
	
	public void resetPoolManager(boolean close_checked_out_connections) {
		dataSource.resetPoolManager(close_checked_out_connections);
	}
	
	public String sampleLastAcquisitionFailureStackTrace(String username,
			String password) throws SQLException {
		return dataSource.sampleLastAcquisitionFailureStackTrace(username,
				password);
	}
	
	public String sampleLastAcquisitionFailureStackTraceDefaultUser()
			throws SQLException {
		return dataSource.sampleLastAcquisitionFailureStackTraceDefaultUser();
	}
	
	public String sampleLastCheckinFailureStackTrace(String username,
			String password) throws SQLException {
		return dataSource
				.sampleLastCheckinFailureStackTrace(username, password);
	}
	
	public String sampleLastCheckinFailureStackTraceDefaultUser()
			throws SQLException {
		return dataSource.sampleLastCheckinFailureStackTraceDefaultUser();
	}
	
	public String sampleLastCheckoutFailureStackTrace(String username,
			String password) throws SQLException {
		return dataSource.sampleLastCheckoutFailureStackTrace(username,
				password);
	}
	
	public String sampleLastCheckoutFailureStackTraceDefaultUser()
			throws SQLException {
		return dataSource.sampleLastCheckoutFailureStackTraceDefaultUser();
	}
	
	public String sampleLastConnectionTestFailureStackTrace(String username,
			String password) throws SQLException {
		return dataSource.sampleLastConnectionTestFailureStackTrace(username,
				password);
	}
	
	public String sampleLastConnectionTestFailureStackTraceDefaultUser()
			throws SQLException {
		return dataSource
				.sampleLastConnectionTestFailureStackTraceDefaultUser();
	}
	
	public String sampleLastIdleTestFailureStackTrace(String username,
			String password) throws SQLException {
		return dataSource.sampleLastIdleTestFailureStackTrace(username,
				password);
	}
	
	public String sampleLastIdleTestFailureStackTraceDefaultUser()
			throws SQLException {
		return dataSource.sampleLastIdleTestFailureStackTraceDefaultUser();
	}
	
	public String sampleStatementCacheStatus(String username, String password)
			throws SQLException {
		return dataSource.sampleStatementCacheStatus(username, password);
	}
	
	public String sampleStatementCacheStatusDefaultUser() throws SQLException {
		return dataSource.sampleStatementCacheStatusDefaultUser();
	}
	
	public String sampleThreadPoolStackTraces() throws SQLException {
		return dataSource.sampleThreadPoolStackTraces();
	}
	
	public String sampleThreadPoolStatus() throws SQLException {
		return dataSource.sampleThreadPoolStatus();
	}
	
	public void setAcquireIncrement(int acquireIncrement) {
		dataSource.setAcquireIncrement(acquireIncrement);
	}
	
	public void setAcquireRetryAttempts(int acquireRetryAttempts) {
		dataSource.setAcquireRetryAttempts(acquireRetryAttempts);
	}
	
	public void setAcquireRetryDelay(int acquireRetryDelay) {
		dataSource.setAcquireRetryDelay(acquireRetryDelay);
	}
	
	public void setAutoCommitOnClose(boolean autoCommitOnClose) {
		dataSource.setAutoCommitOnClose(autoCommitOnClose);
	}
	
	public void setAutomaticTestTable(String automaticTestTable) {
		dataSource.setAutomaticTestTable(automaticTestTable);
	}
	
	public void setBreakAfterAcquireFailure(boolean breakAfterAcquireFailure) {
		dataSource.setBreakAfterAcquireFailure(breakAfterAcquireFailure);
	}
	
	public void setCheckoutTimeout(int checkoutTimeout) {
		dataSource.setCheckoutTimeout(checkoutTimeout);
	}
	
	public void setConnectionCustomizerClassName(
			String connectionCustomizerClassName) {
		dataSource
				.setConnectionCustomizerClassName(connectionCustomizerClassName);
	}
	
	public void setConnectionPoolDataSource(
			ConnectionPoolDataSource connectionPoolDataSource)
			throws PropertyVetoException {
		dataSource.setConnectionPoolDataSource(connectionPoolDataSource);
	}
	
	public void setConnectionTesterClassName(String connectionTesterClassName)
			throws PropertyVetoException {
		dataSource.setConnectionTesterClassName(connectionTesterClassName);
	}
	
	public void setDataSourceName(String dataSourceName) {
		dataSource.setDataSourceName(dataSourceName);
	}
	
	public void setDebugUnreturnedConnectionStackTraces(
			boolean debugUnreturnedConnectionStackTraces) {
		dataSource
				.setDebugUnreturnedConnectionStackTraces(debugUnreturnedConnectionStackTraces);
	}
	
	public void setDescription(String description) {
		dataSource.setDescription(description);
	}
	
	public void setDriverClass(String driverClass) throws PropertyVetoException {
		dataSource.setDriverClass(driverClass);
	}
	
	public void setFactoryClassLocation(String factoryClassLocation) {
		dataSource.setFactoryClassLocation(factoryClassLocation);
	}
	
	public void setForceIgnoreUnresolvedTransactions(
			boolean forceIgnoreUnresolvedTransactions) {
		dataSource
				.setForceIgnoreUnresolvedTransactions(forceIgnoreUnresolvedTransactions);
	}
	
	public void setIdentityToken(String identityToken) {
		dataSource.setIdentityToken(identityToken);
	}
	
	public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
		dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
	}
	
	public void setInitialPoolSize(int initialPoolSize) {
		dataSource.setInitialPoolSize(initialPoolSize);
	}
	
	public void setJdbcUrl(String jdbcUrl) {
		dataSource.setJdbcUrl(jdbcUrl);
	}
	
	public void setMaxAdministrativeTaskTime(int maxAdministrativeTaskTime) {
		dataSource.setMaxAdministrativeTaskTime(maxAdministrativeTaskTime);
	}
	
	public void setMaxConnectionAge(int maxConnectionAge) {
		dataSource.setMaxConnectionAge(maxConnectionAge);
	}
	
	public void setMaxIdleTime(int maxIdleTime) {
		dataSource.setMaxIdleTime(maxIdleTime);
	}
	
	public void setMaxIdleTimeExcessConnections(int maxIdleTimeExcessConnections) {
		dataSource
				.setMaxIdleTimeExcessConnections(maxIdleTimeExcessConnections);
	}
	
	public void setMaxPoolSize(int maxPoolSize) {
		dataSource.setMaxPoolSize(maxPoolSize);
	}
	
	public void setMaxStatements(int maxStatements) {
		dataSource.setMaxStatements(maxStatements);
	}
	
	public void setMaxStatementsPerConnection(int maxStatementsPerConnection) {
		dataSource.setMaxStatementsPerConnection(maxStatementsPerConnection);
	}
	
	public void setMinPoolSize(int minPoolSize) {
		dataSource.setMinPoolSize(minPoolSize);
	}
	
	public void setNumHelperThreads(int numHelperThreads) {
		dataSource.setNumHelperThreads(numHelperThreads);
	}
	
	public void setOverrideDefaultPassword(String overrideDefaultPassword) {
		dataSource.setOverrideDefaultPassword(overrideDefaultPassword);
	}
	
	public void setOverrideDefaultUser(String overrideDefaultUser) {
		dataSource.setOverrideDefaultUser(overrideDefaultUser);
	}
	
	public void setPassword(String password) {
		dataSource.setPassword(password);
	}
	
	public void setPreferredTestQuery(String preferredTestQuery) {
		dataSource.setPreferredTestQuery(preferredTestQuery);
	}
	
	public void setProperties(Properties properties) {
		dataSource.setProperties(properties);
	}
	
	public void setPropertyCycle(int propertyCycle) {
		dataSource.setPropertyCycle(propertyCycle);
	}
	
	public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
		dataSource.setTestConnectionOnCheckin(testConnectionOnCheckin);
	}
	
	public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) {
		dataSource.setTestConnectionOnCheckout(testConnectionOnCheckout);
	}
	
	public void setUnreturnedConnectionTimeout(int unreturnedConnectionTimeout) {
		dataSource.setUnreturnedConnectionTimeout(unreturnedConnectionTimeout);
	}
	
	public void setUser(String user) {
		dataSource.setUser(user);
	}
	
	public void setUserOverridesAsString(String userOverridesAsString)
			throws PropertyVetoException {
		dataSource.setUserOverridesAsString(userOverridesAsString);
	}
	
	public void setUsesTraditionalReflectiveProxies(
			boolean usesTraditionalReflectiveProxies) {
		dataSource
				.setUsesTraditionalReflectiveProxies(usesTraditionalReflectiveProxies);
	}
	
	public void softReset(String username, String password) throws SQLException {
		dataSource.softReset(username, password);
	}
	
	public void softResetAllUsers() throws SQLException {
		dataSource.softResetAllUsers();
	}
	
	public void softResetDefaultUser() throws SQLException {
		dataSource.softResetDefaultUser();
	}
	
	public String toString() {
		return dataSource.toString();
	}

	@Override
	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getExtensions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStatementDestroyerNumActiveThreads() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumConnectionsInUse(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumConnectionsInUseAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumConnectionsInUseDefaultUser() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumConnectionsWithDeferredDestroyStatements(String arg0, String arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumConnectionsWithDeferredDestroyStatementsAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumConnectionsWithDeferredDestroyStatementsDefaultUser() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumDeferredDestroyStatements(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumDeferredDestroyStatementsAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumDeferredDestroyStatementsDefaultUser() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumIdleThreads() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumTasksPending() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStatementDestroyerNumThreads() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String sampleStatementDestroyerStackTraces() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sampleStatementDestroyerStatus() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setExtensions(Map arg0) {
		// TODO Auto-generated method stub
		
	}
}

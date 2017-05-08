cd $AJAKK_HOME
cp $AJAKK_HOME/lib/gwt-dev.jar $AJAKK_HOME/war/WEB-INF/lib/
echo "Compiling..."
ant default
echo "Removing gwt-dev.jar file from war/WEB-IND/lib..."
rm $AJAKK_HOME/war/WEB-INF/lib/gwt-dev.jar
echo "Deploying Ajakk.war to KWT server..."
scp Ajakk.war raf@kwt:/opt/tomcat7/webapps/
echo "Ajakk.war was successfully deployed."
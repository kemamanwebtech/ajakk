cd $AJAKK_HOME
#cp $AJAKK_HOME/lib/gwt-dev.jar $AJAKK_HOME/war/WEB-INF/lib/
#cp $AJAKK_HOME/lib/gwt-servlet.jar $AJAKK_HOME/war/WEB-INF/lib/
echo "Compiling..."
ant default
#cho "Removing gwt-dev.jar file from war/WEB-IND/lib..."
#rm $AJAKK_HOME/war/WEB-INF/lib/gwt-dev.jar
#rm $AJAKK_HOME/war/WEB-INF/lib/gwt-servlet.jar
echo "Deploying Ajakk_new.war to KWT server..."
scp Ajakk_new.war raf@145.239.86.102:/opt/apache-tomcat-8.5.20/webapps
echo "Ajakk_new.war was successfully deployed."
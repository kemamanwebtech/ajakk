cd $AJAKK_HOME
#ant clean
ant default
echo "Deploying Ajakk.war to KWT server..."
scp Ajakk.war raf@kwt:/opt/tomcat7/webapps/
echo "Ajakk.war was successfully deployed."
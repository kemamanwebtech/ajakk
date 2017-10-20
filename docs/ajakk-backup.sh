#!/bin/bash
# 

Database credentials
 

user="root"
 password="***"
 
host="localhost"
 
db_name="ajakk"


# Other options
 

backup_path="/home/seri/ajakk-backup"
 

date=$(date +"%d-%b-%Y")


# Set default file permissions
 

umask 177


# Dump database into SQL file
 

mysqldump --user=$user --password=$password --host=$host $db_name > $backup_path/$db_name-$date.sql

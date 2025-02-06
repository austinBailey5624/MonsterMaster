# Starts a docker container
docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=secret -p 3306:3306 -d mysql:latest

# put the setup file in the docker container
 docker cp ServerSetup.sql my-mysql:/ServerSetup.sql

# access the mySQL shell for the container
 docker exec -it my-mysql mysql -uroot -p

# inside mySQL shell
source /ServerSetup.sql

CREATE USER 'admin'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%'
FLUSH PRIVILEGES

# Leave the mySQL shell
exit

# execute Docker as admin
docker exec -it my-mysql mysql -u admin -p

# stop the container without deleting it
docker stop my-mysql

# start it back up again
docker start my-mysql
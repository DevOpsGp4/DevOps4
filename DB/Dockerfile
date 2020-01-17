# Use the latest MySQL image
FROM mysql
# Set the working directory
WORKDIR /tmp
# Copy all the files to the working directory of the container
COPY WorldDb/*.sql /tmp/
# Copy the main SQL file to docker-entrypoint-initdb.d.
# Scripts and SQL files in directory are executed on container startup.
# This is specific to MySQL Database.
COPY WorldDb/world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD example
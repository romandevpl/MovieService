# MovieService

#### Installation
 git clone https://github.com/romandevpl/MovieService.git

mvn clean package

java -jar target/app-1.0-SNAPSHOT.jar server config.yml


#### SQL vs NOSQL 
In my opinion the best way of storing the data would be SQL database.
* microservice mainly focus on CRUD operations and movie object could have one or few tables which is typical case in
 SQL database
* movies have defined structure, in case of updating in the future it would have been easy to change it (migration 
scripts)
* SQL databases are well documented, supported and have more useful management tools 
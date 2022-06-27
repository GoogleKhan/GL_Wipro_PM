# GL_Wipro_PM
Evening Batch


Mongo Db CMDs:
=================
1. Show All databases:
----------------------
$ show dbs

2. How to create a new database:
-------------------------------------
$ use <DATABASE_NAME>

3. How to check current database:
-------------------------------------
> db
Employee_DB

4. How to create a collection:
----------------------------------
> db.createCollection('Department')
{ "ok" : 1 }

5. How to delete a collection:
----------------------------------
> db.<COLLECTION_NAME>.drop()


6. How to INSERT data into a collection:
--------------------------------------------
> db.<COLLECTION_NAME>.insert(<JSON_RECORD>)

Example:
---------------
db.emp.insert({"id":103,"name":"Xyz","Address":{"city":"Lucknow","state":"up"}})

db.emp.insertMany([{"id":106,"name":"John","salary":1234.50,"address":{"city":"Queens","state":"Newyork"}},{"id":107,"name":"Riya","salary":6543.78,"address":{"city":"Plano","state":"Texas"}}])


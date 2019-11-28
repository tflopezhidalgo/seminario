import groovy.sql.Sql


def db = [url:'jdbc:hsqldb:mem:testDB', user:'seminario', password:'', driver:'org.hsqldb.jdbc.JDBCDriver']

def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

sql.execute ''
	create table PROJECT (
	id integer not null,
	name varchar(50),
	url varchar(100),
	)
	''

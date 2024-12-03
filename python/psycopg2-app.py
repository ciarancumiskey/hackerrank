import psycopg2

print("Connecting to database")
conn = psycopg2.connect(dbname="db1", user="postgres", password="AsIfIdLeaveThatHere", host="127.0.0.1", port="5432")

cur = conn.cursor()
#Remove any previous version of table1, then create a new one
cur.execute("DROP TABLE IF EXISTS table1;")
cur.execute('''CREATE TABLE table1 
    (id serial PRIMARY KEY, 
    num integer, 
    data varchar);
''')

#Populate table1 with a basic SQL query and then some string interpolation
cur.execute("INSERT INTO table1 (num, data) VALUES (%s, %s)", (44, "#BLESSED"))
SQL = 'INSERT INTO table1 (num, data) VALUES (%(num)s, %(data)s);'
data = {
    'num': 77,
    'data': '#2 driver'
}
cur.execute(SQL, data)
SQL = 'INSERT INTO table1 (num, data) VALUES (%(num)s, %(data)s);'
data = {
    'num': 33,
    'data': 'MAX POWER'
}
cur.execute(SQL, data)
#Return the results from the populated table
cur.execute("SELECT * FROM table1;")
for record in cur:
    print(record)
#Commit the transaction and then close the connection to the database
conn.commit()
cur.close()
conn.close()
print("Finished")
This is a simple reproducer project to demonstrate an issue with the default `codeql database create` command when the gradle project defines custom source sets. The `customTest` source directory is not, by default, being included in the codeql database. 
This is indicated by running the `generate_db_and_query.sh` file which returns:
```
|      c       |    col1    |
+--------------+------------+
| Main         | Is a Class |
| StandardTest | Is a Class |
```

The query simply selects all classes in the sources, but the "correct" result would be:

```
|      c       |    col1    |
+--------------+------------+
| Main         | Is a Class |
| StandardTest | Is a Class |
| StandardTest | Is a Class |
```

Which is the result if you modify the database create command to be:  `codeql database create custom-sources-gradle --language=java --overwrite`

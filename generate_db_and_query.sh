codeql database create custom-sources-gradle --language=java --overwrite
codeql query run --database=custom-sources-gradle --output=FoundClasses.bqrs FoundClasses.ql
codeql bqrs decode FoundClasses.bqrs
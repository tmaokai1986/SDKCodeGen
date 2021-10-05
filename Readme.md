main:io.swagger.codegen.SwaggerCodegen

command argument:
    generate
    -i
    swagger.json
    -l
    custom-java
    --library
    custom
    -o
    target/samples/custom/pestore/java
    --additional-properties
    invokerPackage=xyz.lockon.client,apiPackage=xyz.lockon.client.api,modelPackage=xyz.lockon.client.model,groupId=xyz.lockon,artifactId=java-client-example
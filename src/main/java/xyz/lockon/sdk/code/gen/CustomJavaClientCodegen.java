package xyz.lockon.sdk.code.gen;

import io.swagger.codegen.SupportingFile;
import io.swagger.codegen.languages.JavaClientCodegen;

public class CustomJavaClientCodegen extends JavaClientCodegen {
    public CustomJavaClientCodegen() {
        super();
        this.supportedLibraries.put("custom", "HTTP client: with custom sdk.");
    }

    @Override
    public String getName() {
        return "custom-java";
    }

    @Override
    public void processOpts() {
        if ("custom".equals(getLibrary())) {
            additionalProperties.put("jackson", "true");
        }
        super.processOpts();
        final String invokerFolder = (sourceFolder + '/' + invokerPackage).replace(".", "/");
        final String authFolder = (sourceFolder + '/' + invokerPackage + ".auth").replace(".", "/");
        if ("custom".equals(getLibrary())) {
            supportingFiles.add(new SupportingFile("auth/Authentication.mustache", authFolder, "Authentication.java"));
            supportingFiles.add(new SupportingFile("StringUtil.mustache", invokerFolder, "StringUtil.java"));
            supportingFiles.add(new SupportingFile("apiException.mustache", invokerFolder, "ApiException.java"));
            supportingFiles.add(new SupportingFile("Configuration.mustache", invokerFolder, "Configuration.java"));
            supportingFiles.add(new SupportingFile("Pair.mustache", invokerFolder, "Pair.java"));
            supportingFiles.add(new SupportingFile("auth/Authentication.mustache", authFolder, "Authentication.java"));
        }
    }
}

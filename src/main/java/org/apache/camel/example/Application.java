package org.apache.camel.example;

import org.apache.camel.dsl.yaml.YamlRoutesBuilderLoader;
import org.apache.camel.dsl.yaml.common.YamlDeserializationMode;
import org.apache.camel.main.BaseMainSupport;
import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;

public class Application {
    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.addMainListener(new MainListenerSupport() {
            @Override
            public void beforeConfigure(BaseMainSupport main) {
                main.getCamelContext().getGlobalOptions().put(
                    YamlRoutesBuilderLoader.DESERIALIZATION_MODE,
                    YamlDeserializationMode.FLOW.name());
            }
        });
        main.run(args);
    }
}

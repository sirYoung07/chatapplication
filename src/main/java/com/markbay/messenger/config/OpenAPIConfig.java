package com.markbay.messenger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(name = "OnadiranAfeezBayonle", email = "onadiranbayonle358@gmail.com"),
        description = "Documentation for Real Time Chat Application",
        title = "OpenApi Specification - Onadiran Afeez",
        version = "1.0",
        license = @License(name = "???", url = "??")
    ),
    servers = {
        @Server(description = "local ENV", url = "http://localhost:8081"),
        @Server(description = "Testing ENV", url = "?????")
    }
)
 class OpenAPIConfig {

}

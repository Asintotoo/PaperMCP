# PaperMCP

**PaperMCP** is a Minecraft Paper plugin designed to implement the Model Context Protocol (MCP) for interfacing with Minecraft servers running PaperMC. The goal of this project is to provide seamless integration with MCP, allowing AI Models to interact with the Minecraft server in a standardized way, following the MCP specification.

The project is still in its early stages and is currently in **BETA**. As such, many features might not work as expected or may be incomplete. The long-term goal is to expand the plugin’s functionality as much as possible to cover the majority of features offered by a Minecraft server, allowing for full interaction with the server through an external AI model or tool.

## Features

- Implements **Model Context Protocol (MCP)** for Minecraft PaperMC servers.
- Exposes server data and functionality to external systems through a standardized protocol.
- Currently in **BETA**; expect bugs and incomplete features.

## Installation

To install **PaperMCP** on your Minecraft server, follow these simple steps:

1. Download the latest **PaperMCP** plugin `.jar` file from [here](https://github.com/Asintotoo/PaperMCP/releases).
2. Place the `.jar` file in the `plugins` folder of your PaperMC server.
3. Start the server. Upon startup, **PaperMCP** will automatically initialize.

### Configuration

Once the plugin is installed, you can adjust various settings in the `config.yml` file, located in the plugin’s folder.

The most important configuration option is the `port`, which defines the port on which the Streamable HTTP server for MCP will be running. You can set this to any available port on your server. Additionally, you can configure other parameters such as the server’s name and endpoint URL.

### Connecting a Client to the MCP Server

To use **PaperMCP** from any MCP client, you will need to add a new MCP remote server with the following format for the URL:

```
{server-ip}:{port}/{endpoint}
```

- `{server_ip}`: The IP address of the Minecraft server.
- `{port}`: The port defined in the `config.yml` file.
- `{endpoint}`: The endpoint configured in `config.yml` (by default, this is set to `/mcp`).

For example, if your server’s IP is `127.0.0.1`, the port is `15000`, and the default endpoint is `/mcp`, the URL to connect would be:
```
127.0.0.1:15000/mcp
```

If your client does not support Remote Server natively, try using [mcp-remote](https://github.com/geelen/mcp-remote)

## Contribution

We welcome and encourage contributions to the **PaperMCP** project. If you would like to help improve the plugin, add new features, or fix bugs, feel free to fork the repository, create a pull request, and contribute your changes.

## Credits

- **[Asintoto](https://github.com/Asintotoo)**: Original idea and programming.
- **[MCP Declarative Java SDK](https://github.com/codeboyzhou/mcp-declarative-java-sdk)**: A lightweight library for working with MCP in Java, without which this plugin would not have been possible.

We thank the MCP Declarative team for their work, which has been essential to the creation of this plugin.

## License

This project is licensed under the terms of the MIT License.



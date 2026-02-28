# FlyFeather Plugin

A simple Minecraft plugin that gives players a feather on join which grants temporary flight.

## Features
- Players receive a Fly Feather on joining the server
- Right-click the feather to activate 10 seconds of flight
- 5 second cooldown between activations
- Custom item with display name and model data

## Installation
1. Build the plugin using Maven: `mvn clean package`
2. Copy the generated JAR file from `target/flyfeather-1.0.jar` to your server's `plugins` folder
3. Restart your server

## Commands
- `/flyfeather reload` - Reloads the plugin configuration

## Permissions
- `flyfeather.use` - Allows use of the Fly Feather (default: true)

## Configuration
No configuration file is needed. The plugin works out of the box.

## Build Status
This plugin is automatically built using GitHub Actions whenever changes are pushed to the repository.
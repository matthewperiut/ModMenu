# ModMenu
~~Hard to be more descriptive than that.~~ It enriches the standard Minecraft menu with an interface displaying a one-dimensional array of modifications



A picture's worth 2 words

![68747470733a2f2f692e696d6775722e636f6d2f4a4b4561746f752e706e67](https://github.com/calmilamsy/ModMenu/assets/8781747/703667a6-1e86-441e-8529-a237cdfa5b8f "Mod Menu")

### Installation on Beta 1.7.3
1. Download and install [MultiMC](https://multimc.org/#Download) if you haven't already.
1. If you haven't already, press "create instance", and press "import from zip", and paste the following URL into the text field: https://github.com/calmilamsy/Cursed-Fabric-MultiMC/archive/master.zip
1. Download ModMenu from the [releases page](https://github.com/calmilamsy/ModMenu/releases).
1. Click on your new MultiMC instance and click "edit instance" on the right. Click "loader mods" then "add", and navigate to the mod you just downloaded, and press OK.

### Developers:
- Mod Menu is on maven at: https://maven.fabricmc.net/io/github/prospector/modmenu/ModMenu/
- The icon comes from the icon specified in your fabric.mod.json (as per the spec)
- Clientside-only and API badges are defined as custom objects in your fabric.mod.json as such:
```json
"custom": {
    "modmenu:api": true,
    "modmenu:clientsideOnly": true
}
```
- Mod parenting is used to display a mod as a child of another one. This is meant to be used for mods divided into different modules. The following element in a fabric.mod.json will define the mod as a child of the mod 'flamingo':
```json
"custom": {
    "modmenu:parent": "flamingo"
}
```
- ModMenuAPI
    - To use the API, implement the ModMenuApi interface on a class and add that as an entry point of type "modmenu" in your fabric.mod.json as such:
  ```json
  "entrypoints": {
	"modmenu": [ "com.example.mod.ExampleModMenuApiImpl" ]
  }
  ```
    - Features
        - Mods can provide a Screen factory to provide a custom config screen to open with the config button. Implement the `getConfigScreenFactory` method in your API implementation.

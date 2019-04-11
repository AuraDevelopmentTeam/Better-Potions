# [Better Potions](https://github.com/AuraDevelopmentTeam/Better-Potions)

[![Current Version](https://badge.fury.io/gh/AuraDevelopmentTeam%2FBetter-Potions.svg)](https://maven.aura-dev.team/service/rest/repository/browse/auradev-releases/dev/aura/betterpotions/Better-Potions/)
[![Build Status](https://gitlab.aura-dev.team/AuraDev/Better-Potions/badges/master/build.svg)](https://gitlab.aura-dev.team/AuraDev/Better-Potions/pipelines)
[![Coverage Report](https://gitlab.aura-dev.team/AuraDev/Better-Potions/badges/master/coverage.svg)](https://gitlab.aura-dev.team/AuraDev/Better-Potions/pipelines)
[![License](https://img.shields.io/github/license/AuraDevelopmentTeam/Better-Potions.svg)](https://github.com/AuraDevelopmentTeam/Better-Potions/blob/master/LICENSE)

Allows players to choose their own potion effects!

## [Permissions](https://github.com/AuraDevelopmentTeam/Better-Potions/blob/master/src/main/java/dev/aura/betterpotions/Utilities/Permissions.java)
- [**Click me**](https://github.com/AuraDevelopmentTeam/Better-Potions/blob/master/src/main/java/dev/aura/betterpotions/Utilities/Permissions.java) to view permissions for Better Potions.

## [Configuration](https://paste.gg/p/anonymous/bcb52828b3fa4c619dfdb25f4b16907e)
- [**Click me**](https://paste.gg/p/anonymous/bcb52828b3fa4c619dfdb25f4b16907e) to view the configuration for Better Potions.
- By default, all negative potions are disabled.
- All potions can be enabled or disabled in the configuration.

## Features
![Alt Text](https://i.ibb.co/w0KcHRP/ezgif-1-98f3438a5b88.gif)
![Alt Text](https://i.ibb.co/bJfPZ33/ezgif-com-video-to-gif.gif)

## Downloads

You can download all builds from here:

- Ore: https://ore.spongepowered.org/AuraDevelopmentTeam/Better-Potions
- Maven:
  - Releases: https://maven.aura-dev.team/repository/auradev-releases/
  - Snapshots: https://maven.aura-dev.team/repository/auradev-snapshots/

## [Issue Reporting](https://github.com/AuraDevelopmentTeam/Better-Potions/issues)

If you found a bug or even are experiencing a crash please report it so we can fix it. Please check at first if a bug report for the issue already
[exits](https://github.com/AuraDevelopmentTeam/Better-Potions/issues). If not just create a
[new issue](https://github.com/AuraDevelopmentTeam/Better-Potions/issues/new) and fill out the form.

Please include the following:

* Minecraft version
* Better Potions version
* Sponge version/build
* Versions of any mods/plugins potentially related to the issue
* Any relevant screenshots are greatly appreciated.
* For crashes:
  * Steps to reproduce
  * latest.log (the FML log) from the log folder of the server

*(When creating a new issue please follow the template)*

## [Feature Requests](https://github.com/AuraDevelopmentTeam/Better-Potions/issues)

If you want a new feature added, go ahead an open a [new issue](https://github.com/AuraDevelopmentTeam/Better-Potions/issues/new), remove the existing form and
describe your feature the best you can. The more details you provide the easier it will be implementing it.  
You can also talk to us on [Discord](https://discord.me/bungeechat).

## Developing with our Plugin

So you want to add support or even develop an addon for our plugin then you can easily add it to your development environment! All releases get uploaded to my
maven repository. (Replace `{version}` with the appropriate version!)

### Maven

    <repositories>
        <repository>
            <id>AuraDevelopmentTeam/id>
            <url>https://maven.aura-dev.team/repository/auradev-releases/</url>
            <!--<url>https://maven.aura-dev.team/repository/auradev-snapshots/</url>-->
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>dev.aura.betterpotions</groupId>
            <artifactId>Better-Potions</artifactId>
            <version>{version}</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

### Gradle

    repositories {
        maven {
            name "AuraDevelopmentTeam"
            url "https://maven.aura-dev.team/repository/auradev-releases/"
            // url "https://maven.aura-dev.team/repository/auradev-snapshots/"
        }
    }

    dependencies {
        provided "dev.aura.betterpotions:Better-Potions:{version}"
    }

## Setting up a Workspace/Compiling from Source

* Clone: Clone the repository like this: `git clone --recursive https://github.com/AuraDevelopmentTeam/Better-Potions.git`
* IDE-Setup: Run [gradle] in the repository root: `./gradlew installLombok <eclipse|idea>`
* Build: Run [gradle] in the repository root: `./gradlew build`. The build will be in `build/libs`
* If obscure Gradle issues are found try running `./gradlew cleanCache clean`

## Development builds

Between each offical release there are several bleeding edge development builds, which you can also use. But be aware that they might contain unfinished
features and therefore won't work properly.

You can find the builds here: https://gitlab.aura-dev.team/AuraDev/Better-Potions/pipelines

On the right is a download symbol, click that a dropdown will open. Select "build". Then you'll download a zip file containing all atrifacts including the
plugin jar.

## Signing

### PGP Signing

All files will be signed with PGP.  
The public key to verify it can be found in `keys/publicKey.asc`. The signatures of the files will also be found in the maven.

### Jar Signing

All jars from all official download sources will be signed. The signature will always have a SHA-1 hash of `2238d4a92d81ab407741a2fdb741cebddfeacba6` and you
are free to verify it.

## License

Better Potions is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.html)

## Random Quote
> Walking on water and developing software are both easy and both are frozen.
>
> - <cite>Edward V Berard</cite>

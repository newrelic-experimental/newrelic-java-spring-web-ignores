<a href="https://opensource.newrelic.com/oss-category/#new-relic-experimental"><picture><source media="(prefers-color-scheme: dark)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/dark/Experimental.png"><source media="(prefers-color-scheme: light)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"><img alt="New Relic Open Source experimental project banner." src="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"></picture></a>


![GitHub forks](https://img.shields.io/github/forks/newrelic-experimental/newrelic-java-spring-web-ignores?style=social)
![GitHub stars](https://img.shields.io/github/stars/newrelic-experimental/newrelic-java-spring-web-ignores?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/newrelic-experimental/newrelic-java-spring-web-ignores?style=social)

![GitHub all releases](https://img.shields.io/github/downloads/newrelic-experimental/newrelic-java-spring-web-ignores/total)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/newrelic-experimental/newrelic-java-spring-web-ignores)
![GitHub last commit](https://img.shields.io/github/last-commit/newrelic-experimental/newrelic-java-spring-web-ignores)
![GitHub Release Date](https://img.shields.io/github/release-date/newrelic-experimental/newrelic-java-spring-web-ignores)


![GitHub issues](https://img.shields.io/github/issues/newrelic-experimental/newrelic-java-spring-web-ignores)
![GitHub issues closed](https://img.shields.io/github/issues-closed/newrelic-experimental/newrelic-java-spring-web-ignores)
![GitHub pull requests](https://img.shields.io/github/issues-pr/newrelic-experimental/newrelic-java-spring-web-ignores)
![GitHub pull requests closed](https://img.shields.io/github/issues-pr-closed/newrelic-experimental/newrelic-java-spring-web-ignores)


# New Relic Java Instrumentation for Spring Web

Provides instrumentation to ignore selected URIs based upon the actual URI or a regular expression.

## Installation

To use this instrumentation.
1. Download the latest release.
2. In the New Relic Java Agent directory (directory containing newrelic.jar), create a directory named extensions if it doe not already exist.
3. Copy the jars into the extensions directory.
4. Restart the application.

## Configuration
To configure Spring-Web-Ignores
1. Edit newrelic.yml
2. The best place the configuration is towards the end of the file and just before # Application Environments 
3. The configuration starts with **Spring-Ignores:** and it must be indented two spaces. 
4. If you would like to ignore specific URI (exact matches) then enter them as a comma separated list.  Start the line with four spaces and **urls:**
5. If you want to ignore URIs based upon a Java regular expression then enter the patterns as a comma separated list and start the line with four spaces and **regex:**
6. Save newrelic.yml.  Changes will take place in a minute or so.

Note that the configuration is dynamic and if you edit the settings the changes will take effect within a minute or so.

Example:

&nbsp;&nbsp;Spring-Ignores:   
&nbsp;&nbsp;&nbsp;&nbsp;urls: /hello   
&nbsp;&nbsp;&nbsp;&nbsp;regex: /help/.*,/about/.*   
  
In the above example, the URI /hello will be ignored (but not /hello/Tom) and any URI that starts with /help/ or /about/   

## Building

If you make changes to the instrumentation code and need to build the instrumentation jars, follow these steps
1. Set environment variable NEW_RELIC_EXTENSIONS_DIR.  Its value should be the directory where you want to build the jars (i.e. the extensions directory of the Java Agent).
2. Build one or all of the jars.   
   a. To build one jar, run the command:  gradlew _moduleName_:clean  _moduleName_:install    
   b. To build all jars, run the command: gradlew clean install
3. Restart the application

## Support

New Relic has open-sourced this project. This project is provided AS-IS WITHOUT WARRANTY OR DEDICATED SUPPORT. Issues and contributions should be reported to the project here on GitHub.

>We encourage you to bring your experiences and questions to the [Explorers Hub](https://discuss.newrelic.com) where our community members collaborate on solutions and new ideas.

## Contributing

We encourage your contributions to improve Salesforce Commerce Cloud for New Relic Browser! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project. If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company, please drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).

## License

New Relic Java Instrumentation for Spring Web Ignores is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.

>[If applicable: New Relic Java Instrumentation for CORBA also uses source code from third-party libraries. You can find full details on which libraries are used and the terms under which they are licensed in the third-party notices document.]
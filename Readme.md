# omni-coveragereporter-lein


[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=omni-coveragereporter-lein&color=informational)](https://github.com/jesperancinhaorg/omni-coveragereporter-lein)

[![GitHub release](https://img.shields.io/github/release/JEsperancinhaOrg/omni-coveragereporter-lein.svg)](#)
[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.plugins/omni-coveragereporter-lein)](https://mvnrepository.com/artifact/org.jesperancinha.plugins/omni-coveragereporter-lein)
[![Sonatype Nexus](https://img.shields.io/nexus/r/https/oss.sonatype.org/org.jesperancinha.plugins/omni-coveragereporter-lein.svg)](https://search.maven.org/artifact/org.jesperancinha.plugins/omni-coveragereporter-lein)

[![javadoc](https://javadoc.io/badge2/org.jesperancinha.plugins/omni-coveragereporter-lein/javadoc.svg)](https://javadoc.io/doc/org.jesperancinha.plugins/omni-coveragereporter-lein)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![Snyk Score](https://snyk-widget.herokuapp.com/badge/mvn/org.jesperancinha.plugins/omni-coveragereporter-lein/badge.svg)](https://github.com/JEsperancinhaOrg/omni-coveragereporter-lein)

[![omni-coveragereporter-lein](https://github.com/JEsperancinhaOrg/omni-coveragereporter-lein/actions/workflows/clojure.yml/badge.svg)](https://github.com/JEsperancinhaOrg/omni-coveragereporter-lein/actions/workflows/clojure.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/c1670295f0f544b4b6cd50a5aacd7337)](https://www.codacy.com/gh/JEsperancinhaOrg/omni-coveragereporter-lein/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JEsperancinhaOrg/omni-coveragereporter-lein&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/e2f15ed4-08ab-4310-83d5-2287571276c0)](https://codebeat.co/projects/github-com-jesperancinhaorg-omni-coveragereporter-lein-main)
[![BCH compliance](https://bettercodehub.com/edge/badge/JEsperancinhaOrg/omni-coveragereporter-lein?branch=main)](https://bettercodehub.com/results/JEsperancinhaOrg/omni-coveragereporter-lein)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/c1670295f0f544b4b6cd50a5aacd7337)](https://www.codacy.com/gh/JEsperancinhaOrg/omni-coveragereporter-lein/dashboard?utm_source=github.com&utm_medium=referral&utm_content=JEsperancinhaOrg/omni-coveragereporter-lein&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/JEsperancinhaOrg/omni-coveragereporter-lein/badge.svg?branch=main)](https://coveralls.io/github/JEsperancinhaOrg/omni-coveragereporter-lein?branch=main)
[![codecov](https://codecov.io/gh/JEsperancinhaOrg/omni-coveragereporter-lein/branch/main/graph/badge.svg?token=Fub9ZAHXsW)](https://codecov.io/gh/JEsperancinhaOrg/omni-coveragereporter-lein)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/airflights-clojure.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/airflights-clojure.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/airflights-clojure.svg)](#)

---

## Technologies used

Please check the [TechStack.md](TechStack.md) file for details.

## Introduction

Omni reporter for [Lein](https://leiningen.org/) projects.	This project is still on a very experimental stage. It essentially provides the same functionality as other two plugins I've made, [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=omni-coveragereporter-maven-plugin&color=informational)](https://github.com/JEsperancinhaOrg/omni-reporter-maven-plugin) and [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=omni-coveragereporter-gradle-plugin&color=informational)](https://github.com/JEsperancinhaOrg/omni-reporter-gradle-plugin), with some exceptions.

The plugin is still not ready for multi-module projects. It differs between these other two projects because Lein differs quite a lot from Gradle and Maven. The functionality to search for extra reports and sources is there though, so you can try and use that for multi-module projects.

The configuration should be done in the same way as the maven and gradle plugins, except that it is done in this case in a json file called `omni-config.json`:

```json
{
  "coverallsUrl": "https://coveralls.io/api/v1/jobs",
  "codacyUrl": "https://api.codacy.com",
  "codecovUrl": "https://codecov.io/upload",
  "sourceEncoding": "UTF-8",
  "projectBaseDir": "projectDir",
  "failOnNoEncoding": false,
  "failOnUnknown": false,
  "failOnReportNotFound": false,
  "failOnReportSendingError": false,
  "failOnXmlParsingError": false,
  "disableCoveralls": false,
  "disableCodacy": false,
  "disableCodecov": false,
  "ignoreTestBuildDirectory": false,
  "useCoverallsCount": true,
  "branchCoverage": false,
  "fetchBranchNameFromEnv": false,
  "coverallsToken": null,
  "codecovToken": null,
  "codacyToken": null,
  "codacyApiToken": null,
  "codacyOrganizationProvider": null,
  "codacyUserName": null,
  "codacyProjectName": null,
  "extraSourceFolder": "sampledir1,sampledir2",
  "extraReportFolders": "sampledir1,sampledir2",
  "reportRejectList": "reportFileName1, reportFileName2"
}
```

The filename is fixed to be `omni-config.json` for the time being.

---

## Releases

Keep up to date with current releases by checking the [ReleaseNotes.md](./ReleaseNotes.md) file.

---

## Usage

FIXME: Use this for user-level plugins:

Put `[omni-coveragereporter-lein "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your `:user`
profile.

FIXME: Use this for project-level plugins:

Put `[omni-coveragereporter-lein "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.

FIXME: and add an example usage that actually makes sense:

    $ lein omni-coveragereporter-lein

---

## Deploying in Nexus/Maven Central

```shell
export GPG_TTY=$(tty)
lein deploy
```

## References

-   [Nexus Repository Manager](https://oss.sonatype.org/#welcome)
-   [How-to: Clojure libraries on Maven Central](https://www.juxt.pro/blog/maven-central)
-   [Clojure Bits: Working with JSON](https://alexanderoloo.com/blog/2019/09/10/clojure-bits-working-with-json.html)
-   [Clojure test coverage with Eftest and Cloverage](https://bogoyavlensky.com/blog/eftest-cloverage/)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)

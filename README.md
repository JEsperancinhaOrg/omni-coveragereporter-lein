# omni-coveragereporter-lein

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/omni-coveragereporter-lein)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=omni-coveragereporter-lein&color=informational)](https://github.com/jesperancinhaorg/omni-coveragereporter-lein)

[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![omni-coveragereporter-lein](https://github.com/JEsperancinhaOrg/omni-coveragereporter-lein/actions/workflows/clojure.yml/badge.svg)](https://github.com/JEsperancinhaOrg/omni-coveragereporter-lein/actions/workflows/clojure.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/c1670295f0f544b4b6cd50a5aacd7337)](https://www.codacy.com/gh/JEsperancinhaOrg/omni-coveragereporter-lein/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JEsperancinhaOrg/omni-coveragereporter-lein&amp;utm_campaign=Badge_Grade)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/c1670295f0f544b4b6cd50a5aacd7337)](https://www.codacy.com/gh/JEsperancinhaOrg/omni-coveragereporter-lein/dashboard?utm_source=github.com&utm_medium=referral&utm_content=JEsperancinhaOrg/omni-coveragereporter-lein&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/JEsperancinhaOrg/omni-coveragereporter-lein/badge.svg?branch=main)](https://coveralls.io/github/JEsperancinhaOrg/omni-coveragereporter-lein?branch=main)
[![codecov](https://codecov.io/gh/JEsperancinhaOrg/omni-coveragereporter-lein/branch/main/graph/badge.svg?token=Fub9ZAHXsW)](https://codecov.io/gh/JEsperancinhaOrg/omni-coveragereporter-lein)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/airflights-clojure.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/airflights-clojure.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/airflights-clojure.svg)](#)

---

## Tech stack

---
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/clojure-50.png "Clojure")](https://clojure.org/)

---

## Introduction

Omni reporter for [Lein](https://leiningen.org/) projects.
This project is still on a very experimental stage. It essentially provides the same functionality as other two plugins I've made, [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=omni-coveragereporter-maven-plugin&color=informational)](https://github.com/JEsperancinhaOrg/omni-reporter-maven-plugin) and [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=omni-coveragereporter-gradle-plugin&color=informational)](https://github.com/JEsperancinhaOrg/omni-reporter-gradle-plugin), with some exceptions.

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

## References

- [Clojure Bits: Working with JSON](https://alexanderoloo.com/blog/2019/09/10/clojure-bits-working-with-json.html)
- [Clojure test coverage with Eftest and Cloverage](https://bogoyavlensky.com/blog/eftest-cloverage/)

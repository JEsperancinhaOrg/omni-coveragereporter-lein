# omni-coveragereporter-lein

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/omni-coveragereporter-lein)
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

## Tech stack

---
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/clojure-50.png "Clojure")](https://clojure.org/)

---

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

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/mastodon-20.png "Mastodon")](https://masto.ai/@jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
| [Sessionize](https://sessionize.com/joao-esperancinha/)
| [Spotify](https://open.spotify.com/user/jlnozkcomrxgsaip7yvffpqqm?si=b54b89eae8894960)
| [Medium](https://medium.com/@jofisaes)
| [YouTube](https://www.youtube.com/@joaoesperancinha/featured)
| [Instagram](https://www.instagram.com/joaofisaes/)
| [Buy me a coffee](https://www.buymeacoffee.com/jesperancinha)
| [Credly Badges](https://www.credly.com/users/joao-esperancinha)
| [Google Apps](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
| [Sonatype Search Repos](https://search.maven.org/search?q=org.jesperancinha)
| [Docker Images](https://hub.docker.com/u/jesperancinha)
| [Stack Overflow Profile](https://stackoverflow.com/users/3702839/joao-esperancinha)
| [Reddit](https://www.reddit.com/user/jesperancinha/)
| [Dev.TO](https://dev.to/jofisaes)
| [Hackernoon](https://hackernoon.com/@jesperancinha)
| [Code Project](https://www.codeproject.com/Members/jesperancinha)
| [BitBucket](https://bitbucket.org/jesperancinha)
| [GitLab](https://gitlab.com/jesperancinha)
| [Coursera](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
| [FreeCodeCamp](https://www.freecodecamp.org/jofisaes)
| [HackerRank](https://www.hackerrank.com/jofisaes)
| [LeetCode](https://leetcode.com/jofisaes)
| [Codebyte](https://coderbyte.com/profile/jesperancinha)
| [CodeWars](https://www.codewars.com/users/jesperancinha)
| [Code Pen](https://codepen.io/jesperancinha)
| [Hacker Earth](https://www.hackerearth.com/@jofisaes)
| [Khan Academy](https://www.khanacademy.org/profile/jofisaes)
| [Hacker News](https://news.ycombinator.com/user?id=jesperancinha)
| [InfoQ](https://www.infoq.com/profile/Joao-Esperancinha.2/)
| [LinkedIn](https://www.linkedin.com/in/joaoesperancinha/)
| [Xing](https://www.xing.com/profile/Joao_Esperancinha/cv)
| [Tumblr](https://jofisaes.tumblr.com/)
| [Pinterest](https://nl.pinterest.com/jesperancinha/)
| [Quora](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
| [VMware Spring Professional 2021](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
| [Oracle Certified Professional, Java SE 11 Programmer](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
| [Oracle Certified Professional, JEE7 Developer](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
| [IBM Cybersecurity Analyst Professional](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
| [Certified Advanced JavaScript Developer](https://cancanit.com/certified/1462/)
| [Certified Neo4j Professional](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
| [Deep Learning](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
| [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)

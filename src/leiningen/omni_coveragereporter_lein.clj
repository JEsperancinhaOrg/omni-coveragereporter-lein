(ns leiningen.omni-coveragereporter-lein
  (:require [cheshire.core :as json]
            [clojure.core]
            [clojure.java.io :as io]
            [clojure.test :refer [is]])
  (:import (java.io File FileReader)
           (org.jesperancinha.plugins.omni.reporter.processors CodacyProcessor CodecovProcessor CoverallsReportsProcessor)))

(def banner (io/resource
              "banner.txt"))

(defn omni-coveragereporter-lein
  "Omni Coverage Plugin For Leiningen Repos.
  Check https://leiningen.org/ for further details on how to use these repos"
  [_ & _]
  (println (.getCanonicalPath (clojure.java.io/file ".", "omni-config.json")))
  (println (slurp banner))
  (println "* Starting reporting...")
  (let [
        config-file (.getCanonicalPath (clojure.java.io/file ".", "omni-config.json"))
        base-dir (.getCanonicalPath (clojure.java.io/file "."))
        src-dir (.getCanonicalPath (clojure.java.io/file "src"))
        report-dir (.getCanonicalPath (clojure.java.io/file "target/coverage"))
        configuration (slurp (FileReader. config-file))
        json-config (json/decode configuration true)
        coverallsUrl (get-in json-config [:coverallsUrl])
        codacyUrl (get-in json-config [:codacyUrl])
        codecovUrl (get-in json-config [:codecovUrl])
        sourceEncoding (get-in json-config [:sourceEncoding] (or (apply str "UTF-8")))
        projectBaseDir (get-in json-config [:projectBaseDir] (or (apply str base-dir)))
        failOnNoEncoding (get-in json-config [:failOnNoEncoding])
        failOnUnknown (get-in json-config [:failOnUnknown])
        failOnReportNotFound (get-in json-config [:failOnReportNotFound])
        failOnReportSendingError (get-in json-config [:failOnReportSendingError])
        failOnXmlParsingError (get-in json-config [:failOnXmlParsingError])
        disableCoveralls (get-in json-config [:disableCoveralls])
        disableCodacy (get-in json-config [:disableCodacy])
        disableCodecov (get-in json-config [:disableCodecov])
        ignoreTestBuildDirectory (get-in json-config [:ignoreTestBuildDirectory])
        useCoverallsCount (get-in json-config [:useCoverallsCount])
        branchCoverage (get-in json-config [:branchCoverage])
        fetchBranchNameFromEnv (get-in json-config [:fetchBranchNameFromEnv])
        coverallsToken (or (get-in json-config [:coverallsToken] (or (System/getenv "COVERALLS_REPO_TOKEN") (System/getenv "COVERALLS_TOKEN"))))
        codecovToken (or (get-in json-config [:codecovToken] (System/getenv "CODECOV_TOKEN")))
        codacyToken (or (get-in json-config [:codacyToken] (System/getenv "CODACY_PROJECT_TOKEN")))
        codacyApiToken (or (get-in json-config [:codacyApiToken] (System/getenv "CODACY_API_TOKEN")))
        codacyOrganizationProvider (or (get-in json-config [:codacyOrganizationProvider] (System/getenv "CODACY_ORGANIZATION_PROVIDER")))
        codacyUserName (or (get-in json-config [:codacyUserName] (System/getenv "CODACY_USERNAME")))
        codacyProjectName (or (get-in json-config [:codacyProjectName] (System/getenv "CODACY_PROJECT_NAME")))
        extraSourceFolders (or (get-in json-config [:extraSourceFolder]) (or (apply str src-dir)))
        extraReportFolders (or (get-in json-config [:extraReportFolders]) (or (apply str report-dir)))
        reportRejectList (or (get-in json-config [:reportRejectList] (or (apply str ""))))
        ]
    (println (format "Coveralls URL: %s" coverallsUrl))
    (println (format "Codacy URL: %s" codacyUrl))
    (println (format "Codecov URL: %s" codecovUrl))
    (println (format "Coveralls token: %s" "checkToken(coverallsToken)"))
    (println (format "Codacy token: %s" "checkToken(codacyToken)"))
    (println (format "Codecov token: %s" "checkToken(codecovToken)"))
    (println (format "Disable Coveralls: %s" disableCoveralls))
    (println (format "Disable Codecov: %s" disableCodecov))
    (println (format "Disable Codacy: %s" disableCodacy))
    (println (format "Codacy API token: %s" "checkToken(codacyApiToken)"))
    (println (format "Codacy API fully configured: %s" "this.isCodacyAPIConfigured"))
    (println (format "Source Encoding: %s" sourceEncoding))
    (println (format "Parent Directory: %s" projectBaseDir))
    (println (format "failOnNoEncoding: %s" failOnNoEncoding))
    (println (format "failOnUnknown: %s" failOnUnknown))
    (println (format "failOnReportNotFound: %s" failOnReportNotFound))
    (println (format "failOnReportSendingError: %s" failOnReportSendingError))
    (println (format "failOnXmlParsingError: %s" failOnXmlParsingError))
    (println (format "disableCoveralls: %s" disableCoveralls))
    (println (format "disableCodacy: %s" disableCodacy))
    (println (format "ignoreTestBuildDirectory: %s" ignoreTestBuildDirectory))
    (println (format "branchCoverage: %s" branchCoverage))
    (println (format "useCoverallsCount: %s" useCoverallsCount))
    (println (format "extraSourceFolders: %s" extraSourceFolders))
    (println (format "extraReportFolders: %s" extraReportFolders))
    (println (format "reportRejectList: %s" reportRejectList))
    (.processReports (CoverallsReportsProcessor/createProcessor
                       coverallsToken,
                       disableCoveralls,
                       coverallsUrl,
                       projectBaseDir,
                       projectBaseDir,
                       failOnUnknown,
                       failOnReportNotFound,
                       failOnReportSendingError,
                       failOnXmlParsingError,
                       fetchBranchNameFromEnv,
                       branchCoverage,
                       ignoreTestBuildDirectory,
                       useCoverallsCount,
                       extraSourceFolders,
                       extraReportFolders
                       reportRejectList))
    (.processReports (CodacyProcessor/createProcessor
                       codacyToken,
                       codacyApiToken
                       codacyOrganizationProvider,
                       codacyUserName,
                       codacyProjectName
                       disableCodacy,
                       codacyUrl,
                       projectBaseDir,
                       projectBaseDir,
                       failOnUnknown,
                       failOnReportNotFound,
                       failOnReportSendingError,
                       failOnXmlParsingError,
                       fetchBranchNameFromEnv,
                       ignoreTestBuildDirectory,
                       extraSourceFolders,
                       extraReportFolders
                       reportRejectList))
    (.processReports (CodecovProcessor/createProcessor
                       codecovToken,
                       disableCodecov,
                       codecovUrl,
                       projectBaseDir,
                       projectBaseDir,
                       failOnUnknown,
                       failOnReportNotFound,
                       failOnReportSendingError,
                       failOnXmlParsingError,
                       ignoreTestBuildDirectory,
                       extraSourceFolders,
                       extraReportFolders
                       reportRejectList))
    (println "* Reporting Finished!")
    ))